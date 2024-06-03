package ru.kpfu.itis.bagaviev.presentation.view

import android.app.DownloadManager
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.isVisible
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaItem.ClippingConfiguration
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import coil.load
import jp.wasabeef.blurry.Blurry
import ru.kpfu.itis.bagaviev.R
import ru.kpfu.itis.bagaviev.common.base.music.BaseMusicActivity
import ru.kpfu.itis.bagaviev.common.util.extensions.foldNullability
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.databinding.ActivityMainBinding
import ru.kpfu.itis.bagaviev.navigation.Navigator
import ru.kpfu.itis.bagaviev.player.impl.presentation.broadcast_receiver.DownloadCompletionBroadcastReceiver
import ru.kpfu.itis.bagaviev.presentation.state.UiState
import ru.kpfu.itis.bagaviev.presentation.util.appComponent
import javax.inject.Inject

class MainActivity : BaseMusicActivity() {

    override val musicViewModel: MainActivityViewModel by viewModels<MainActivityViewModel> {
        appComponent.mainActivityViewModelFactory
    }

    @Inject lateinit var navigator: Navigator

    @Inject lateinit var exoPlayer: ExoPlayer

    private var viewBinding: ActivityMainBinding? = null

    private var navController: NavController? = null

    private var broadcastReceiver: DownloadCompletionBroadcastReceiver? = null

    private val writeToExternalStoragePermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()) { isGranted ->
    }

    private fun observeUiState(uiState: UiState) {
        viewBinding?.apply {
            with(uiState) {
                clipData.foldNullability(
                    onNull = {
                        exoPlayer.clearMediaItems()
                        ivBackground.load(
                            data = backgroundUri,
                            builder = {
                                allowHardware(false)
                                listener { _, result ->
                                    Blurry.with(this@MainActivity)
                                        .sampling(5)
                                        .radius(5)
                                        .from(result.drawable.toBitmap())
                                        .into(ivBackground)
                                }
                            }
                        )
                        ivBackground.isVisible = true
                    },
                    onNotNull = { clipData ->
                        val mediaItem = MediaItem.Builder()
                            .setClippingConfiguration(
                                ClippingConfiguration.Builder()
                                    .setStartPositionMs(clipData.clipStart)
                                    .setEndPositionMs(clipData.clipEnd)
                                    .build())
                            .setUri(clipData.clipUri)
                            .build()
                        exoPlayer.setMediaItem(mediaItem)
                        exoPlayer.seekTo(clipData.clipStart)
                        exoPlayer.play()
                        viewBinding?.ivBackground?.isVisible = false
                    }
                )
            }
        }
    }

    private fun observeIsPlaying(isPlaying: Boolean) {
        viewBinding?.pvVideo?.isVisible = isPlaying
        if (isPlaying) {
            exoPlayer.play()
        }
        else {
            exoPlayer.pause()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        appComponent.inject(this)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding?.root)

        viewBinding?.apply {
            pvVideo.player = exoPlayer
            exoPlayer.prepare()
        }

        with(musicViewModel) {
            uiState.observe(this@MainActivity, ::observeUiState)
            isPlayingState.observe(this@MainActivity, ::observeIsPlaying)
        }

        initNavigation()

        val broadcastReceiver = DownloadCompletionBroadcastReceiver(
            musicViewModel::onDownloadComplete
        )

        ContextCompat.registerReceiver(
            this,
            broadcastReceiver,
            IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE),
            ContextCompat.RECEIVER_EXPORTED
        )

        if (ContextCompat.checkSelfPermission(
                this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            writeToExternalStoragePermissionLauncher.launch(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        }
    }


    private fun initNavigation() {
        val rootNavHostFragment = supportFragmentManager.findFragmentById(R.id.fv_root)
                as NavHostFragment

        navController = rootNavHostFragment.navController.also { navigationController ->
            navigator.attachRootNavController(
                navigationController
            )
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        exoPlayer.release()
        navController?.also(navigator::detachRootNavController)
        unregisterReceiver(broadcastReceiver)
    }
}