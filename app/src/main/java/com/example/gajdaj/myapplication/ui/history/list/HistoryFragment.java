package com.example.gajdaj.myapplication.ui.history.list;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gajdaj.myapplication.R;
import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.presentation.presenters.HistoryPresenter;
import com.example.gajdaj.myapplication.ui.BaseFragment;
import com.example.gajdaj.myapplication.ui.MyAsyncTask;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends BaseFragment implements HistoryView {

    @Inject
    HistoryPresenter presenter;
    @Inject
    HistoryAdapter adapter;

    public static HistoryFragment getInstance() {
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        RecyclerView recyclerView = (RecyclerView) getActivity()
                .findViewById(R.id.history_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(layoutManager);
        adapter = new HistoryAdapter(presenter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onAttach(this);
        MyAsyncTask a = new MyAsyncTask(new MyAsyncTask.ActionCallback() {
            @Override
            public void run() {
                presenter.getData();
            }
        }, new MyAsyncTask.ResultCallback() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
        a.execute();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    @Override
    public void showData(ArrayList<FinanceTransaction> list) {
        adapter.setItemsList(list);
    }
}
