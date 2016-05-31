package com.huzzey.mobile.foursquaretest;

import android.util.Log;

import com.huzzey.mobile.foursquaretest.model.FourSquareResponse;
import com.huzzey.mobile.foursquaretest.model.GetData;
import com.huzzey.mobile.foursquaretest.model.GetDataContract;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public class MainPresenter implements MainContract.Action {
    private final String LOG = getClass().getSimpleName();
    private MainContract.View view;
    private GetDataContract getData;

//    private Runnable r;
//    private Handler handler;
//    private final long DELAY = 1000;

    public MainPresenter(MainContract.View view, GetDataContract getData) {
        this.view = view;
        this.getData = getData;
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

//            r = new Runnable() {
//                @Override
//                public void run() {
                getData.callApi(getDataInterface(), s);
//                }
//            };
//            handler = new Handler();
//            handler.postDelayed(r, DELAY);
        } else {
            view.hideList();
            view.hideSpinner();
            view.updateActionbar(R.string.actionBarDefault);
        }
    }

    @Override
    public void onTextChanged() {
//        if(handler != null){
//            handler.removeCallbacks(r);
            getData.cancelCall();
//        }
    }

    private GetData.GetDataInterface getDataInterface(){
        return new GetData.GetDataInterface() {
            @Override
            public void onSuccess(FourSquareResponse response) {
                view.hideSpinner();
                view.updateList(response.getList());
                view.updateActionbar(response.getResponse().getLocation());
            }

            @Override
            public void onError() {
                view.hideSpinner();
                view.updateActionbar(R.string.actionBarDefault);
            }
        };
    }

    @Override
    public void onDestroy() {
        Log.w(LOG, "ondestroy");
        getData.cancelCall();
        getData = null;
        view = null;
    }
}
