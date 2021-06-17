package com.example.hiltexample2.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

	@Singleton
	@Provides
	fun providesGson(): Gson {
		return Gson()
	}

	@Singleton
	@Provides
	fun provideInterceptor(): HttpLoggingInterceptor {
		val loggingInterceptor = HttpLoggingInterceptor()
		loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
		return loggingInterceptor
	}

	@Singleton
	@Provides
	fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient.Builder {
		val httpClient = OkHttpClient().newBuilder()
		httpClient.addInterceptor(httpLoggingInterceptor)
		return httpClient
	}

	@Singleton
	@Provides
	fun provideRetrofit(httpClient: OkHttpClient.Builder): Retrofit {
		return Retrofit.Builder()
			.baseUrl("BASE_URL")
			.addConverterFactory(GsonConverterFactory.create())
			.client(httpClient.build())
			.build()
	}
}