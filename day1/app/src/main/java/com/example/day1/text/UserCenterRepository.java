package com.example.day1.text;

import androidx.lifecycle.LiveData;

import com.example.day1.Food;
import com.example.day1.kj.BaseRepository;
import com.example.day1.kj.Model;


public class UserCenterRepository  extends BaseRepository {

    @Model
    private UserCenterModel model;

    public LiveData<Food> getFood(){
        return model.getFood();
    }

}
