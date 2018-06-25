package com.example.gajdaj.myapplication.edit_new_ellents_screen;


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
public class EditItemFragment extends Fragment implements EditItemContract.View {

    private EditItemPresenter presenter;


    public EditItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_item, container, false);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (EditItemPresenter) presenter;
    }
}
