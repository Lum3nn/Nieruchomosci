package com.lumen.nieruchomosci.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.lumen.nieruchomosci.R
import com.lumen.nieruchomosci.commons.FailReason
import com.lumen.nieruchomosci.commons.DataResult
import com.lumen.nieruchomosci.databinding.AuthFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class AuthFragment : Fragment() {

    private var _binding: AuthFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AuthFragmentBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()

        binding.loginButton.setOnClickListener {
            val login = binding.loginInput.text.toString().trim()
            val password = binding.passwordInput.text.toString().trim()
            viewModel.login(login, password)
        }

        viewModel.result.observe(viewLifecycleOwner) { result ->
            when (result) {
                is DataResult.Fail -> showDialog(result.failReason)
                DataResult.Success -> { navigateToMainPanel()}
            }
        }
    }

    private fun navigateToMainPanel() {
        
    }

    private fun showDialog(failReason: FailReason) {
        MaterialAlertDialogBuilder(requireContext())
            .setMessage(failReason.toLocalizeString(resources))
            .setNeutralButton(resources.getString(R.string.dialog_neutral_btn)) { dialog, which -> }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
