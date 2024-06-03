package ru.kpfu.itis.bagaviev.feature.upload.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import ru.kpfu.itis.bagaviev.common.base.music.BaseMusicFragment
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.feature.upload.R
import ru.kpfu.itis.bagaviev.feature.upload.databinding.FragmentUploadBinding
import ru.kpfu.itis.bagaviev.feature.upload.di.UploadComponentHolder
import ru.kpfu.itis.bagaviev.feature.upload.presentation.event.PickMediaEvent
import ru.kpfu.itis.bagaviev.feature.upload.presentation.state.UiState
import ru.kpfu.itis.bagaviev.feature.upload.presentation.util.MimeTypes
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.dialog.SearchUsersDialogFragment
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.adapter.AddAuthorAdapter
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.interactor.AuthorPlaceholderInteractor
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.mapper.toAuthorRvModel
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.util.FileHelper
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.util.setOnRangeSeekBarViewChangeListener
import ru.kpfu.itis.bagaviev.theme.recyclerview.decoration.AuthorItemDecoration
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.AuthorInteractor


class UploadFragment : BaseMusicFragment(R.layout.fragment_upload) {

    private var viewBinding: FragmentUploadBinding? = null

    private val viewModel: UploadViewModel by activityViewModels {
        UploadComponentHolder
            .createComponent(requireContext())
            .viewModelFactory
    }

    private val getCoverUri = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { coverUri ->
        coverUri?.also { androidUri ->
            viewModel.onCoverPicked(
                FileHelper.getRealPathFromUri(requireContext(), androidUri)
            )
        }
    }

    private val getSmallUri = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { smallCoverUri ->
        smallCoverUri?.also { androidUri ->
            viewModel.onSmallCoverPicked(
                FileHelper.getRealPathFromUri(requireContext(), androidUri)
            )
        }
    }

    private val getAudioUri = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { audioUri ->
        audioUri?.also { androidUri ->
            viewModel.onAudioPicked(
                FileHelper.getRealPathFromUri(requireContext(), androidUri)
            )
        }
    }

    private val getVideoUri = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { videoUri ->
        videoUri?.also { androidUri ->
            viewModel.onVideoClipPicked(
                FileHelper.getRealPathFromUri(requireContext(), androidUri)
            )
        }
    }

    private val authorAdapter: AddAuthorAdapter by lazy {
        AddAuthorAdapter(
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
            btnSubmit.setOnClickListener {
                viewModel.onUploadClick()
            }
            etTrackTitle.doOnTextChanged { text, _, _, _ ->
                text?.also { titleText ->
                    viewModel.onTrackTitleConfirm(titleText.toString())
                }
            }
            etTrackGenre.doOnTextChanged { text, _, _, _ ->
                text?.also { genreText ->
                    viewModel.onTrackGenreConfirm(genreText.toString())
                }
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
        showErrorDialog(
            requireContext().getString(ru.kpfu.itis.bagaviev.theme.R.string.error_dialog_title),
            message
        )
    }

    private fun observeUiState(uiState: UiState) {
        viewBinding?.apply {
            uiState.apply {
                with (requireContext().resources) {
                    etTrackTitle.setText(trackTitle ?: "")
                    tvAudioFileName.text = audioFileName
                        ?: getString(R.string.upload_fragment_select_file_text)
                    tvTrackClipFileName.text = clipFileName
                        ?: getString(R.string.upload_fragment_select_file_text)
                    llCover.ivCover.setImageURI(uiState.coverUri?.toUri())
                    llSmallCover.ivCover.setImageURI(uiState.smallCoverUri?.toUri())
                    tvClipStartTime.text = uiState.clipStartTime
                        ?: getString(R.string.upload_fragment_clip_start_text_placeholder)
                    tvClipEndTime.text = uiState.clipEndTime
                        ?: getString(R.string.upload_fragment_clip_end_text_placeholder)
                    llClipDurationCorrection.isVisible = isClipCorrectionActive

                    authorAdapter.submitData(uiState.authors.map { userModel ->
                        userModel.toAuthorRvModel()
                    })
                }
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.checkIsAuthenticated()
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