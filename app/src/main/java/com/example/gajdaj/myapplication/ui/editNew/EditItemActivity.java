package com.example.gajdaj.myapplication.ui.editNew;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.gajdaj.myapplication.R;
import com.example.gajdaj.myapplication.presentation.EditItemPresenter;
import com.example.gajdaj.myapplication.presentation.HistoryPresenter;
import com.example.gajdaj.myapplication.ui.BaseActivity;
import com.example.gajdaj.myapplication.ui.ViewRouter;
import com.example.gajdaj.myapplication.ui.history.HistoryFragment;

public class EditItemActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        initUi();
        createRouter();

        EditItemFragment editItemFragment = router.getEditItemFragment();
        EditItemPresenter<EditItemFragment> editItemPresenter = new EditItemPresenter<>();
        editItemPresenter.onAttach(editItemFragment);
        editItemFragment.setPresenter(editItemPresenter);
        router.addFragment(editItemFragment, ViewRouter.EDITNEW_FRAGMENT_TAG);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    protected void createRouter() {
        this.router = new ViewRouter(this, R.id.edit_container);
    }

    @Override
    protected void initUi() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.add);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_launcher_background));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
