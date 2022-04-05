package com.lumen.nieruchomosci.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lumen.nieruchomosci.commons.FailReason
import com.lumen.nieruchomosci.commons.DataResult
import com.lumen.nieruchomosci.commons.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _result: MutableLiveData<DataResult> = MutableLiveData()
    val result: LiveData<DataResult> get() = _result

    fun login(login: String, password: String) {
        //czy ma 8 znakow
        //czy ma znak specjalny
        //czy ma jedna duza litere
        //czy ma cyfre
        viewModelScope.launch {
            userRepository.login(login,password)
        }

        val isEnoughLong = password.length >= 8
        val hasSpecialChar = "([!@#\$%^&*();'.,?|])".toRegex().containsMatchIn(password)
        val hasCapitalLetter = "([A-Z]+)".toRegex().containsMatchIn(password)
        val hasDigit = "([0-9]+)".toRegex().containsMatchIn(password)

        if (hasCapitalLetter && hasSpecialChar && hasDigit && isEnoughLong) {
            _result.value = DataResult.Success
        } else {
            _result.value = DataResult.Fail(FailReason.INVALID)
        }
    }
}