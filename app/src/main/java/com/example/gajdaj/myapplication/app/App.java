package com.example.gajdaj.myapplication.app;

import android.app.Activity;
import android.app.Application;

import com.example.gajdaj.myapplication.db.sqlite.SQLiteRepository;
import com.example.gajdaj.myapplication.di.components.DaggerAppComponent;
import com.example.gajdaj.myapplication.domain.TransactionRepository;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector{

    private static TransactionRepository repository;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        repository = new SQLiteRepository(getApplicationContext());
        DaggerAppComponent
                .builder()
                .context(this)
                .build()
                .inject(this);
    }

    public static TransactionRepository getRepository() {
        return repository;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
