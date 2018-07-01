package com.example.gajdaj.myapplication.ui.transaction;

import android.os.Bundle;

import com.example.gajdaj.myapplication.ui.BaseActivity;
import com.example.gajdaj.myapplication.ui.ViewRouter;
import com.example.gajdaj.myapplication.ui.editNew.EditItemFragment;

import javax.inject.Inject;
import javax.inject.Named;

public class FinTransactionRouter extends ViewRouter<FinTransactionActivity> {

    @Inject
    @Named("trId")
    int id;

    @Inject
    public FinTransactionRouter(FinTransactionActivity context) {
        super(context);
    }

    public void showEditItemFragment(int container) {

        EditItemFragment editItemFragment = EditItemFragment.getInstance();
        Bundle bundle = new Bundle();

        bundle.putInt(FinTransactionView.ID_KEY, id);
        editItemFragment.setArguments(bundle);
        replaceFragment(editItemFragment, container);
    }

    public void showTransactionFragment(int container) {
        FinTransactionFragment finTransactionFragment = FinTransactionFragment.getInstance();
        replaceFragment(finTransactionFragment, container);
    }
}
