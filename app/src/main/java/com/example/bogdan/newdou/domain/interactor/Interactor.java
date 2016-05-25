package com.example.bogdan.newdou.domain.interactor;

import com.example.bogdan.newdou.Constants;

import rx.Observable;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 25.05.16
 */
public abstract class Interactor {
    private final Scheduler mExecuterScheduler;
    private final Scheduler mUIScheduler;

    private Subscription subscription = Subscriptions.empty();

    public Interactor(Scheduler executerScheduler, Scheduler uiScheduler) {
        mExecuterScheduler = executerScheduler;
        mUIScheduler = uiScheduler;
    }

    protected abstract Observable buildInteractorObservable();

    @SuppressWarnings("unchecked")
    public void execute(Subscriber subscriber) {
        this.subscription =  this.buildInteractorObservable()
                .subscribeOn(mExecuterScheduler)
                .observeOn(mUIScheduler)
                .subscribe(subscriber);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed())
            subscription.unsubscribe();
    }
}
