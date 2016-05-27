package com.example.bogdan.newdou.data.api;

import com.example.bogdan.newdou.data.entity.FeedItemEntity;
import com.example.bogdan.newdou.domain.FeedItem;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 26.05.16
 */
public interface DouAPI {

    @GET("{rubric}/page/{page-number}")
    Observable<List<FeedItemEntity>> getFeedEntityByRubric(@Path("rubric") String rubric, @Path("page-number") int pageNumber);

    @GET("page/{page-number}")
    Observable<List<FeedItemEntity>> getFeedEntity(@Part("page-number") int pageNumber);

}
