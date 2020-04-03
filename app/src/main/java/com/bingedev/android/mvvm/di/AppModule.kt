package com.bingedev.android.mvvm.di

import androidx.lifecycle.ViewModelProvider
import com.bingedev.android.mvvm.MvvmSampleApp
import com.bingedev.android.mvvm.base.ViewModelFactory
import com.bingedev.android.mvvm.features.project.list.data.local.prefs.AppPreferencesHelper
import com.bingedev.android.mvvm.features.project.list.data.local.prefs.PreferencesHelper
import com.bingedev.android.mvvm.features.project.list.data.remote.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * @author Kshitij Kumar
 */

@Module
internal class AppModule {

    @Provides
    fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory = factory

    @Provides
    @Singleton
    fun providesOkHttpClient(app: MvvmSampleApp): OkHttpClient {
        return app.getOkHttpClient()
    }

    @Provides
    @Singleton
    fun provideApiService(okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl(ApiService.HTTPS_API_GITHUB_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun providePreferenceName(): String {
        return AppPreferencesHelper.PREF_NAME
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }
}
