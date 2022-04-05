package com.lumen.nieruchomosci.commons.repository

interface UserRepository {
    suspend fun login(login: String, password: String)
}