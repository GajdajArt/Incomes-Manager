package com.example.gajdaj.myapplication.di.modules.history.settings;

import com.example.gajdaj.myapplication.ui.history.settings.SettingsFragment;
import com.example.gajdaj.myapplication.ui.history.settings.SettingsView;

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
