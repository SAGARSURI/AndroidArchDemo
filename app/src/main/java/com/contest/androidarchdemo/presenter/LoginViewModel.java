package com.contest.androidarchdemo.presenter;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;

import com.contest.androidarchdemo.MyApplication;
import com.contest.androidarchdemo.model.ApiRepository;
import com.contest.androidarchdemo.model.NetworkResponse;

public class LoginViewModel extends AndroidViewModel {

    private LoginResultCallBack mDataListener;
    public LiveData<NetworkResponse> result;

    private ApiRepository apiRepository;

    public LoginViewModel(@NonNull MyApplication application, @NonNull LoginResultCallBack loginResultCallBack) {
        super(application);
        mDataListener = loginResultCallBack;
        apiRepository = new ApiRepository(application);
    }

    public boolean isDetailValid(String email, String password) {
        if (!email.isEmpty() && !password.isEmpty()) {
            return true;
        } else {
            mDataListener.onError("Error");
            return false;
        }
    }

    public void submit(String email, String password) {
        Log.e("LoginViewModel","Called");
        result = apiRepository.getPost();
    }
}
