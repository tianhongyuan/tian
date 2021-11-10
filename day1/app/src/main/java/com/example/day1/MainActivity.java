package com.example.day1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.day1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private TextView count;
    private MyViewModel myViewModel;
    private SharedPreferences sharedPreferences;
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Food food = new Food();
        food.setRet(520);
        activityMainBinding.setFood(food);
        initView();

        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        int core = sharedPreferences.getInt("core",  0);

        myViewModel = ViewModelProviders.of(this,new MyViewModelFactory(core)).get(MyViewModel.class);

        this.myViewModel.mutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                count.setText(String.valueOf(MainActivity.this.myViewModel.mutableLiveData.getValue()));
            }
        });
    }

    public void btn(View view) {
        myViewModel.add();
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("core",myViewModel.mutableLiveData.getValue());
        edit.commit();
    }

    private void initView() {
        count = findViewById(R.id.count);
    }
}







