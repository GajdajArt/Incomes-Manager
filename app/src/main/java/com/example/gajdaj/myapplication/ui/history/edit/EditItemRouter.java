package com.example.gajdaj.myapplication.ui.history.edit;

import com.example.gajdaj.myapplication.ui.ViewRouter;

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
