package com.example.gajdaj.myapplication.di.modules.history.list;

import com.example.gajdaj.myapplication.ui.history.list.HistoryFragment;
import com.example.gajdaj.myapplication.ui.history.list.HistoryView;

import dagger.Binds;
import dagger.Module;


@Module
public abstract class HistoryModule {

    @Binds
    public abstract HistoryView myView(HistoryFragment historyFragment);

}
