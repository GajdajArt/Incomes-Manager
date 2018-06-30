package com.example.gajdaj.myapplication.di.modules.finTransaction;

import com.example.gajdaj.myapplication.di.modules.editNew.EditNewFragmentModule;
import com.example.gajdaj.myapplication.di.scopes.FragmentScope;
import com.example.gajdaj.myapplication.ui.editNew.EditItemFragment;
import com.example.gajdaj.myapplication.ui.transaction.FinTransactionFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by pc on 30.06.2018.
 */
@Module
public interface FinTransactionActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = {FinTransactionFragmentModule.class})
    FinTransactionFragment myFinTransactionFragment();
}
