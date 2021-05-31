package com.example.android.dagger.di

import com.example.android.dagger.storage.SharedPreferencesStorage
import com.example.android.dagger.storage.Storage
import dagger.Binds
import dagger.Module

// Tell Dagger this is Dagger module
@Module
abstract class StorageModule {

	//Make Dagger provide SharedPreferencesStorage when a Storage type is requested
	@Binds
	abstract fun provideStorage(storage: SharedPreferencesStorage): Storage
}