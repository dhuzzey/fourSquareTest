package com.huzzey.mobile.foursquaretest;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.huzzey.mobile.foursquaretest.model.FourSquareResponse;
import com.huzzey.mobile.foursquaretest.model.GetData;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public class MainViewModel extends AndroidViewModel {
    private GetData getData;

    @Inject Retrofit retrofit;

    public MainViewModel(@NonNull Application application) {
        super(application);
        AppApplication.getContextComponent().inject(this);
        getData = new GetData(retrofit);
    }

    public Single<FourSquareResponse> afterTextChanged(final String s) {
        return getData.callApi(s);
    }
}
