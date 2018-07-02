package com.example.gajdaj.myapplication.di.modules.finTransaction;

import com.example.gajdaj.myapplication.di.modules.history.edit.EditNewFragmentModule;
import com.example.gajdaj.myapplication.di.scopes.FragmentScope;
import com.example.gajdaj.myapplication.ui.history.edit.EditItemFragment;
import com.example.gajdaj.myapplication.ui.transaction.FinTransactionActivity;
import com.example.gajdaj.myapplication.ui.transaction.FinTransactionFragment;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FinTransactionActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = {FinTransactionFragmentModule.class})
    abstract FinTransactionFragment myFinTransactionFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {EditNewFragmentModule.class})
    abstract EditItemFragment myEditItemFragment();

    @Provides
    @Named("trId")
    public static int provideFinTransactionId(FinTransactionActivity activity) {
        return activity.getID();
    }
}
