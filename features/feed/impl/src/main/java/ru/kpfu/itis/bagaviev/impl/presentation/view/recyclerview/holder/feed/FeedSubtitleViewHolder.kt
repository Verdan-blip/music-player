package ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holder.feed

import ru.kpfu.itis.bagaviev.impl.databinding.ItemFeedSubtitleBinding
import ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holder.FeedViewHolder

class FeedSubtitleViewHolder(
    private val binding: ItemFeedSubtitleBinding
) : FeedViewHolder(binding.root) {

    fun bind(subtitle: String) {
        binding.tvCharts.text = subtitle
    }
}