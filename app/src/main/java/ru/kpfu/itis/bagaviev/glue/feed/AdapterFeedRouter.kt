package ru.kpfu.itis.bagaviev.glue.feed

import ru.kpfu.itis.bagaviev.feed.impl.FeedRouter
import ru.kpfu.itis.bagaviev.presentation.GlobalRouter
import javax.inject.Inject

class AdapterFeedRouter @Inject constructor(
    private val globalRouter: GlobalRouter
) : FeedRouter {

    override fun navigateToPlayer() {
        globalRouter.navigateToPlayer()
    }
}