package com.huzzey.mobile.foursquaretest;

import android.os.Handler;
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

    private Runnable r;
    private Handler handler;
    private final long DELAY = 1000;

    public MainPresenter(MainContract.View view, VolleyHelper volleyHelper) {
        this.view = view;
        helper = volleyHelper;
    }

    @Override
    public void onResume() {
        view.hideSpinner();
        view.updateActionbar(R.string.actionBarDefault);
    }

    @Override
    public void afterTextChanged(final String s) {
        if(s != null && s.length() >= 3) {
            view.hideList();
            view.showSpinner();

            r = new Runnable() {
                @Override
                public void run() {
                    callAPI(s);
                }
            };
            handler = new Handler();
            handler.postDelayed(r, DELAY);
        } else {
            view.hideList();
            view.hideSpinner();
            view.updateActionbar(R.string.actionBarDefault);
        }
    }

    @Override
    public void onTextChanged() {
        if(handler != null){
            handler.removeCallbacks(r);
            helper.cancelQueue();
        }
    }

    private void callAPI(String text) {
        String url = "https://api.foursquare.com/v2/venues/explore?near={1}&oauth_token=5JGFCSAMVKANQ4ADSB5KHOBC05BMSU2D3ZJNN1K15SAGCTXL&v=20160511";
        GsonRequest<FourSquareResponse> request = new GsonRequest<>(Request.Method.GET, url.replace("{1}", text), FourSquareResponse.class, new Response.Listener<FourSquareResponse>() {
            @Override
            public void onResponse(FourSquareResponse response) {
                view.hideSpinner();
                Log.w(LOG, "response " + response.getResponse().getGroups().get(0).getList().size());
                view.updateList(response.getList());
                view.updateActionbar(response.getResponse().getLocation());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                view.hideSpinner();
                view.updateActionbar(R.string.actionBarDefault);
                Log.w(LOG, "error " + error);
            }
        });
        helper.addToRequestQueue(request);
    }
}
