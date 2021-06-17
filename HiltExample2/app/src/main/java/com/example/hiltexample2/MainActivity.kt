package com.example.hiltexample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.activity.viewModels

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

	@Inject
	lateinit var exampleClass: ExampleClass

	private val sampleViewModel: SampleViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		exampleClass.greetMessage()
		sampleViewModel.sayHello()
	}
}

class ExampleClass @Inject constructor() {
	fun greetMessage() {
		println("Hello User")
	}
}