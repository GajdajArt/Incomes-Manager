package com.example.gajdaj.myapplication.ui.transaction;

import android.os.Bundle;

import com.example.gajdaj.myapplication.ui.BaseActivity;
import com.example.gajdaj.myapplication.ui.ViewRouter;
import com.example.gajdaj.myapplication.ui.editNew.EditItemFragment;

import javax.inject.Inject;

public class FinTransactionRouter extends ViewRouter<FinTransactionActivity> {

    @Inject
    public FinTransactionRouter(FinTransactionActivity context) {
        super(context);
    }

    public void showEditItemFragment(int container, Bundle bundle) {
        EditItemFragment editItemFragment = EditItemFragment.getInstance();
        editItemFragment.setArguments(bundle);
        replaceFragment(editItemFragment, container);
    }

    public void showTransactionFragment(int container, Bundle bundle) {
        FinTransactionFragment finTransactionFragment = FinTransactionFragment.getInstance();
        finTransactionFragment.setArguments(bundle);
        replaceFragment(finTransactionFragment, container);
    }
}
