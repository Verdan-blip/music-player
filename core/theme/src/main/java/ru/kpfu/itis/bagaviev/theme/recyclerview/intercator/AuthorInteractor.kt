package ru.kpfu.itis.bagaviev.theme.recyclerview.intercator

interface AuthorInteractor {

    fun onLongClick(authorId: Long)

    class Builder {

        private var onLongClick: (Long) -> Unit = { }

        fun onLongClick(block: (authorId: Long) -> Unit): Builder {
            onLongClick = block
            return this
        }

        fun build(): AuthorInteractor = object : AuthorInteractor {

            override fun onLongClick(authorId: Long) {
                this@Builder.onLongClick(authorId)
            }
        }
    }
}