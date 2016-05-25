package com.example.bogdan.newdou.domain.interactor;

import com.example.bogdan.newdou.Constants;
import com.example.bogdan.newdou.domain.repository.FeedRepository;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 25.05.16
 */
public class GetFeedInteractor extends Interactor{
    private FeedRepository mFeedRepository;

    @Inject
    public GetFeedInteractor(FeedRepository feedRepository,
                             @Named(Constants.DI.EXECUTOR_THREAD)Scheduler mExecutorThread,
                             @Named(Constants.DI.UI_THREAD)Scheduler mUIScheduler) {
        super(mExecutorThread, mUIScheduler);
        mFeedRepository = feedRepository;
    }
    @Override
    protected Observable buildInteractorObservable() {
        return mFeedRepository.getFeed();
    }
}
