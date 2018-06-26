package com.example.gajdaj.myapplication.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected ViewRouter router;

    protected abstract void createRouter();
    protected abstract void initUi();

}
