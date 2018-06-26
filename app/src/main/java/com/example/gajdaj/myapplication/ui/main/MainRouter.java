package com.example.gajdaj.myapplication.ui.main;

import com.example.gajdaj.myapplication.ui.BaseActivity;
import com.example.gajdaj.myapplication.ui.ViewRouter;
import com.example.gajdaj.myapplication.ui.main.history.HistoryFragment;
import com.example.gajdaj.myapplication.ui.main.settings.SettingsFragment;

public class MainRouter extends ViewRouter {

    public MainRouter(BaseActivity context) {
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
