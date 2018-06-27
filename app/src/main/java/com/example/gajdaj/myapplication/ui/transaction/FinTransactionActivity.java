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

public class FinTransactionActivity extends BaseActivity{

    private FinTransactionRouter router;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        initUi();
        createRouter();
        Intent intent = getIntent();
        id = intent.getIntExtra(PresenterView.ID_KEY, 0);

        Bundle bundle = new Bundle();
        bundle.putInt(FinTransactionView.ID_KEY, id);
        router.showTransactionFragment(R.id.transaction_container, bundle);
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
                Bundle bundle = new Bundle();
                bundle.putInt(PresenterView.ID_KEY, id);
                router.showEditItemFragment(R.id.transaction_container, bundle);
                break;
            case R.id.action_remove:
                RemoveDialog dialog = new RemoveDialog(this, id);
                dialog.show();
                break;
        }

        return true;
    }


    @Override
    protected void createRouter() {
        this.router = new FinTransactionRouter(this);
    }

    @Override
    protected void initUi() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.add);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(getResources().getDrawable(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material));
    }
}
