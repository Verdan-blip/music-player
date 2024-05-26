package ru.kpfu.itis.bagaviev.theme.recyclerview.diffutil

import androidx.recyclerview.widget.DiffUtil
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.base.MusicComponentRvModel

class MusicComponentItemCallback : DiffUtil.ItemCallback<MusicComponentRvModel>() {

    override fun areItemsTheSame(oldItem: MusicComponentRvModel, newItem: MusicComponentRvModel): Boolean {
        return oldItem.isSameWith(newItem)
    }

    override fun areContentsTheSame(oldItem: MusicComponentRvModel, newItem: MusicComponentRvModel): Boolean {
        return oldItem.haveSameContentsWith(newItem)
    }
}