package com.example.gajdaj.myapplication.presentation.presenters;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.domain.TransactionType;
import com.example.gajdaj.myapplication.presentation.Presenter;
import com.example.gajdaj.myapplication.ui.transaction.FinTransactionView;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;

public class FinTransactionPresenter extends Presenter<FinTransactionView> {

    private TransactionRepository repository;
    private int id;
    private FinanceTransaction transaction;
    private Scheduler mainThread;
    private Scheduler subscribeThread;

    @Inject
    public FinTransactionPresenter(TransactionRepository repository, @Named("trId") int id,
                                   @Named("observe") Scheduler mainThread,
                                   @Named("subscribe") Scheduler subscribeThread) {
        this.repository = repository;
        this.id = id;
        this.mainThread = mainThread;
        this.subscribeThread = subscribeThread;
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
