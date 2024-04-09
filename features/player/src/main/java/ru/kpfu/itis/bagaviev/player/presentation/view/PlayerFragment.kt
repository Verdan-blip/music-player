package ru.kpfu.itis.bagaviev.player.presentation.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import ru.kpfu.itis.bagaviev.player.R
import ru.kpfu.itis.bagaviev.player.databinding.FragmentPlayerBinding
import ru.kpfu.itis.bagaviev.player.di.PlayerComponentHolder
import javax.inject.Inject

class PlayerFragment : Fragment(R.layout.fragment_player) {

    @Inject lateinit var viewModel: PlayerViewModel

    @Inject lateinit var player: ExoPlayer

    private var viewBinding: FragmentPlayerBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        PlayerComponentHolder
            .get(context)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentPlayerBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mediaItem = MediaItem.Builder()
            .setMimeType("media/mp3")
            .setUri("https://mp3uks.ru/mp3/files/tri-dnya-dozhdya-za-kraj-mp3.mp3")
            .build()
        player.setMediaItem(mediaItem)
        player.prepare()
        viewBinding?.apply {
            btnPlayOrPause.setOnClickListener {
                player.play()
            }
        }
    }

}