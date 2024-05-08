package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.dialogs.track

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import ru.kpfu.itis.bagaviev.feed.impl.R
import ru.kpfu.itis.bagaviev.feed.impl.databinding.FragmentTrackDetailsBinding
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.TrackDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.FeedViewModel

class TrackDetailsDialogFragment : DialogFragment(R.layout.fragment_track_details) {

    private var viewBinding: FragmentTrackDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTrackDetailsBinding.inflate(
            inflater, container, false
        )
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val trackDetails = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            arguments?.getParcelable(TRACK_DETAILS_KEY, TrackDetailsModel::class.java)
        else
            arguments?.getParcelable(TRACK_DETAILS_KEY) as? TrackDetailsModel

        trackDetails?.apply {
            viewBinding?.apply {
                with(requireContext().resources) {
                    tvTrackTitle.text = getString(R.string.track_details_fragment_title, title)
                    tvTrackAuthors.text = getString(
                        R.string.track_details_fragment_authors,
                        users.joinToString(separator = " & ") { user -> user.login }
                    )
                    tvTrackPlaysCount.text = getString(
                        R.string.track_details_fragment_plays_count, playsCount)
                    tvTrackReleaseDate.text = getString(
                        R.string.track_details_fragment_release_date,
                        releaseDate.toString()
                    )
                    ivTrackCover.load(coverUri)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    companion object {

        const val TRACK_DETAILS_KEY = "trackDetailsKey"

        fun newInstance(trackDetailsModel: TrackDetailsModel): TrackDetailsDialogFragment =
            TrackDetailsDialogFragment().apply {
                arguments = bundleOf(TRACK_DETAILS_KEY to trackDetailsModel)
            }
    }
}