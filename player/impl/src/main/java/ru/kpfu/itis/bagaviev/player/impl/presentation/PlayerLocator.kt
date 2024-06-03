@file:UnstableApi

package ru.kpfu.itis.bagaviev.player.impl.presentation

import android.content.Context
import androidx.media3.common.util.UnstableApi
import androidx.media3.database.DatabaseProvider
import androidx.media3.database.StandaloneDatabaseProvider
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.datasource.HttpDataSource
import androidx.media3.datasource.cache.Cache
import androidx.media3.datasource.cache.CacheDataSource
import androidx.media3.datasource.cache.NoOpCacheEvictor
import androidx.media3.datasource.cache.SimpleCache
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory
import java.util.concurrent.Executor

object PlayerLocator {

    var player: ExoPlayer? = null

    var downloadCache: Cache? = null

    var databaseProvider: DatabaseProvider? = null

    var httpDataSourceFactory: HttpDataSource.Factory? = null

    var cacheDataSourceFactory: DataSource.Factory? = null

    val executor = Executor(Runnable::run)

    fun provideContext(context: Context) {
        databaseProvider = StandaloneDatabaseProvider(context).also { provider ->
            httpDataSourceFactory = DefaultHttpDataSource.Factory()
            downloadCache = SimpleCache(context.filesDir, NoOpCacheEvictor(), provider)
            downloadCache?.also { cache ->
                cacheDataSourceFactory = CacheDataSource.Factory()
                        .setCache(cache)
                        .setUpstreamDataSourceFactory(httpDataSourceFactory)
                        .setCacheWriteDataSinkFactory(null)

                cacheDataSourceFactory?.also { cacheDataSourceFactory ->
                    player = ExoPlayer.Builder(context)
                        .setMediaSourceFactory(
                            DefaultMediaSourceFactory(context).setDataSourceFactory(
                                cacheDataSourceFactory)
                        )
                        .build()
                }
            }
        }
    }

}