package com.example.gajdaj.myapplication.edit_new_ellents_screen;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.gajdaj.myapplication.R;
import com.example.gajdaj.myapplication.history_screen.HistoryFragment;

public class EditItemActivity extends AppCompatActivity {

    private EditItemFragment fragment;
    private EditItemPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.add);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        addFragment();
        presenter = new EditItemPresenter(fragment);
    }

    private void addFragment() {
        fragment = new EditItemFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.edit_container, fragment)
                .commit();
    }

}
