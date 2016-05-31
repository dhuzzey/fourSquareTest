package com.huzzey.mobile.foursquaretest.model;

/**
 * Created by darren.huzzey on 25/05/16.
 */
public class GetDataMock implements GetDataContract{
    public final static int GETDATAPASS = 0;
    public final static int GETDATAFAIL = 1;

    private int testType;

    public GetDataMock(int type) {
        testType = type;
    }

    @Override
    public void callApi(GetData.GetDataInterface getDataResponse, String text) {
        if(testType == GETDATAPASS){
            getDataResponse.onSuccess(new FourSquareResponse());
        } else {
            getDataResponse.onError();
        }
    }

    @Override
    public void cancelCall() {

    }
}
