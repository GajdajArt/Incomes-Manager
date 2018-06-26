package com.example.gajdaj.myapplication.presentation;

import com.example.gajdaj.myapplication.domain.Repository;
import com.example.gajdaj.myapplication.ui.BaseFragment;
import com.example.gajdaj.myapplication.ui.main.history.HistoryView;

public class HistoryPresenter<V extends HistoryView> extends Presenter{

    private Repository repository;

    public HistoryPresenter(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void onAttach(PresenterView view) {
        this.view = (HistoryView) view;
        ((HistoryView) view).showData(repository.getList());
    }
}
