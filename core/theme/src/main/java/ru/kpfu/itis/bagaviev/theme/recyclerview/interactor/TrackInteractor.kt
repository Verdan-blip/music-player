package ru.kpfu.itis.bagaviev.theme.recyclerview.interactor

interface TrackInteractor {

    fun onClick(trackId: Long)

    fun onLongClick(trackId: Long)

    fun onSmallCoverClick(trackId: Long)

    fun onMoveHeldThumb(progress: Int)

    fun onReleaseThumb(progress: Int)

    class Builder {

        private var onClick: (Long) -> Unit = { }

        private var onLongClick: (Long) -> Unit = { }

        private var onSmallCoverClick: (Long) -> Unit = { }

        private var onMoveHeldThumb: (Int) -> Unit = { }

        private var onReleaseThumb: (Int) -> Unit = { }

        fun onClick(block: (trackId: Long) -> Unit): Builder {
            onClick = block
            return this
        }

        fun onLongClick(block: (trackId: Long) -> Unit) : Builder {
            onLongClick = block
            return this
        }

        fun onSmallCoverClick(block: (trackId: Long) -> Unit): Builder {
            onSmallCoverClick = block
            return this
        }

        fun onMoveHeldThumb(block: (progress: Int) -> Unit): Builder {
            onMoveHeldThumb = block
            return this
        }

        fun onReleaseThumb(block: (progress: Int) -> Unit): Builder {
            onReleaseThumb = block
            return this
        }

        fun build(): TrackInteractor = object : TrackInteractor {

            override fun onClick(trackId: Long) {
                this@Builder.onClick(trackId)
            }

            override fun onLongClick(trackId: Long) {
                this@Builder.onLongClick(trackId)
            }

            override fun onSmallCoverClick(trackId: Long) {
                this@Builder.onSmallCoverClick(trackId)
            }

            override fun onMoveHeldThumb(progress: Int) {
                this@Builder.onMoveHeldThumb(progress)
            }

            override fun onReleaseThumb(progress: Int) {
                this@Builder.onReleaseThumb(progress)
            }
        }
    }
}