package com.example.hiltexample2

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor() : ViewModel() {
	fun sayHello() {
		println("Hello World! My name Kotlin")
	}
}