package com.example.gajdaj.myapplication.di.modules.main;


import com.example.gajdaj.myapplication.di.modules.main.history.HistoryModule;
import com.example.gajdaj.myapplication.di.modules.main.settings.SettingsModule;
import com.example.gajdaj.myapplication.di.scopes.ActivityScope;
import com.example.gajdaj.myapplication.di.scopes.FragmentScope;
import com.example.gajdaj.myapplication.ui.main.MainRouter;
import com.example.gajdaj.myapplication.ui.main.history.HistoryFragment;
import com.example.gajdaj.myapplication.ui.main.settings.SettingsFragment;

import dagger.Binds;
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