package ru.kpfu.itis.bagaviev.feature.upload.di

import android.content.Context
import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependenciesProvider
import ru.kpfu.itis.bagaviev.common.di.connector.holders.FeatureComponentHolder

object UploadComponentHolder : FeatureComponentHolder<UploadComponent>() {

    override fun initComponent(context: Context): UploadComponent =
        DaggerUploadComponent.factory()
            .create(ComponentDependenciesProvider.get(context))
}