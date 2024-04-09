package ru.kpfu.itis.bagaviev.player.di

import android.content.Context
import androidx.media3.common.AudioAttributes
import androidx.media3.common.C
import androidx.media3.exoplayer.ExoPlayer
import dagger.Module
import dagger.Provides

@Module
class PlayerModule {

    @Provides
    fun provideAudioAttributes(): AudioAttributes =
        AudioAttributes.Builder()
            .setContentType(C.AUDIO_CONTENT_TYPE_MUSIC)
            .setUsage(C.USAGE_MEDIA)
            .build()

    @Provides
    fun provideExoPlayer(context: Context, audioAttributes: AudioAttributes): ExoPlayer =
        ExoPlayer.Builder(context)
            .setAudioAttributes(audioAttributes, true)
            .build()

}