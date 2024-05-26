package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder

import ru.kpfu.itis.bagaviev.theme.databinding.ItemFeedSubtitleBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.SubtitleRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.MusicComponentViewHolder

class SubtitleViewHolder(
    private val viewBinding: ItemFeedSubtitleBinding
) : MusicComponentViewHolder(viewBinding.root) {

    fun bind(subtitleRvModel: SubtitleRvModel) {
        viewBinding.tvCharts.text = subtitleRvModel.text
    }
}