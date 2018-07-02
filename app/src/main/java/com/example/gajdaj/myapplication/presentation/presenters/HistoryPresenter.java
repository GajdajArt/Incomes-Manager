package com.example.gajdaj.myapplication.presentation.presenters;

import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.presentation.Presenter;
import com.example.gajdaj.myapplication.ui.history.list.HistoryView;

import javax.inject.Inject;

public class HistoryPresenter extends Presenter<HistoryView> {

    private TransactionRepository repository;

    @Inject
    public HistoryPresenter(TransactionRepository repository, HistoryView view) {
        this.repository = repository;
        this.view = view;
    }


    public void getData() {
        view.showData(repository.getList());
    }
}
