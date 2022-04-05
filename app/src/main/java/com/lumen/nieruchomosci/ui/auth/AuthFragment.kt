package com.lumen.nieruchomosci.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.lumen.nieruchomosci.R
import com.lumen.nieruchomosci.commons.EventObserver
import com.lumen.nieruchomosci.commons.model.LoginResult
import com.lumen.nieruchomosci.commons.toLocalizeString
import com.lumen.nieruchomosci.databinding.AuthFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

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

        viewModel.result.observe(
            viewLifecycleOwner,
            EventObserver { result ->
                when (result) {
                    is LoginResult.Fail -> showDialog(result.failReason)
                    is LoginResult.Success -> navigateToMainPanel()
                }
            }
        )
    }

    private fun navigateToMainPanel() {
        val action = AuthFragmentDirections.actionAuthFragmentToMainFragment()
        findNavController().navigate(action)
    }

    private fun showDialog(failReason: LoginResult.FailReason) {
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
