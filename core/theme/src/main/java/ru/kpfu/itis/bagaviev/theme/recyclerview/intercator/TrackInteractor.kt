package ru.kpfu.itis.bagaviev.theme.recyclerview.intercator

interface TrackInteractor {

    fun onClick(trackId: Long)

    fun onLongClick(trackId: Long)

    fun onSmallCoverClick(trackId: Long)

    fun onMoveThumb(progress: Int)

    fun onReleaseThumb(progress: Int)

    fun onPlayPauseClick()

    fun onDownloadClick(trackId: Long)

    class Builder {

        private var onClick: (Long) -> Unit = { }

        private var onLongClick: (Long) -> Unit = { }

        private var onSmallCoverClick: (Long) -> Unit = { }

        private var onMoveThumb: (Int) -> Unit = { }

        private var onReleaseThumb: (Int) -> Unit = { }

        private var onPlayPauseClick: () -> Unit = { }

        private var onDownloadClick: (Long) -> Unit = { }

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

        fun onDownloadClick(block: (trackId: Long) -> Unit): Builder {
            onDownloadClick = block
            return this
        }

        fun onPlayPauseClick(block: () -> Unit): Builder {
            onPlayPauseClick = block
            return this
        }

        fun onMoveThumb(block: (progress: Int) -> Unit): Builder {
            onMoveThumb = block
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

            override fun onMoveThumb(progress: Int) {
                this@Builder.onMoveThumb(progress)
            }

            override fun onReleaseThumb(progress: Int) {
                this@Builder.onReleaseThumb(progress)
            }

            override fun onPlayPauseClick() {
                this@Builder.onPlayPauseClick()
            }

            override fun onDownloadClick(trackId: Long) {
                this@Builder.onDownloadClick(trackId)
            }
        }
    }
}