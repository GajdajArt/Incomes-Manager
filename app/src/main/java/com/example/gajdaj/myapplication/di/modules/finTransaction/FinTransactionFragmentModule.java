package com.example.gajdaj.myapplication.di.modules.finTransaction;

import com.example.gajdaj.myapplication.ui.transaction.FinTransactionFragment;
import com.example.gajdaj.myapplication.ui.transaction.FinTransactionView;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by pc on 30.06.2018.
 */
@Module
public abstract class FinTransactionFragmentModule {

    @Binds
    public abstract FinTransactionView myView(FinTransactionFragment finTransactionFragment);


}
