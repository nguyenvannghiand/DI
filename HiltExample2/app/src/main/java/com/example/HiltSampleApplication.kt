package com.example

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltSampleApplication: Application() {

	override fun onCreate() {
		super.onCreate()
		instance = this
	}

	companion object{
		private var instance: HiltSampleApplication? = null
		fun applicationContext(): HiltSampleApplication{
			if (instance == null) {
				instance = HiltSampleApplication()
			}
			return instance as HiltSampleApplication
		}
	}

}