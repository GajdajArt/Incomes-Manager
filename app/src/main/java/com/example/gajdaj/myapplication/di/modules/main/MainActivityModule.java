package com.example.gajdaj.myapplication.di.modules.main;


import com.example.gajdaj.myapplication.di.modules.main.history.HistoryModule;
import com.example.gajdaj.myapplication.di.scopes.ActivityScope;
import com.example.gajdaj.myapplication.di.scopes.FragmentScope;
import com.example.gajdaj.myapplication.ui.main.MainRouter;
import com.example.gajdaj.myapplication.ui.main.history.HistoryFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {

    @ActivityScope
    @Binds
    MainRouter router(MainRouter mainRouter);

    @FragmentScope
    @ContributesAndroidInjector(modules = {HistoryModule.class})
    HistoryFragment myFragment();
}