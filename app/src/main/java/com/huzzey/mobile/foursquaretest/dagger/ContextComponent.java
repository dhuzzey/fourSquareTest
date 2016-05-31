package com.huzzey.mobile.foursquaretest.dagger;

import com.huzzey.mobile.foursquaretest.model.GetData;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by darren.huzzey on 11/05/16.
 */
@Singleton
@Component(modules = ContextModules.class)
public interface ContextComponent {
    void inject(GetData data);
}
