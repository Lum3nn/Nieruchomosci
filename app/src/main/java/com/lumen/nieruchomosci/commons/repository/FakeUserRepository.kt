package com.lumen.nieruchomosci.commons.repository

import com.lumen.nieruchomosci.commons.model.LoginResult
import com.lumen.nieruchomosci.commons.model.User
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeUserRepository @Inject constructor() : UserRepository {

    override suspend fun login(login: String, password: String) : LoginResult {
        //czy ma 8 znakow
        //czy ma znak specjalny
        //czy ma jedna duza litere
        //czy ma cyfre
//        val isEnoughLong = password.length >= 8
//        val hasSpecialChar = "([!@#\$%^&*();'.,?|])".toRegex().containsMatchIn(password)
//        val hasCapitalLetter = "([A-Z]+)".toRegex().containsMatchIn(password)
//        val hasDigit = "([0-9]+)".toRegex().containsMatchIn(password)
        delay(200)
        return if (login == "ania" && password == "123456"){
            LoginResult.Success(User(login,password))
        } else {
            LoginResult.Fail(LoginResult.FailReason.INVALID)
        }
    }

}