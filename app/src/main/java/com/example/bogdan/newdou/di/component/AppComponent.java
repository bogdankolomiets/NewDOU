package com.example.bogdan.newdou.di.component;

import com.example.bogdan.newdou.Constants;
import com.example.bogdan.newdou.di.module.AppModule;

import javax.inject.Named;

import dagger.Component;
import rx.Scheduler;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 23.05.16
 */
@Component(modules = AppModule.class)
public interface AppComponent {

  @Named(Constants.DI.EXECUTOR_THREAD)
  Scheduler executorScheduler();

  @Named(Constants.DI.UI_THREAD)
  Scheduler uiScheduler();

}
