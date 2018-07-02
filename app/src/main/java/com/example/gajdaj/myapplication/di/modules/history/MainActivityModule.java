package com.example.gajdaj.myapplication.di.modules.history;


import com.example.gajdaj.myapplication.di.modules.history.list.HistoryModule;
import com.example.gajdaj.myapplication.di.modules.history.settings.SettingsModule;
import com.example.gajdaj.myapplication.di.scopes.FragmentScope;
import com.example.gajdaj.myapplication.ui.history.list.HistoryFragment;
import com.example.gajdaj.myapplication.ui.history.settings.SettingsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = {HistoryModule.class})
    HistoryFragment myHistoryFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {SettingsModule.class})
    SettingsFragment mySettingsFragment();
}