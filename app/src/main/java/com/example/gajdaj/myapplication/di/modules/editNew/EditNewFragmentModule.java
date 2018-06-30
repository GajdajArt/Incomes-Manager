package com.example.gajdaj.myapplication.di.modules.editNew;

import com.example.gajdaj.myapplication.ui.editNew.EditItemFragment;
import com.example.gajdaj.myapplication.ui.editNew.EditItemView;
import com.example.gajdaj.myapplication.ui.main.history.HistoryFragment;
import com.example.gajdaj.myapplication.ui.main.history.HistoryView;

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
