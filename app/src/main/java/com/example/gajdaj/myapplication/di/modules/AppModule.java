package com.example.gajdaj.myapplication.di.modules;

import com.example.gajdaj.myapplication.db.sqlite.SQLiteRepository;
import com.example.gajdaj.myapplication.di.modules.editNew.EditNewActivityModule;
import com.example.gajdaj.myapplication.di.modules.finTransaction.FinTransactionActivityModule;
import com.example.gajdaj.myapplication.di.modules.main.MainActivityModule;
import com.example.gajdaj.myapplication.di.scopes.ActivityScope;
import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.ui.editNew.EditItemActivity;
import com.example.gajdaj.myapplication.ui.main.MainActivity;
import com.example.gajdaj.myapplication.ui.transaction.FinTransactionActivity;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = {AndroidSupportInjectionModule.class})
public interface AppModule {

    @Singleton
    @Binds
    TransactionRepository repository(SQLiteRepository repository);

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    MainActivity mainActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = {EditNewActivityModule.class})
    EditItemActivity editNewActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = {FinTransactionActivityModule.class})
    FinTransactionActivity finTransactionActivityInjector();

}