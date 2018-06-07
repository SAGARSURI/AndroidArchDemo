package com.contest.androidarchdemo.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.contest.androidarchdemo.MyApplication;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ApiRepository {

    @Inject
    MyApplication application;

    @Inject
    Retrofit retrofit;

    public ApiRepository(MyApplication application) {
        application.getComponent().inject(this);
    }

    public LiveData<NetworkResponse> getPost() {
        final MutableLiveData<NetworkResponse> result = new MutableLiveData<>();
        ApiService api = retrofit.create(ApiService.class);
        Call<PostData> call = api.getPost();
        call.enqueue(new Callback<PostData>() {
            @Override
            public void onResponse(Call<PostData> call, Response<PostData> response) {
                Log.e("Repo",response.toString());
                result.postValue(new NetworkResponse(response.body()));
            }

            @Override
            public void onFailure(Call<PostData> call, Throwable t) {
                Log.e("Repo",t.getLocalizedMessage());
                result.postValue(new NetworkResponse(t));
            }
        });
        return result;
    }
}
