package com.example.bogdan.newdou.di.module;

import android.app.Application;

import com.example.bogdan.newdou.App;
import com.example.bogdan.newdou.Constants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

    @Provides @Singleton
    Application provideApplication() {
        return mApplication;
    }
    
    @Provides @Named(Constants.DI.EXECUTOR_THREAD)
    Scheduler provideExecutorScheduler() {
        return Schedulers.newThread();
    }
    
    @Provides @Named(Constants.DI.UI_THREAD)
    Scheduler provideUIScheduler() {
        return AndroidSchedulers.mainThread();
    }

}
