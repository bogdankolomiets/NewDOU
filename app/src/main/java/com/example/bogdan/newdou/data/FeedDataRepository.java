package com.example.bogdan.newdou.data;

import com.example.bogdan.newdou.data.api.DouAPI;
import com.example.bogdan.newdou.data.entity.FeedItemEntity;
import com.example.bogdan.newdou.data.entity.mapper.FeedItemEntityMapper;
import com.example.bogdan.newdou.domain.FeedItem;
import com.example.bogdan.newdou.domain.repository.FeedRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 25.05.16
 */
public class FeedDataRepository implements FeedRepository {
    @Inject
    DouAPI apiInterface;

    @Inject
    FeedItemEntityMapper entityMapper;

    @Override
    public Observable<List<FeedItem>> feedByRubric(String rubric, int pageNumber) {
        return apiInterface.getFeedEntityByRubric(rubric, pageNumber)
                .map(entityMapper);
    }

    @Override
    public Observable<List<FeedItem>> feed(int page) {
        return apiInterface
                .getFeedEntity(page)
                .map(entityMapper);
    }

}
