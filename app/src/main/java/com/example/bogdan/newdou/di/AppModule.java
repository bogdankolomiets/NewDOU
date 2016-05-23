package com.example.bogdan.newdou.di;

import android.app.Application;

import com.example.bogdan.newdou.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 23.05.16
 */
@Module
public class AppModule {
    private App mApplication;

    public AppModule(App application) {
        mApplication = application;
    }

    @Singleton
    @Provides
    Application provideApplication() {
        return mApplication;
    }

}
