package ru.kpfu.itis.bagaviev.feature.profile.presentation.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.kpfu.itis.bagaviev.feature.profile.presentation.view.track.MyTracksFragment
import ru.kpfu.itis.bagaviev.feature.profile.presentation.view.track.SavedTracksFragment

class TracksFragmentAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> MyTracksFragment()
            1 -> SavedTracksFragment()
            else -> throw IllegalStateException("Unsupported position $position")
        }
}