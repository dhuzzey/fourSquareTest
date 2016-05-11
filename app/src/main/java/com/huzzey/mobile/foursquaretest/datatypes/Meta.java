package com.huzzey.mobile.foursquaretest.datatypes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public class Meta {
    @SerializedName("code")
    Integer code;
    @SerializedName("requestId")
    String requestId;

    public Integer getCode() {
        return code;
    }

    public String getRequestId() {
        return requestId;
    }
}
