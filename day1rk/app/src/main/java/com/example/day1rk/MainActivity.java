package com.example.day1rk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.NetworkUtils;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void btn(View view) {
        Intent intent=new Intent(MainActivity.this,OtherActivity.class);
        intent.putExtra("s","你好");
        startActivity(intent);
    }

    public void btn1(View view) {
        EventBus.getDefault().postSticky("ss");
    }
}