package com.contest.androidarchdemo.presenter;

public interface LoginResultCallBack {
    void onSuccess(String message);

    void onError(String message);

    void showProgress();

    void hideProgress();
}
