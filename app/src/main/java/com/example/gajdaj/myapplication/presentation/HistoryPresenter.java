package com.example.gajdaj.myapplication.presentation;

import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.ui.main.history.HistoryView;

import javax.inject.Inject;

public class HistoryPresenter extends Presenter<HistoryView>{

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
