package com.contest.androidarchdemo;

import android.app.Application;

import com.contest.androidarchdemo.di.ApiModule;
import com.contest.androidarchdemo.di.AppModule;
import com.contest.androidarchdemo.di.DaggerMainComponent;
import com.contest.androidarchdemo.di.MainComponent;
import com.contest.androidarchdemo.di.SharedPrefsModule;

public class MyApplication extends Application {
    MainComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerMainComponent.builder()
                .appModule(new AppModule(this))
                .sharedPrefsModule(new SharedPrefsModule())
                .apiModule(new ApiModule("https://jsonplaceholder.typicode.com"))
                .build();
    }

    public MainComponent getComponent() {
        return component;
    }
}
