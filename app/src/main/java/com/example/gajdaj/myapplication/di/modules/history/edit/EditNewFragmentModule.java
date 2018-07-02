package com.example.gajdaj.myapplication.di.modules.history.edit;

import com.example.gajdaj.myapplication.ui.history.edit.EditItemFragment;
import com.example.gajdaj.myapplication.ui.history.edit.EditItemView;

import dagger.Binds;
import dagger.Module;

/**
 * Created by pc on 30.06.2018.
 */
@Module
public abstract class EditNewFragmentModule {

    @Binds
    public abstract EditItemView myView(EditItemFragment editItemFragment);
}
