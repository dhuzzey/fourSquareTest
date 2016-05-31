package com.huzzey.mobile.foursquaretest.model;

/**
 * Created by darren.huzzey on 25/05/16.
 */
public interface GetDataContract {
    void callApi(GetData.GetDataInterface getDataResponse, String text);
    void cancelCall();
}
