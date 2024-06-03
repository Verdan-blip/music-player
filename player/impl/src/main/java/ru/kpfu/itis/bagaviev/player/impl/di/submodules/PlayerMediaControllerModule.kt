package ru.kpfu.itis.bagaviev.player.impl.di.submodules

import android.content.ComponentName
import android.content.Context
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import com.google.common.util.concurrent.ListenableFuture
import dagger.Module
import dagger.Provides
import ru.kpfu.itis.bagaviev.common.di.scopes.ApplicationScope
import ru.kpfu.itis.bagaviev.player.impl.presentation.service.PlayerService

@Module
class PlayerMediaControllerModule {

    @ApplicationScope
    @Provides
    fun provideSessionToken(context: Context): SessionToken =
        SessionToken(context, ComponentName(context, PlayerService::class.java))

    @ApplicationScope
    @Provides
    fun provideMediaControllerFuture(context: Context, sessionToken: SessionToken):
            ListenableFuture<MediaController> =
        MediaController.Builder(context, sessionToken)
            .buildAsync()
}