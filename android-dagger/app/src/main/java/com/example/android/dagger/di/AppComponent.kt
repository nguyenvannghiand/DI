package com.example.android.dagger.di

import android.content.Context
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.registration.RegistrationComponent
import com.example.android.dagger.registration.enterdetails.EnterDetailsFragment
import com.example.android.dagger.registration.termsandconditions.TermsAndConditionsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


//Difinition of Dagger component that adds info from the StorageModule to the graph
@Singleton
@Component(modules = [StorageModule::class, AppSubComponent::class])
interface AppComponent {

	// Factory to create instances of the AppComponet
	@Component.Factory
	interface Factory{
		// With @BindsInstance, the Context pass in will be available in the graph
		fun create(@BindsInstance context: Context): AppComponent
	}

	// Expose RegistraitonComponent factory from the graph
	fun registraionComponent(): RegistrationComponent.Factory

	// Classes that can be inject by this Component
	fun inject(activity: RegistrationActivity)
	fun inject(activity: MainActivity)
	fun inject(fragment: EnterDetailsFragment)
	fun inject(fragment: TermsAndConditionsFragment)
}