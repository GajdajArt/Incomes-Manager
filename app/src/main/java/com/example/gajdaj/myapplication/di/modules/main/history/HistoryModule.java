package com.example.gajdaj.myapplication.di.modules.main.history;

import com.example.gajdaj.myapplication.ui.main.history.HistoryFragment;
import com.example.gajdaj.myapplication.ui.main.history.HistoryView;

import dagger.Binds;
import dagger.Module;


@Module
public abstract class HistoryModule {

    @Binds
    public abstract HistoryView myView(HistoryFragment historyFragment);

}
