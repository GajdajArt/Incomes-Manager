package com.example.gajdaj.myapplication.di.modules.finTransaction;

import com.example.gajdaj.myapplication.di.modules.editNew.EditNewFragmentModule;
import com.example.gajdaj.myapplication.di.modules.main.settings.SettingsModule;
import com.example.gajdaj.myapplication.di.scopes.FragmentScope;
import com.example.gajdaj.myapplication.presentation.PresenterView;
import com.example.gajdaj.myapplication.ui.editNew.EditItemFragment;
import com.example.gajdaj.myapplication.ui.main.settings.SettingsFragment;
import com.example.gajdaj.myapplication.ui.transaction.FinTransactionActivity;
import com.example.gajdaj.myapplication.ui.transaction.FinTransactionFragment;
import com.example.gajdaj.myapplication.ui.transaction.FinTransactionView;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by pc on 30.06.2018.
 */
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
        return activity.getIntent().getIntExtra(PresenterView.ID_KEY, 0);
    }
}
