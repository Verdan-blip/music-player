package ru.kpfu.itis.bagaviev.presentation.di

import android.content.Context
import androidx.media3.exoplayer.ExoPlayer
import dagger.Module
import dagger.Provides

@Module
class MainActivityPlayerModule {

    @Provides
    fun provideExoPlayer(context: Context): ExoPlayer =
        ExoPlayer.Builder(context)
            .build().apply {
                volume = 0f
                repeatMode = ExoPlayer.REPEAT_MODE_ALL
            }
}