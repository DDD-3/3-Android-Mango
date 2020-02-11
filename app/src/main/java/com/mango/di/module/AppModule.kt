package com.mango.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mango.BuildConfig
import com.mango.R
import com.mango.data.MarketService
import com.mango.di.ViewModelFactory
import com.orhanobut.logger.Logger
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, ViewModelFactoryModule::class])
class AppModule {

    companion object {
        const val NETWORK_TIME_OUT: Long = 15
    }

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
            chain.proceed(request.newBuilder().build())
        }
    }

    @Provides
    @Singleton
    fun createClient(interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
            if (BuildConfig.DEBUG) addInterceptor(
                HttpLoggingInterceptor(
                    HttpLoggingInterceptor.Logger { message ->
                        try {
                            JSONObject(message)
                            Logger.t("OK_HTTP").json(message)
                        }catch(e: JSONException){
                            Logger.t("OK_HTTP").i(message)
                        }
                    }
                ).setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            connectTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
            readTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
            addInterceptor(interceptor)
        }.build()
    }


    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Singleton
    @Provides
    fun provideApiService(
        context: Context,
        okHttpClient: OkHttpClient,
        gson: Gson
    ): MarketService {
        return Retrofit.Builder()
            .baseUrl(context.getString(R.string.api_base_url))
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(MarketService::class.java)
    }
}

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory
}
