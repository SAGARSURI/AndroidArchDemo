package com.contest.androidarchdemo.presenter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.contest.androidarchdemo.MyApplication;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private LoginResultCallBack mDataListener;
    private MyApplication application;

    public LoginViewModelFactory(MyApplication application, LoginResultCallBack loginResultCallBack) {
        this.application = application;
        mDataListener = loginResultCallBack;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(application, mDataListener);
    }
}
