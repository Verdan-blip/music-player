package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder

import ru.kpfu.itis.bagaviev.feed.impl.databinding.ItemFeedSubtitleBinding

class SubtitleViewHolder(
    private val binding: ItemFeedSubtitleBinding
) : PlayableInfoViewHolder(binding.root) {

    fun bind(subtitle: String) {
        binding.tvCharts.text = subtitle
    }
}