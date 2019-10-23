package com.contest.androidarchdemo.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.contest.androidarchdemo.MyApplication;
import com.contest.androidarchdemo.R;
import com.contest.androidarchdemo.model.NetworkResponse;
import com.contest.androidarchdemo.presenter.LoginResultCallBack;
import com.contest.androidarchdemo.presenter.LoginViewModel;
import com.contest.androidarchdemo.presenter.LoginViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LoginResultCallBack {

    @Inject
    MyApplication application;

    LoginViewModel loginViewModel;

    @BindView(R.id.emailText)
    EditText emailText;
    @BindView(R.id.passwordText)
    EditText passwordText;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((MyApplication) getApplication()).getComponent().inject(this);
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory(application, this)).get(LoginViewModel.class);
    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        Log.e("MainActivity", "ShowProgress");
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    public void submit(View view) {
        if (loginViewModel.isDetailValid(emailText.getText().toString(), passwordText.getText().toString())) {
            progressBar.setVisibility(View.VISIBLE);
            loginViewModel.submit(emailText.getText().toString(), passwordText.getText().toString());
            loginViewModel.result.observe(this, new Observer<NetworkResponse>() {
                @Override
                public void onChanged(@Nullable NetworkResponse networkResponse) {
                    progressBar.setVisibility(View.GONE);
                    assert networkResponse != null;
                    if (networkResponse.getPostData() != null) {
                        Toast.makeText(MainActivity.this, networkResponse.getPostData().getBody(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    } else {
                        Toast.makeText(MainActivity.this, networkResponse.getError().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }
            });
        }
    }
}
