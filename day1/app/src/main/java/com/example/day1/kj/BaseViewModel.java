package com.example.day1.kj;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;


public abstract class BaseViewModel<Repo extends BaseRepository> extends ViewModel implements LifecycleObserver {
    protected Repo mRepository;
    private LifecycleOwner owner;

    public BaseViewModel(LifecycleOwner owner) {
        this.owner = owner;
        mRepository = createRepository();
        owner.getLifecycle().addObserver(this);
    }

    protected abstract Repo createRepository();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void uiConnect(){
        initResource();
    }

    protected abstract void initResource();
    protected void releaseResource(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disConnect(){
        releaseResource();
        owner.getLifecycle().removeObserver(this);
    }
}
