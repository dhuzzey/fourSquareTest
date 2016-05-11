package com.huzzey.mobile.foursquaretest;

import android.text.Editable;

import com.huzzey.mobile.foursquaretest.datatypes.Items;

import java.util.List;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public interface MainContract {

    interface View {
        void updateList(List<Items> list);
        void hideList();
        void showSpinner();
        void hideSpinner();
        void updateActionbar(String title);
        void updateActionbar(int title);
    }

    interface Action {
        void onTextChanged();
        void afterTextChanged(Editable s);
    }
}
