package com.example.bogdan.newdou.di;

import dagger.Component;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 23.05.16
 */
@Component(modules = AppModule.class)
public interface AppComponent {
  
  @Named(Constants.EXECUTOR_THREAD) Scheduler executorScheduler();
  
  @Named(Constants.UI_THREAD) Scheduler uiScheduler();

}
