package com.huzzey.mobile.foursquaretest.dagger;

import com.huzzey.mobile.foursquaretest.AppApplication;
import com.huzzey.mobile.foursquaretest.helpers.VolleyHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by darren.huzzey on 11/05/16.
 */
@Module
public class ContextModules {
    private VolleyHelper volleyHelper;
    private AppApplication appApplication;

    public ContextModules(AppApplication appApplication) {
        this.appApplication = appApplication;
        volleyHelper = new VolleyHelper(appApplication);
    }

    @Singleton
    @Provides
    public AppApplication provideAppApplication() {
        return appApplication;
    }

    @Singleton
    @Provides
    public VolleyHelper provideVolleyHelper() {
        return volleyHelper;
    }
}
