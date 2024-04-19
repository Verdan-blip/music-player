package ru.kpfu.itis.bagaviev.impl.di.submodules

import android.content.ComponentName
import android.content.Context
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import com.google.common.util.concurrent.ListenableFuture
import dagger.Module
import dagger.Provides
import ru.kpfu.itis.bagaviev.impl.presentation.service.PlayerService
import ru.kpfu.itis.common.di.scopes.FeatureScope

@Module
class PlayerAndroidDependenciesModule {

    @FeatureScope
    @Provides
    fun provideSessionToken(context: Context): SessionToken =
        SessionToken(context, ComponentName(context, PlayerService::class.java))

    @FeatureScope
    @Provides
    fun provideMediaControllerFuture(context: Context, sessionToken: SessionToken):
            ListenableFuture<MediaController> =
        MediaController.Builder(context, sessionToken)
            .buildAsync()
}