package com.example.gajdaj.myapplication.ui;

import android.content.Intent;

import com.example.gajdaj.myapplication.ui.main.settings.SettingsFragment;


public abstract class ViewRouter {


    protected BaseActivity context;

    public ViewRouter(BaseActivity context) {
        this.context = context;
    }

    protected void addFragment(BaseFragment fragment, int container) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .add(container, fragment)
                .commit();
    }

    protected void replaceFragment(BaseFragment fragment, int container) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment)
                .commit();
    }

    public void startActivity(Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }
}
