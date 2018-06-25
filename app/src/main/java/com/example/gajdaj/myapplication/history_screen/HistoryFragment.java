package com.example.gajdaj.myapplication.history_screen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gajdaj.myapplication.R;
import com.example.gajdaj.myapplication.base_elements.BasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment implements HistoryContract.View {

    private HistoryPresenter presenter;


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (HistoryPresenter) presenter;
    }
}
