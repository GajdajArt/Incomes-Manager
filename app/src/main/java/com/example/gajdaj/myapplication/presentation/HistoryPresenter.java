package com.example.gajdaj.myapplication.presentation;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.ui.main.history.HistoryView;

import java.util.ArrayList;

public class HistoryPresenter extends Presenter<HistoryView>{

    private TransactionRepository repository;
    private ArrayList<FinanceTransaction> transactions;

    public HistoryPresenter(TransactionRepository repository) {
        this.repository = repository;
    }


    public void getData() {
        view.showData(repository.getList());
    }
}
