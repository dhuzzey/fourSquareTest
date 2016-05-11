package com.huzzey.mobile.foursquaretest.helpers;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import dagger.Module;

/**
 * Created by darren.huzzey on 11/05/16.
 */
@Module
public class VolleyHelper {
    private RequestQueue requestQueue;
    private final Context context;

    public VolleyHelper(Context context) {
        this.context = context;
        requestQueue = getRequestQueue();
    }


    private RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public void cancelQueue(){
        getRequestQueue().cancelAll(new RequestQueue.RequestFilter() {
            @Override
            public boolean apply(Request<?> request) {
                return true;
            }
        });
    }
}
