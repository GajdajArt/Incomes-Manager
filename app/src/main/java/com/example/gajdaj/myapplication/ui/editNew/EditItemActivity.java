package com.example.gajdaj.myapplication.ui.editNew;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;


import com.example.gajdaj.myapplication.R;
import com.example.gajdaj.myapplication.ui.BaseActivity;


public class EditItemActivity extends BaseActivity {

    private EditItemRouter router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        initUi();
        createRouter();
        router.showEditItemFragment(R.id.edit_container);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    protected void createRouter() {
        this.router = new EditItemRouter(this);
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
