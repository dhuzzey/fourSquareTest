package com.huzzey.mobile.foursquaretest;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huzzey.mobile.foursquaretest.helpers.VolleyHelper;
import com.huzzey.mobile.foursquaretest.model.FourSquareResponse;
import com.huzzey.mobile.foursquaretest.model.GsonRequest;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public class MainPresenter implements MainContract.Action {
    private final String LOG = getClass().getSimpleName();
    private MainContract.View view;
    private VolleyHelper helper;
    private Context context;

    private Runnable r;
    private Handler handler;
    private final long DELAY = 1000;

    public MainPresenter(MainContract.View view, VolleyHelper volleyHelper, Context context) {
        this.view = view;
        helper = volleyHelper;
        this.context = context;

        view.hideSpinner();
    }

    @Override
    public void afterTextChanged(final Editable s) {
        if(s.toString().length() >= 3) {
            view.hideList();
            view.showSpinner();

            r = new Runnable() {
                @Override
                public void run() {
                    callAPI(context, s.toString());
                }
            };
            handler = new Handler();
            handler.postDelayed(r, DELAY);
        }
    }

    @Override
    public void onTextChanged() {
        if(handler != null){
            handler.removeCallbacks(r);
            helper.cancelQueue();
        }
    }

    private void callAPI(final Context context, String text) {
        String url = "https://api.foursquare.com/v2/venues/explore?near={1}&oauth_token=5JGFCSAMVKANQ4ADSB5KHOBC05BMSU2D3ZJNN1K15SAGCTXL&v=20160511";
        GsonRequest<FourSquareResponse> request = new GsonRequest<>(Request.Method.GET, url.replace("{1}", text), FourSquareResponse.class, new Response.Listener<FourSquareResponse>() {
            @Override
            public void onResponse(FourSquareResponse response) {
                view.hideSpinner();
                Log.w(LOG, "response " + response.getMeta().getCode());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                view.hideSpinner();
                Log.w(LOG, "error " + error);
            }
        });
        helper.addToRequestQueue(request);
    }
}
