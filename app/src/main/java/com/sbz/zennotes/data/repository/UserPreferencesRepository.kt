package com.sbz.zennotes.data.repository

import com.sbz.zennotes.data.datastore.DataStoreManager

class UserPreferencesRepository(
    val dataStoreManager: DataStoreManager
) {

    val isFirstTimeUser = dataStoreManager.isFirstTimeUser

    suspend fun completeOnboarding() {
        dataStoreManager.setFirstTimeUserCompleted()
    }

}