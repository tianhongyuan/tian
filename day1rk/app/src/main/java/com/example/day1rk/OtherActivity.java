package com.example.day1rk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Intent intent=getIntent();
        String s = intent.getStringExtra("s");
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();

        EventBus.getDefault().register(this);
        
    }
    @Subscribe(sticky = true)
    public void S(String ss){
        Toast.makeText(this, ""+ss, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}