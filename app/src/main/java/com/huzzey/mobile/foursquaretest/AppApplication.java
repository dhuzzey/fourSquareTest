package com.huzzey.mobile.foursquaretest;

import android.app.Application;

import com.huzzey.mobile.foursquaretest.dagger.ContextComponent;
import com.huzzey.mobile.foursquaretest.dagger.ContextModules;
import com.huzzey.mobile.foursquaretest.dagger.DaggerContextComponent;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public class AppApplication extends Application {
    private static ContextComponent contextComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        contextComponent = DaggerContextComponent.builder().contextModules(new ContextModules(this)).build();

    }

    public static ContextComponent getContextComponent() {
        return contextComponent;
    }
}
