package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.holder

import ru.kpfu.itis.bagaviev.feature.search.impl.databinding.ItemSearchSubtitleBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.PlayableViewHolder

class SubtitleViewHolder(
    private val binding: ItemSearchSubtitleBinding
) : PlayableViewHolder(binding.root) {

    fun bind(subtitle: String) {
        binding.tvCharts.text = subtitle
    }
}