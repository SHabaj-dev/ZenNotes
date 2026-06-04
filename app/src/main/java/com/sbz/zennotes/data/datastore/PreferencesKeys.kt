package com.sbz.zennotes.data.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey

object PreferencesKeys {
    val IS_FIRST_LAUNCH =
        booleanPreferencesKey("is_first_launch")
}