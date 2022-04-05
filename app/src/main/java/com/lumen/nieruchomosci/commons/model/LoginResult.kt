package com.lumen.nieruchomosci.commons.model

sealed class LoginResult {
    data class Success(val user: User) : LoginResult()
    data class Fail(val failReason: FailReason) : LoginResult()

    enum class FailReason {
        EMPTY_NOTE, FIREBASE, INVALID;
    }
}

