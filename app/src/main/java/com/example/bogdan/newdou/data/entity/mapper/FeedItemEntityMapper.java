package com.example.bogdan.newdou.data.entity.mapper;

import com.example.bogdan.newdou.data.entity.FeedItemEntity;
import com.example.bogdan.newdou.domain.FeedItem;
import com.example.bogdan.newdou.domain.repository.FeedRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.05.16
 */
public class FeedItemEntityMapper implements Func1<List<FeedItemEntity>, List<FeedItem>> {

    @Inject
    public FeedItemEntityMapper() {

    }

//    public FeedItem transform(FeedItemEntity feedItemEntity) {
//        FeedItem feedItem = new FeedItem();
//        feedItem.setmUrl(feedItemEntity.getmUrl());
//        feedItem.setmAuthor(feedItemEntity.getmAuthor());
//        feedItem.setmDate(feedItemEntity.getmDate());
//        feedItem.setmWatchCount(feedItemEntity.getmWatchCount());
//        feedItem.setmTitle(feedItemEntity.getmTitle());
//        feedItem.setmDescription(feedItemEntity.getmDescription());
//        feedItem.setmTopic(feedItemEntity.getmTopic());
//        feedItem.setmTags(feedItemEntity.getmTags());
//
//        return feedItem;
//    }
//
//    public List<FeedItem> transform(Collection<FeedItemEntity> feedItemEntityCollection) {
//        List<FeedItem> feedItemsList = new ArrayList<>();
//        FeedItem feedItem;
//        for (FeedItemEntity feedItemEntity : feedItemEntityCollection) {
//            feedItem = transform(feedItemEntity);
//            if (feedItem != null)
//                feedItemsList.add(feedItem);
//        }
//
//        return feedItemsList;
//    }

    @Override
    public List<FeedItem> call(List<FeedItemEntity> feedItemEntities) {
        if (feedItemEntities == null)
            return null;
        List<FeedItem> feedItems = Observable.from(feedItemEntities)
                .map(feedItemEntity -> new FeedItem(feedItemEntity.getmUrl(),
                        feedItemEntity.getmAuthor(), feedItemEntity.getmDate(),
                        feedItemEntity.getmWatchCount(), feedItemEntity.getmTitle(),
                        feedItemEntity.getmDescription(), feedItemEntity.getmTopic(),
                        feedItemEntity.getmTags()))
                .toList()
                .toBlocking()
                .first();

        return feedItems;
    }
}
