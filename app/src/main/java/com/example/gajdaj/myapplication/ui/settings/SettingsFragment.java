package com.example.gajdaj.myapplication.ui.settings;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gajdaj.myapplication.R;
import com.example.gajdaj.myapplication.presentation.Presenter;
import com.example.gajdaj.myapplication.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends BaseFragment {

    private Presenter<SettingsFragment> presenter;

    public static SettingsFragment getInstance() {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
