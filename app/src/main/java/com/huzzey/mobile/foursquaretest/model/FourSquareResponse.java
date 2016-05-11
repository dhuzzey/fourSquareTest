package com.huzzey.mobile.foursquaretest.model;

import com.google.gson.annotations.SerializedName;
import com.huzzey.mobile.foursquaretest.datatypes.Meta;
import com.huzzey.mobile.foursquaretest.datatypes.Venue;

import java.util.List;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public class FourSquareResponse {
    @SerializedName("meta")
    Meta meta;
    @SerializedName("items")
    List<Venue> list;

    public List<Venue> getList() {
        return list;
    }

    public Meta getMeta() {
        return meta;
    }
}
