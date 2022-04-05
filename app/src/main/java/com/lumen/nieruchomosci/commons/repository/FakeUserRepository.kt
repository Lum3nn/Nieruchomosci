package com.lumen.nieruchomosci.commons.repository

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeUserRepository @Inject constructor() : UserRepository {

    override suspend fun login(login: String, password: String) {
        println("KITKA USER FAKE REPO")
    }

}