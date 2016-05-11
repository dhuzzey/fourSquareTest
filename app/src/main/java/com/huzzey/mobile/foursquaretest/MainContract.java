package com.huzzey.mobile.foursquaretest;

import android.text.Editable;

import com.huzzey.mobile.foursquaretest.datatypes.Venue;

import java.util.List;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public interface MainContract {

    interface View {
        void updateList(List<Venue> list);
        void hideList();
        void showSpinner();
        void hideSpinner();
    }

    interface Action {
        void onTextChanged();
        void afterTextChanged(Editable s);
    }
}
