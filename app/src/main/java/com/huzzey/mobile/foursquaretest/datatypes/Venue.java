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

    public List<Categories> getList() {
        return list;
    }

    public String getName() {
        return name;
    }

    public class Categories {

        @SerializedName("icon")
        Icon icon;

        public Icon getIcon() {
            return icon;
        }

        public String getIconUrl(){
            return icon.getPrefix() + "bg_64" + icon.getSuffix();
        }

        @Override
        public String toString() {
            return "Categories{" +
                    " icon='" + icon.toString() + '\'' +
                    '}';
        }
    }

    private class Icon {
        @SerializedName("prefix")
        String prefix;
        @SerializedName("suffix")
        String suffix;

        public String getPrefix() {
            return prefix;
        }

        public String getSuffix() {
            return suffix;
        }

        @Override
        public String toString() {
            return "Icon{" +
                    "prefix='" + prefix + '\'' +
                    ", suffix='" + suffix + '\'' +
                    '}';
        }
    }
}
