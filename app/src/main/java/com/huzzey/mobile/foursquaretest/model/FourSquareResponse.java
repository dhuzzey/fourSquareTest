package com.huzzey.mobile.foursquaretest.model;

import com.google.gson.annotations.SerializedName;
import com.huzzey.mobile.foursquaretest.datatypes.Items;
import com.huzzey.mobile.foursquaretest.datatypes.Meta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public class FourSquareResponse {
    @SerializedName("meta")
    Meta meta;
    @SerializedName("response")
    Response response;

    public FourSquareResponse() {
        response = new Response();
    }

    public List<Items> getList() {
        try {
            return response.getGroups().get(0).getList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
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
            return location == null ? "" : location;
        }
    }

    public class Group {
        @SerializedName("items")
        List<Items> list;

        public List<Items> getList() {
            return list;
        }
    }
}
