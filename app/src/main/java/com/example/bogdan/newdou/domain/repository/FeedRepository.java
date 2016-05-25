package com.example.bogdan.newdou.domain.repository;


import com.example.bogdan.newdou.domain.FeedItem;

import java.util.List;

import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 25.05.16
 */
public interface FeedRepository {

    /**
     * Get feeds from stored URL
     * @return Observable with feed
     */
    Observable<List<FeedItem>> getFeed(String url);

}
