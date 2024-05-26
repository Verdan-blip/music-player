package ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.interactor

interface FoundAuthorInteractor {

    fun onClick(authorId: Long)

    class Builder {

        private var onClick: (Long) -> Unit = { }

        fun onClick(block: (authorId: Long) -> Unit): Builder {
            onClick = block
            return this
        }

        fun build(): FoundAuthorInteractor = object : FoundAuthorInteractor {

            override fun onClick(authorId: Long) {
                this@Builder.onClick(authorId)
            }
        }
    }
}