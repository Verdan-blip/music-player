package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.holder

import ru.kpfu.itis.bagaviev.feature.search.impl.databinding.ItemSearchSubtitleBinding

class SubtitleViewHolder(
    private val binding: ItemSearchSubtitleBinding
) : PlayableInfoViewHolder(binding.root) {

    fun bind(subtitle: String) {
        binding.tvCharts.text = subtitle
    }
}