package com.example.gajdaj.myapplication.ui;

import android.content.Intent;

import com.example.gajdaj.myapplication.R;
import com.example.gajdaj.myapplication.ui.editNew.EditItemFragment;
import com.example.gajdaj.myapplication.ui.history.HistoryFragment;
import com.example.gajdaj.myapplication.ui.settings.SettingsFragment;


public class ViewRouter {

    public static final String HISTORY_FRAGMENT_TAG = "history";
    public static final String SETTINGS_FRAGMENT_TAG = "Settings";
    public static final String EDITNEW_FRAGMENT_TAG = "EditNew";

    private BaseActivity context;
    private int container;

    public ViewRouter(BaseActivity context, int container) {
        this.context = context;
        this.container = container;
    }

    public void addFragment(BaseFragment fragment, String tag) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .add(container, fragment, tag)
                .commit();
    }

    public void replaceFragment(BaseFragment fragment, String tag) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment, tag)
                .commit();
    }

    public void runNextActivity(Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    public HistoryFragment getHistoryFragment() {
        HistoryFragment historyFragment =
                (HistoryFragment) context.getSupportFragmentManager().findFragmentByTag(HISTORY_FRAGMENT_TAG);
        if (historyFragment == null) {
            historyFragment = HistoryFragment.getInstance();
        }


        return historyFragment;
    }

    public SettingsFragment getSettingsFragment() {
        SettingsFragment settingsFragment =
                (SettingsFragment) context.getSupportFragmentManager().findFragmentByTag(SETTINGS_FRAGMENT_TAG);
        if (settingsFragment == null) {
            settingsFragment = SettingsFragment.getInstance();
        }
        return settingsFragment;
    }

    public EditItemFragment getEditItemFragment() {
        EditItemFragment editItemFragment =
                (EditItemFragment) context.getSupportFragmentManager().findFragmentByTag(EDITNEW_FRAGMENT_TAG);
        if (editItemFragment == null) {
            editItemFragment = EditItemFragment.getInstance();
        }
        return editItemFragment;
    }
}
