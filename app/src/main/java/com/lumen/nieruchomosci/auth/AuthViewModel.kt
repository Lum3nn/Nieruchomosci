package com.lumen.nieruchomosci.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lumen.nieruchomosci.commons.FailReason
import com.lumen.nieruchomosci.commons.DataResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {

    private val _result: MutableLiveData<DataResult> = MutableLiveData()
    val result: LiveData<DataResult> get() = _result

    init {
        val input = "aaaa"
        val regexp = "([0-9]+)".toRegex()
        val result = regexp.containsMatchIn(input)
        println("KITKA $result")

    }

    fun login(login: String, password: String) {
        //czy ma 8 znakow
        //czy ma znak specjalny
        //czy ma jedna duza litere
        //czy ma cyfre

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