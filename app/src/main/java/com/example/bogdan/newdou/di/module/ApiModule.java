package com.example.bogdan.newdou.di.module;

import com.example.bogdan.newdou.data.api.DouConverterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 26.05.16
 */
@Module
public class ApiModule {
    String mBaseUrl;

    public ApiModule(String baseUrl) {
        mBaseUrl = baseUrl;
    }

    @Singleton
    @Provides
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(RxJavaCallAdapterFactory rxJavaCallAdapterFactory) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .addConverterFactory(new DouConverterFactory())
                .build();
    }
}
