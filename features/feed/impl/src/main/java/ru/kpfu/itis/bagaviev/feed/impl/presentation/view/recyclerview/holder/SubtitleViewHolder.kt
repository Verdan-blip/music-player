package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder

import ru.kpfu.itis.bagaviev.feed.impl.databinding.ItemFeedSubtitleBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.PlayableViewHolder

class SubtitleViewHolder(
    private val binding: ItemFeedSubtitleBinding
) : PlayableViewHolder(binding.root) {

    fun bind(subtitle: String) {
        binding.tvCharts.text = subtitle
    }
}