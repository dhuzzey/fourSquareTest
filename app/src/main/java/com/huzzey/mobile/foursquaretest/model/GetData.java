package com.huzzey.mobile.foursquaretest.model;

import com.huzzey.mobile.foursquaretest.AppApplication;
import com.huzzey.mobile.foursquaretest.BuildConfig;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by darren.huzzey on 25/05/16.
 */
public class GetData {
    private Api api;

    public GetData(Retrofit retrofit) {
        api = retrofit.create(Api.class);
    }

    public Single<FourSquareResponse> callApi(String text) {
        return api.doFourSquareSearch(text, BuildConfig.TOKEN, BuildConfig.V_CODE)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io());
    }

    public interface Api {
        @Headers({"Accept: application/json"})
        @GET("/v2/venues/explore")
        Single<FourSquareResponse> doFourSquareSearch(@Query("near") String near,
                                                      @Query("oauth_token") String token,
                                                      @Query("v") String vString);
    }
}
