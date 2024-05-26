package ru.kpfu.itis.bagaviev.feature.upload.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import ru.kpfu.itis.bagaviev.common.base.BaseFragment
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.feature.upload.R
import ru.kpfu.itis.bagaviev.feature.upload.databinding.FragmentUploadBinding
import ru.kpfu.itis.bagaviev.feature.upload.di.UploadComponentHolder
import ru.kpfu.itis.bagaviev.feature.upload.presentation.event.PickMediaEvent
import ru.kpfu.itis.bagaviev.feature.upload.presentation.state.UiState
import ru.kpfu.itis.bagaviev.feature.upload.presentation.util.MimeTypes
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.dialog.SearchUsersDialogFragment
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.adapter.AddUsersAdapter
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.interactor.AuthorPlaceholderInteractor
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.mapper.toAuthorRvModel
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.util.setOnRangeSeekBarViewChangeListener
import ru.kpfu.itis.bagaviev.theme.recyclerview.decoration.AuthorItemDecoration
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.AuthorInteractor


class UploadFragment : BaseFragment(R.layout.fragment_upload) {

    private var viewBinding: FragmentUploadBinding? = null

    private val viewModel: UploadViewModel by activityViewModels {
        UploadComponentHolder
            .createComponent(requireContext())
            .viewModelFactory
    }

    private val getCoverUri = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { coverUri ->
        viewModel.onCoverPicked(coverUri?.toString())
    }

    private val getSmallUri = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { smallCoverUri ->
        viewModel.onSmallCoverPicked(smallCoverUri?.toString())
    }

    private val getAudioUri = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { audioUri ->
        viewModel.onAudioPicked(audioUri?.toString())
    }

    private val getVideoUri = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { videoUri ->
        viewModel.onVideoClipPicked(videoUri?.toString())
    }

    private val authorAdapter: AddUsersAdapter by lazy {
        AddUsersAdapter(
            context = requireContext(),
            authorInteractor = AuthorInteractor.Builder()
                .onLongClick(viewModel::onAuthorLongClick)
                .build(),
            authorPlaceholderInteractor = AuthorPlaceholderInteractor.Builder()
                .onClick(viewModel::onAuthorPlaceholderClick)
                .build()
        )
    }


    private fun initListeners() {
        viewBinding?.apply {
            doubleValueSbClipDuration.setOnRangeSeekBarViewChangeListener(
                onValueChanged = { _, min, max, _ ->
                    viewModel.onDoubleValueSeekbarValueChanged(min, max)
                }
            )
            llCover.apply {
                ibPickImage.setOnClickListener {
                    viewModel.onPickCoverClick()
                }
            }
            llSmallCover.apply {
                ibPickImage.setOnClickListener {
                    viewModel.onPickSmallCoverClick()
                }
            }
            ibPickAudio.setOnClickListener {
                viewModel.onPickAudioClick()
            }
            ibPickClip.setOnClickListener {
                viewModel.onPickVideoClipClick()
            }
        }
    }

    private fun initViews() {
        viewBinding?.apply {
            rvAuthors.adapter = authorAdapter
            rvAuthors.addItemDecoration(AuthorItemDecoration(requireContext()))
        }
    }

    private fun observeErrorEvents(message: String) {
        showErrorDialog("Ошибка", message)
    }

    private fun observeUiState(uiState: UiState) {
        viewBinding?.apply {
            uiState.apply {
                etTrackTitle.setText(trackTitle ?: "")
                tvAudioFileName.text = audioFileName ?: "Выберите файл"
                tvTrackClipFileName.text = clipFileName ?: "Выберите файл"
                llCover.ivCover.setImageURI(uiState.coverUri?.toUri())
                llSmallCover.ivCover.setImageURI(uiState.smallCoverUri?.toUri())
                tvClipStartTime.text = uiState.clipStartTime ?: "С начала"
                tvClipEndTime.text = uiState.clipEndTime ?: "До конца"
                llClipDurationCorrection.isVisible = isClipCorrectionActive

                authorAdapter.submitList(uiState.authors.map { userModel ->
                    userModel.toAuthorRvModel()
                })
            }
        }
    }

    private fun observeSearchUsersDialogEvent(show: Boolean) {
        if (show) {
            SearchUsersDialogFragment().show(childFragmentManager, null)
        }
    }

    private fun observePickMediaEvent(pickMediaEvent: PickMediaEvent) {
        when (pickMediaEvent) {
            is PickMediaEvent.Cover -> {
                getCoverUri.launch(MimeTypes.ANY_IMAGE)
            }
            is PickMediaEvent.SmallCover -> {
                getSmallUri.launch(MimeTypes.ANY_IMAGE)
            }
            is PickMediaEvent.Audio -> {
                getAudioUri.launch(MimeTypes.ANY_AUDIO)
            }
            is PickMediaEvent.VideoClip -> {
                getVideoUri.launch(MimeTypes.ANY_VIDEO)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentUploadBinding.inflate(
            inflater, container, false
        )
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        initViews()

        viewModel.apply {
            pickMediaEvent.observe(viewLifecycleOwner, ::observePickMediaEvent)
            uiState.observe(viewLifecycleOwner, ::observeUiState)
            showSearchUsersDialogEvent.observe(viewLifecycleOwner, ::observeSearchUsersDialogEvent)
            errorAlert.observe(viewLifecycleOwner, ::observeErrorEvents)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        UploadComponentHolder.releaseComponent()
    }
}