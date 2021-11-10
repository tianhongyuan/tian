package com.example.day1.text;

import androidx.lifecycle.LiveData;

import com.example.day1.Food;
import com.example.day1.kj.IModel;


public class UserCenterModel implements IModel {
    private static final String TAG = "UserCenterModel";

    public LiveData<Food> getFood(){
        Api api = RetrofitFactory.getRetrofitFactory().create(Api.class);
        LiveData<Food> food = api.getFood();
        return food;
    }
}
