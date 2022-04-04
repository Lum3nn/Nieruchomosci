package com.lumen.nieruchomosci.auth

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class AuthViewModel : ViewModel() {

    fun login(login: String, password: String) {
        //sprawdz czy ma 8 znakow
        //czy ma znak specjalny
        //czy ma jedna duza litere
        //czy ma cyfre
    }
}