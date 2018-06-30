package com.example.gajdaj.myapplication.di.modules.main.settings;

import com.example.gajdaj.myapplication.ui.main.history.HistoryFragment;
import com.example.gajdaj.myapplication.ui.main.history.HistoryView;
import com.example.gajdaj.myapplication.ui.main.settings.SettingsFragment;
import com.example.gajdaj.myapplication.ui.main.settings.SettingsView;

import dagger.Binds;
import dagger.Module;

/**
 * Created by pc on 30.06.2018.
 */
@Module
public abstract class SettingsModule {

    @Binds
    public abstract SettingsView mySettingsView(SettingsFragment settingsFragment);
}
