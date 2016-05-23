package com.example.bogdan.newdou;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.example.bogdan.newdou.di.AppComponent;
import com.example.bogdan.newdou.di.AppModule;
import com.example.bogdan.newdou.di.DaggerAppComponent;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 23.05.16
 */
public class App extends Application {
    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private void resolveDependecies() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }


}
