package com.mudassir.data

import androidx.annotation.VisibleForTesting
import com.mudassir.data.remote.api.AudioBookService
import com.serjltt.moshi.adapters.Wrapped
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

//    @Provides
//    @Singleton
//    @VisibleForTesting
//    fun provideAudioBookListAPI(okHttpClient: OkHttpClient, baseUrl:String ): AudioBookService{
//        val moshi = Moshi.Builder()
//            .add(Wrapped.ADAPTER_FACTORY)
//            .add(KotlinJsonAdapterFactory())
//            .build()
//        return Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .client(okHttpClient)
//            .build().create(AudioBookService::class.java)
//
//    }

    @Provides
    @Named("retrofitDefault")
    fun provideRetrofit(rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
                        baseUrl: String,okHttpClient: OkHttpClient, moshiConverterFactory: MoshiConverterFactory): Retrofit{
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(moshiConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    fun provideAudioBookServiceApi(@Named("retrofitDefault") retrofit: Retrofit): AudioBookService
       = retrofit.create(AudioBookService::class.java)

    @Provides
    @Singleton
    @VisibleForTesting
    fun provideOkHttpClient() : OkHttpClient {

        val builder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(getHttpLoggingInterceptor())
        }

        builder.readTimeout(60, TimeUnit.SECONDS)
        builder.connectTimeout(60, TimeUnit.SECONDS)
        builder.writeTimeout(60, TimeUnit.SECONDS)

//        builder.addInterceptor(headerInterceptor)

        return builder.build()
    }

    @Provides
    @Singleton
    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
//        if (Constants.getBuildType() == Constants.TYPE.RELEASE.ordinal) {
//            interceptor.level = HttpLoggingInterceptor.Level.NONE
//        } else {
        interceptor.level = HttpLoggingInterceptor.Level.BODY
//        }
        return interceptor
    }

    @Provides
    fun provideRxJava2CallAdapter(): RxJava2CallAdapterFactory
       = RxJava2CallAdapterFactory.create()

    @Provides
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory
       = MoshiConverterFactory.create(moshi)

    @Provides
    fun provideMoshi(): Moshi
     = Moshi.Builder()
        .add(Wrapped.ADAPTER_FACTORY)
        .add(KotlinJsonAdapterFactory())
        .build()


    @Provides
    @Singleton
    fun getUrl():String{
        return  BuildConfig.API_URL
    }

}