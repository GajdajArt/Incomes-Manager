package com.example.gajdaj.myapplication.di.modules;

import android.content.Context;

import com.example.gajdaj.myapplication.app.App;
import com.example.gajdaj.myapplication.db.sqlite.SQLiteRepository;
import com.example.gajdaj.myapplication.di.modules.history.edit.EditNewActivityModule;
import com.example.gajdaj.myapplication.di.modules.finTransaction.FinTransactionActivityModule;
import com.example.gajdaj.myapplication.di.modules.history.MainActivityModule;
import com.example.gajdaj.myapplication.di.scopes.ActivityScope;
import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.ui.history.edit.EditItemActivity;
import com.example.gajdaj.myapplication.ui.history.MainActivity;
import com.example.gajdaj.myapplication.ui.transaction.FinTransactionActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = {AndroidSupportInjectionModule.class})
public abstract class AppModule {

    @Provides
    @Singleton
    public static Context context(App app) {
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    public static TransactionRepository userRepository(Context context) {
        return new SQLiteRepository(context);
    }

//    @Singleton
//    @Binds
//    abstract TransactionRepository repository(SQLiteRepository repository);

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity mainActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = {EditNewActivityModule.class})
    abstract EditItemActivity editNewActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = {FinTransactionActivityModule.class})
    abstract FinTransactionActivity finTransactionActivityInjector();

}