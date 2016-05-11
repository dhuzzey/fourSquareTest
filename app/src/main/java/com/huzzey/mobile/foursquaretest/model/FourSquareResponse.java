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
    @SerializedName("response")
    Response response;

    public List<Items> getList() {
        return response.getGroups().get(0).getList();
    }

    public Response getResponse() {
        return response;
    }

    public Meta getMeta() {
        return meta;
    }

    public class Response {
        @SerializedName("groups")
        List<Group> groups;
        @SerializedName("headerLocation")
        String location;

        public List<Group> getGroups() {
            return groups;
        }

        public String getLocation() {
            return location;
        }
    }

    public class Group {
        @SerializedName("items")
        List<Items> list;

        public List<Items> getList() {
            return list;
        }
    }

    public class Items {
        @SerializedName("venue")
        Venue venue;

        public Venue getVenue() {
            return venue;
        }
    }
}
