package com.huzzey.mobile.foursquaretest;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public class MainPresenter implements MainContract.Action {
    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;

    }
}
