package com.example.gajdaj.myapplication.ui.editNew;

import com.example.gajdaj.myapplication.ui.BaseActivity;
import com.example.gajdaj.myapplication.ui.ViewRouter;
import com.example.gajdaj.myapplication.ui.main.settings.SettingsFragment;

import javax.inject.Inject;

public class EditItemRouter extends ViewRouter<EditItemActivity> {

    @Inject
    public EditItemRouter(EditItemActivity context) {
        super(context);
    }

    public void showEditItemFragment(int container) {
        EditItemFragment editItemFragment = EditItemFragment.getInstance();
        replaceFragment(editItemFragment, container);
    }
}
