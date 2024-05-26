package ru.kpfu.itis.bagaviev.theme.recyclerview.adapter

import androidx.recyclerview.widget.ListAdapter
import ru.kpfu.itis.bagaviev.theme.recyclerview.diffutil.MusicComponentItemCallback
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.base.MusicComponentRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.MusicComponentViewHolder

abstract class MusicComponentAdapter :
    ListAdapter<MusicComponentRvModel, MusicComponentViewHolder>(MusicComponentItemCallback())