package com.example.day1.text;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableField;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import com.example.day1.BR;
import com.example.day1.Food;
import com.example.day1.R;
import com.example.day1.databinding.MyBinding;
import com.example.day1.kj.BaseMVVMActivity;

import java.util.HashMap;

public class MainActivity3 extends BaseMVVMActivity<UserCenterViewModel, MyBinding> {

    private static final String TAG = "MainActivity3";
    public ObservableField<Food> pageDataSource=new ObservableField<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageDataSource.set(new Food());
        vm.initResource();
        vm.getFood().observe(this, new Observer<Food>() {
            @Override
            public void onChanged(Food food) {
                Log.i(TAG, "onChanged: "+food.getData().size());
                pageDataSource.set(food);
            }
        });
    }

    @Override
    protected void preSet(HashMap<Integer, Object> hashMap) {
        hashMap.put(BR._all,this);
    }

    @Override
    protected UserCenterViewModel createViewModel() {
        return new UserCenterViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main3;
    }
}











