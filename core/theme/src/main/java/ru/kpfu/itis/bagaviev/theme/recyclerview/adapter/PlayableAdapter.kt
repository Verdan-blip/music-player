package ru.kpfu.itis.bagaviev.theme.recyclerview.adapter

import ru.kpfu.itis.bagaviev.theme.recyclerview.model.base.MusicComponentRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.MusicComponentViewHolder

abstract class PlayableAdapter() : MusicComponentAdapter() {

    private var currentPlayingPosition: Int? = null

    abstract fun onBindPlayableViewHolder(
        holder: MusicComponentViewHolder,
        position: Int,
        payloadType: PayloadType
    )

    fun getPlayableList(): List<MusicComponentRvModel> = currentList

    fun prepareToPlay(component: MusicComponentRvModel) {
        val index = currentList.indexOfFirst { componentCandidate ->
            componentCandidate.isSameWith(component)
        }

        if (index != -1) {
            notifyItemChanged(index, PayloadType.RedrawAsReadyToPlay)
            currentPlayingPosition?.also { position ->
                notifyItemChanged(position, PayloadType.RedrawAsStatic)
            }
        }
        currentPlayingPosition = index
    }

    fun updateIsPlaying(isPlaying: Boolean) {
        currentPlayingPosition?.also { position ->
            notifyItemChanged(position, PayloadType.UpdateIsPlaying(isPlaying))
        }
    }

    fun updatePlayingProgress(progress: Int) {
        currentPlayingPosition?.also { position ->
            notifyItemChanged(position, PayloadType.UpdateProgress(progress))
        }
    }

    override fun onBindViewHolder(
        holder: MusicComponentViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty()) {
            (payloads.first() as? PayloadType)?.also { payloadType ->
                onBindPlayableViewHolder(holder, position, payloadType)
            }
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }



    sealed class PayloadType {

        data class UpdateIsPlaying(val isPlaying: Boolean) : PayloadType()

        data class UpdateProgress(val progress: Int) : PayloadType()

        data object RedrawAsStatic : PayloadType()

        data object RedrawAsReadyToPlay : PayloadType()
    }
}