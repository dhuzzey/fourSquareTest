package com.huzzey.mobile.foursquaretest.model;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huzzey.mobile.foursquaretest.AppApplication;
import com.huzzey.mobile.foursquaretest.helpers.VolleyHelper;

import javax.inject.Inject;

/**
 * Created by darren.huzzey on 25/05/16.
 */
public class GetData implements GetDataContract{
    @Inject
    VolleyHelper helper;

    public GetData() {
        AppApplication.getContextComponent().inject(this);
    }

    @Override
    public void callApi(final GetDataInterface getDataResponse, String text) {
        String url = "https://api.foursquare.com/v2/venues/explore?near={1}&oauth_token=5JGFCSAMVKANQ4ADSB5KHOBC05BMSU2D3ZJNN1K15SAGCTXL&v=20160511";
        GsonRequest<FourSquareResponse> request = new GsonRequest<>(Request.Method.GET, url.replace("{1}", text), FourSquareResponse.class, new Response.Listener<FourSquareResponse>() {
            @Override
            public void onResponse(FourSquareResponse response) {
                getDataResponse.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                getDataResponse.onError();
            }
        });
        helper.addToRequestQueue(request);
    }

    @Override
    public void cancelCall() {
        helper.cancelQueue();
    }

    public interface GetDataInterface {
        void onSuccess(FourSquareResponse response);
        void onError();
    }
}
