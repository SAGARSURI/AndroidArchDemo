package com.contest.androidarchdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NetworkResponse {
    private PostData postData;
    private Throwable t;

    public NetworkResponse(PostData postData){
        this.postData = postData;
        this.t = null;
    }

    public NetworkResponse(Throwable t){
        this.t = t;
        this.postData = null;
    }

    public PostData getPostData() {
        return postData;
    }

    public Throwable getError() {
        return t;
    }

    public void setPostData(PostData postData) {
        this.postData = postData;
    }

    public void setError(Throwable t) {
        this.t = t;
    }
}
