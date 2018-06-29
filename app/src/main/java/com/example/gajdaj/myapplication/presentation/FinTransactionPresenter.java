package com.example.gajdaj.myapplication.presentation;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.domain.TransactionType;
import com.example.gajdaj.myapplication.ui.transaction.FinTransactionView;

import java.util.ArrayList;

public class FinTransactionPresenter extends Presenter<FinTransactionView> {

    private TransactionRepository repository;
    private int id;
    private FinanceTransaction transaction;

    public FinTransactionPresenter(TransactionRepository repository, int id) {
        this.repository = repository;
        this.id = id;
    }

    @Override
    public void onAttach(FinTransactionView view) {
        super.onAttach(view);
        transaction = repository.getItem(id);
        view.setUI(transaction, getBalance());
    }


    private double getBalance() {

        ArrayList<FinanceTransaction> list = repository.getList();
        double result = 0;

        for (FinanceTransaction tr : list) {
            if (tr.getType() == TransactionType.INCOME) {
                result += tr.getSum();
            } else {
                result -= tr.getSum();
            }
        }
        return result;
    }

}
