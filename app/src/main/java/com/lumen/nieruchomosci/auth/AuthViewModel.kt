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

    fun login(login: String, password: String) {
        //sprawdz czy ma 8 znakow
        //czy ma znak specjalny
        //czy ma jedna duza litere
        //czy ma cyfre
        _result.value = DataResult.Fail(FailReason.INVALID)
    }
}