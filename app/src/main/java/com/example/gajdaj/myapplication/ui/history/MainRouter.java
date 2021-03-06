package com.example.gajdaj.myapplication.ui.history;

import com.example.gajdaj.myapplication.ui.ViewRouter;
import com.example.gajdaj.myapplication.ui.history.list.HistoryFragment;
import com.example.gajdaj.myapplication.ui.history.settings.SettingsFragment;

import javax.inject.Inject;

public class MainRouter extends ViewRouter<MainActivity> {

    @Inject
    public MainRouter(MainActivity context) {
        super(context);
    }

    public void showHistory(int container) {
        HistoryFragment historyFragment = HistoryFragment.getInstance();
        replaceFragment(historyFragment, container);
    }

    public void showSettings(int container) {
        SettingsFragment settingsFragment = SettingsFragment.getInstance();
        replaceFragment(settingsFragment, container);
    }
}
