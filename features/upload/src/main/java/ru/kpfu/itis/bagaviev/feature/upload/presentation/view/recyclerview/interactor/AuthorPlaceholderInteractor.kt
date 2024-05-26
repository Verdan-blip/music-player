package ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.interactor

interface AuthorPlaceholderInteractor {

    fun onClick()

    class Builder {

        private var onClick: () -> Unit = { }

        fun onClick(block: () -> Unit): Builder {
            onClick = block
            return this
        }

        fun build(): AuthorPlaceholderInteractor = object : AuthorPlaceholderInteractor {

            override fun onClick() {
                this@Builder.onClick()
            }
        }
    }
}