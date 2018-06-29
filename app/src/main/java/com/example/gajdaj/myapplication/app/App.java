package com.example.gajdaj.myapplication.app;

import android.app.Application;

import com.example.gajdaj.myapplication.db.sqlite.SQLiteRepository;
import com.example.gajdaj.myapplication.domain.TransactionRepository;

public class App extends Application{

    private static TransactionRepository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        repository = new SQLiteRepository(getApplicationContext());
    }

    public static TransactionRepository getRepository() {
        return repository;
    }
}
