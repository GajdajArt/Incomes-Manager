package com.example.gajdaj.myapplication.presentation;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.Repository;
import com.example.gajdaj.myapplication.ui.main.history.HistoryView;

import java.util.ArrayList;

public class HistoryPresenter extends Presenter<HistoryView>{

    private Repository repository;
    private ArrayList<FinanceTransaction> transactions;

    public HistoryPresenter(Repository repository) {
        this.repository = repository;
    }


    public void getData() {
        view.showData(repository.getList());
    }
}
