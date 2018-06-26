package com.example.gajdaj.myapplication.ui.history;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.gajdaj.myapplication.R;
import com.example.gajdaj.myapplication.presentation.HistoryPresenter;
import com.example.gajdaj.myapplication.presentation.SettingsPresenter;
import com.example.gajdaj.myapplication.ui.BaseActivity;
import com.example.gajdaj.myapplication.ui.ViewRouter;
import com.example.gajdaj.myapplication.ui.editNew.EditItemActivity;
import com.example.gajdaj.myapplication.ui.settings.SettingsFragment;


public class MainActivity extends BaseActivity {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
        createRouter();
        router.addFragment(createHistoryFragment(), ViewRouter.HISTORY_FRAGMENT_TAG);

    }

    private HistoryFragment createHistoryFragment() {

        HistoryFragment historyFragment = router.getHistoryFragment();
        HistoryPresenter<HistoryFragment> historyPresenter = new HistoryPresenter<>();
        historyPresenter.onAttach(historyFragment);
        historyFragment.setPresenter(historyPresenter);
        return historyFragment;
    }

    private SettingsFragment createSettingFragment() {

        SettingsFragment settingsFragment = router.getSettingsFragment();
        SettingsPresenter<SettingsFragment> settingsPresenter = new SettingsPresenter<>();
        settingsPresenter.onAttach(settingsFragment);
        settingsFragment.setPresenter(settingsPresenter);
        return settingsFragment;
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.history_menu_item:
                                router.replaceFragment(createHistoryFragment(), ViewRouter.HISTORY_FRAGMENT_TAG);
                                break;
                            case R.id.settings_menu_Item:
                                router.replaceFragment(createSettingFragment(), ViewRouter.SETTINGS_FRAGMENT_TAG);
                                break;
                            default:
                                break;
                        }
                        // Close the navigation drawer when an item is selected.
                        menuItem.setChecked(true);
                        drawer.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    protected void createRouter() {
        this.router = new ViewRouter(this, R.id.history_container);
    }

    @Override
    protected void initUi() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                router.runNextActivity(EditItemActivity.class);
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        setupDrawerContent(navigationView);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
