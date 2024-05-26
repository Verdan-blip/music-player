package ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.kpfu.itis.bagaviev.feature.upload.databinding.ItemFoundAuthorBinding
import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.UserModel
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.diffutil.FoundAuthorItemCallback
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.interactor.FoundAuthorInteractor
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.viewholder.FoundAuthorViewHolder

class FoundAuthorsAdapter(
    private val context: Context,
    private val interactor: FoundAuthorInteractor
) : ListAdapter<UserModel, FoundAuthorViewHolder>(FoundAuthorItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoundAuthorViewHolder {
        return FoundAuthorViewHolder(
            ItemFoundAuthorBinding.inflate(
                LayoutInflater.from(context), parent, false,
            ), interactor
        )
    }

    override fun onBindViewHolder(holder: FoundAuthorViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}