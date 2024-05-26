package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.holder

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