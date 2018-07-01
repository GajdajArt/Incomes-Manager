package com.example.gajdaj.myapplication.ui.transaction;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.gajdaj.myapplication.R;
import com.example.gajdaj.myapplication.presentation.PresenterView;
import com.example.gajdaj.myapplication.ui.BaseActivity;

import javax.inject.Inject;

public class FinTransactionActivity extends BaseActivity{

    @Inject
    RemoveDialog dialog;
    @Inject
    FinTransactionRouter router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        initUi();
        router.showTransactionFragment(R.id.transaction_container);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.delete_edit_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                router.showEditItemFragment(R.id.transaction_container);
                break;
            case R.id.action_remove:
                dialog.show();
                break;
        }

        return true;
    }


    @Override
    protected void initUi() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(getResources().getDrawable(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material));
    }
}
