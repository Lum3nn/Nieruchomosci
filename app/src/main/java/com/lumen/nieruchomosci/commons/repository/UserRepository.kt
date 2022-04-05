package com.lumen.nieruchomosci.commons.repository

import com.lumen.nieruchomosci.commons.model.LoginResult

interface UserRepository {
    suspend fun login(login: String, password: String) : LoginResult
}