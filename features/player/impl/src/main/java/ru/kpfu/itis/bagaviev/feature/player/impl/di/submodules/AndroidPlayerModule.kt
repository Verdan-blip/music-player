package ru.kpfu.itis.bagaviev.feature.player.impl.di.submodules

import android.content.Context
import androidx.media3.exoplayer.ExoPlayer
import dagger.Module
import dagger.Provides
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope

@Module
internal class AndroidPlayerModule {

    @FeatureScope
    @Provides
    fun provideExoPlayer(context: Context): ExoPlayer = ExoPlayer.Builder(context)
        .build()
}