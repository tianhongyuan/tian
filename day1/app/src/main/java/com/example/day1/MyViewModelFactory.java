package com.example.day1;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Date:2021/11/9 0009
 * Time:15:19
 * author:waizong
 * Describe:
 */
public class MyViewModelFactory implements ViewModelProvider.Factory{
   private int index;

    public MyViewModelFactory(int index) {
        this.index = index;
    }
    @Override
    public <T extends ViewModel> T create(@NonNull  Class<T> modelClass) {
        return (T)new MyViewModel(index);
    }
}
