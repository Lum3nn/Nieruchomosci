package com.lumen.nieruchomosci.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lumen.nieruchomosci.commons.Event
import com.lumen.nieruchomosci.commons.model.LoginResult
import com.lumen.nieruchomosci.commons.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _result: MutableLiveData<Event<LoginResult>> = MutableLiveData()
    val result: LiveData<Event<LoginResult>> get() = _result

    fun login(login: String, password: String) {
        viewModelScope.launch {
            _result.value = Event(userRepository.login(login,password))
        }
    }
}