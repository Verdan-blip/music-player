package ru.kpfu.itis.bagaviev.theme.recyclerview.interactor

interface PlaylistInteractor {

    fun onClick(playlistId: Long)

    fun onLongClick(playlistId: Long)

    class Builder {

        private var onClick: (Long) -> Unit = { }

        private var onLongClick: (Long) -> Unit = { }

        fun onClick(block: (playlistId: Long) -> Unit): Builder {
            onClick = block
            return this
        }

        fun onLongClick(block: (playlistId: Long) -> Unit): Builder {
            onLongClick = block
            return this
        }

        fun build(): PlaylistInteractor = object : PlaylistInteractor {

            override fun onClick(playlistId: Long) {
                this@Builder.onClick(playlistId)
            }

            override fun onLongClick(playlistId: Long) {
                this@Builder.onLongClick(playlistId)
            }
        }
    }
}