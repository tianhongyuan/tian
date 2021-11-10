package com.example.day1.text;

import androidx.lifecycle.LiveData;

import com.example.day1.Food;

import retrofit2.http.GET;

interface Api {

    @GET("/ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
    LiveData<Food> getFood();
}
