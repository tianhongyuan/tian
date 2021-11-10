package com.example.day1.kj;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initEnv();
        initEvent();
        initData();
    }

    protected abstract void initEnv();

    protected abstract void initData();

    protected abstract void initEvent();



}
