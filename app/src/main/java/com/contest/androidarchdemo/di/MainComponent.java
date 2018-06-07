package com.contest.androidarchdemo.di;

import com.contest.androidarchdemo.ui.MainActivity;
import com.contest.androidarchdemo.model.ApiRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, SharedPrefsModule.class, ApiModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
    void inject(ApiRepository apiRespository);
}
