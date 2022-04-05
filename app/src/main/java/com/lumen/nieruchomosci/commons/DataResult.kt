package com.lumen.nieruchomosci.commons

import android.content.res.Resources
import com.lumen.nieruchomosci.R

sealed class DataResult {
    object Success : DataResult()
    data class Fail(val failReason: FailReason) : DataResult()
}

enum class FailReason {
    EMPTY_NOTE, FIREBASE, INVALID;

    fun toLocalizeString(resource:Resources) : String {
        return when(this) {
            EMPTY_NOTE -> resource.getString(R.string.empty_note_alert)
            FIREBASE -> resource.getString(R.string.firebase_alert)
            INVALID -> resource.getString(R.string.invalid_data)
        }
    }
}

