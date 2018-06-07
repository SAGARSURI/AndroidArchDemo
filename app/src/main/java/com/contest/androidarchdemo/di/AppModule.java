package com.contest.androidarchdemo.di;


import com.contest.androidarchdemo.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private MyApplication mApplication;

    public AppModule(MyApplication application){
        mApplication = application;
    }

    @Provides
    @Singleton
    MyApplication provideApplication(){
        return mApplication;
    }
}
