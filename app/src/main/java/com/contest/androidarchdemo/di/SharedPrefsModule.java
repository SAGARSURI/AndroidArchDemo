package com.contest.androidarchdemo.di;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.contest.androidarchdemo.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPrefsModule {
    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(MyApplication application){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }


}
