package com.example.gajdaj.myapplication.ui.editNew;

import com.example.gajdaj.myapplication.ui.BaseActivity;
import com.example.gajdaj.myapplication.ui.ViewRouter;
import com.example.gajdaj.myapplication.ui.main.settings.SettingsFragment;

public class EditItemRouter extends ViewRouter {

    public EditItemRouter(BaseActivity context) {
        super(context);
    }

    public void showEditItemFragment(int container) {
        EditItemFragment editItemFragment = EditItemFragment.getInstance();
        replaceFragment(editItemFragment, container);
    }
}
