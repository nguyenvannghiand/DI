package com.example.android.dagger.registration

import com.example.android.dagger.di.ActivityScope
import com.example.android.dagger.registration.enterdetails.EnterDetailsFragment
import com.example.android.dagger.registration.termsandconditions.TermsAndConditionsFragment
import dagger.Subcomponent


// Difinition of Dagger subcomponent
// Classes annotated with @ActivityScope will have a unique instace in this Component
@ActivityScope
@Subcomponent
interface RegistrationComponent {

	// Factory to creat instance of RegistraitonComponent
	@Subcomponent.Factory
	interface Factory{
		fun create(): RegistrationComponent
	}

	// Class that can be injected by this Component
	fun inject(activity: RegistrationActivity)
	fun inject(fragment: EnterDetailsFragment)
	fun inject(fragment: TermsAndConditionsFragment)
}