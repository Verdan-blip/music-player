package ru.kpfu.itis.bagaviev.feature.upload.presentation.view.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.feature.upload.R
import ru.kpfu.itis.bagaviev.feature.upload.databinding.DialogFragmentSearchUsersBinding
import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.UserModel
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.UploadViewModel
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.adapter.FoundAuthorsAdapter
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.decorator.FoundUsersItemDecorator
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.interactor.FoundAuthorInteractor

class SearchUsersDialogFragment : DialogFragment(R.layout.dialog_fragment_search_users) {

    private var viewBinding: DialogFragmentSearchUsersBinding? = null

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[UploadViewModel::class.java]
    }

    private val foundUsersAdapter by lazy {
        FoundAuthorsAdapter(
            context = requireContext(),
            interactor = FoundAuthorInteractor.Builder()
                .onClick(viewModel::onFoundAuthorClick)
                .build()
        )
    }

    private fun observeFoundUsers(users: List<UserModel>) {
        viewBinding?.apply {
            foundUsersAdapter.submitList(users)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        viewBinding = DialogFragmentSearchUsersBinding.inflate(
            inflater, container, false
        )
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding?.apply {
            rvFoundUsers.adapter = foundUsersAdapter
            rvFoundUsers.addItemDecoration(FoundUsersItemDecorator(requireContext()))
            etKeywords.addTextChangedListener(
                onTextChanged = { text, _, _, _ ->
                    text?.toString()?.also(viewModel::onSearchKeywordsChange)
                }
            )
        }

        viewModel.apply {
            foundAuthorsState.observe(viewLifecycleOwner, ::observeFoundUsers)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}