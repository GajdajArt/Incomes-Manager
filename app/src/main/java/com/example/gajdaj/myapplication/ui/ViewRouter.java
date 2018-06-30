package com.example.gajdaj.myapplication.ui;

import android.content.Intent;

import com.example.gajdaj.myapplication.presentation.PresenterView;
import com.example.gajdaj.myapplication.ui.main.settings.SettingsFragment;


public abstract class ViewRouter <A extends BaseActivity> {

    protected A context;

    public ViewRouter(A context) {
        this.context = context;
    }

    protected void replaceFragment(BaseFragment fragment, int container) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment)
                .commit();
    }

    public void startActivity(Class clazz, int finTransactionID) {
        Intent intent = new Intent(context, clazz);
        intent.putExtra(PresenterView.ID_KEY, finTransactionID);
        context.startActivity(intent);
    }
    public void startActivity(Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }
}
