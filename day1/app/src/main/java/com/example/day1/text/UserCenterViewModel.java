package com.example.day1.text;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.day1.Food;
import com.example.day1.kj.BaseViewModel;


public class UserCenterViewModel extends BaseViewModel<UserCenterRepository> {

    public MutableLiveData<Food> dataSource=new MutableLiveData<>();

    public UserCenterViewModel(LifecycleOwner owner) {
        super(owner);
        dataSource.setValue(new Food());
    }

    @Override
    protected UserCenterRepository createRepository() {
        return new UserCenterRepository();
    }


    public LiveData<Food> getFood(){
        return mRepository.getFood();
    }


    @Override
    public void initResource() {

    }
}
