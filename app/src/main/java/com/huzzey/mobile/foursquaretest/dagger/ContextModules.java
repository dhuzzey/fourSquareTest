package com.huzzey.mobile.foursquaretest.dagger;

import com.huzzey.mobile.foursquaretest.AppApplication;
import com.huzzey.mobile.foursquaretest.BuildConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by darren.huzzey on 11/05/16.
 */
@Module
public class ContextModules {
    private AppApplication appApplication;

    public ContextModules(AppApplication appApplication) {
        this.appApplication = appApplication;

    }

    @Singleton
    @Provides
    public AppApplication provideAppApplication() {
        return appApplication;
    }


    @Singleton
    @Provides
    public Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
