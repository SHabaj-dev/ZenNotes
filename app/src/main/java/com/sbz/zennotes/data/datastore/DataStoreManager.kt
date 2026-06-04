package com.sbz.zennotes.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(
    name = "zen_notes_pref"
)

class DataStoreManager(
    private val context: Context
) {

    val isFirstTimeUser: Flow<Boolean> =
        context.dataStore.data.map { preferences ->

            preferences[
                PreferencesKeys.IS_FIRST_LAUNCH
            ] ?: true

        }

    suspend fun setFirstTimeUserCompleted() {

        context.dataStore.edit { preferences ->

            preferences[
                PreferencesKeys.IS_FIRST_LAUNCH
            ] = false

        }

    }

}