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

    @Provides @Singleton
    Application provideApplication() {
        return mApplication;
    }
    
    @Provides @Named(Constants.EXECUTOR_THREAD)
    Scheduler provideExecutorScheduler() {
        return Schedulers.newThread();
    }
    
    @Provides @Named(Constants.UI_THREAD)
    Scheduler provideUIScheduler() {
        return AndroidSchedulers.mainThread();
    }

}
