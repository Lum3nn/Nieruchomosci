package com.lumen.nieruchomosci.commons

import android.content.res.Resources
import com.lumen.nieruchomosci.R
import com.lumen.nieruchomosci.commons.model.LoginResult


fun LoginResult.FailReason.toLocalizeString(resource: Resources) : String {
    return when(this) {
        LoginResult.FailReason.EMPTY_NOTE -> resource.getString(R.string.empty_note_alert)
        LoginResult.FailReason.FIREBASE -> resource.getString(R.string.firebase_alert)
        LoginResult.FailReason.INVALID -> resource.getString(R.string.invalid_data)
    }
}