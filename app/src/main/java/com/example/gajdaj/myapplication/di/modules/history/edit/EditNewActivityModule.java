package com.example.gajdaj.myapplication.di.modules.history.edit;

import com.example.gajdaj.myapplication.di.scopes.FragmentScope;
import com.example.gajdaj.myapplication.ui.history.edit.EditItemFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by pc on 30.06.2018.
 */
@Module
public interface EditNewActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = {EditNewFragmentModule.class})
    EditItemFragment myEditItemFragment();

}
