package com.huzzey.mobile.foursquaretest.helpers;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by darren.huzzey on 11/05/16.
 */
@Module
public class VolleyHelper {
    private static RequestQueue requestQueue;
    private final Context context;

    public VolleyHelper(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public RequestQueue provideVolleyQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        provideVolleyQueue().add(req);
    }

    public void cancelQueue(){
        provideVolleyQueue().cancelAll(new RequestQueue.RequestFilter() {
            @Override
            public boolean apply(Request<?> request) {
                return true;
            }
        });
    }
}
