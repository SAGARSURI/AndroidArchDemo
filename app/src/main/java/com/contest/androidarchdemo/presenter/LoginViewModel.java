package com.contest.androidarchdemo.presenter;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.annotation.NonNull;
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
