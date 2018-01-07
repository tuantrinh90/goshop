package com.goshop.app.base;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.support.v7.app.AppCompatActivity;

import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle;
import com.trello.rxlifecycle2.LifecycleProvider;

/**
 * Created by ray on 2017/9/25.
 * 
 */

@SuppressLint("Registered")
public class RxLifecycleActivity extends AppCompatActivity{
    private final LifecycleRegistry lifecycleRegistry =new  LifecycleRegistry(this);
    protected final LifecycleProvider<Lifecycle.Event> lifecycleProvider = AndroidLifecycle.createLifecycleProvider(this);
    @Override
    public LifecycleRegistry getLifecycle(){
        return lifecycleRegistry;
    }

}
