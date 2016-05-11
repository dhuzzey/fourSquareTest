package com.huzzey.mobile.foursquaretest.datatypes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public class Venue {
    @SerializedName("name")
    String name;

    @SerializedName("categories")
    List<Categories> list;


    public class Categories {
        @SerializedName("name")
        String name;


    }
}
