package com.huzzey.mobile.foursquaretest;

import android.text.Editable;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public interface MainContract {

    interface View {
        void updateList();
        void hideList();
        void showSpinner();
        void hideSpinner();
    }

    interface Action {
        void onTextChanged();
        void afterTextChanged(Editable s);
    }
}
