package com.huzzey.mobile.foursquaretest.datatypes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public class Items {
    @SerializedName("venue")
    Venue venue;

    public Venue getVenue() {
        return venue;
    }
}
