package com.example.day1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Date:2021/11/9 0009
 * Time:15:04
 * author:waizong
 * Describe:
 */
public class MyViewModel extends ViewModel {
    public MutableLiveData<Integer> mutableLiveData=new MutableLiveData<>();

    public MyViewModel(int i) {
        mutableLiveData.postValue(i);
    }

    public void add(){
        if (mutableLiveData.getValue()==null){
            mutableLiveData.setValue(1);
        }else{
            Integer value = mutableLiveData.getValue();
            mutableLiveData.postValue(++value);
        }
    }
}