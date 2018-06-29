package com.example.gajdaj.myapplication.presentation;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.ui.transaction.FinTransactionView;

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
        view.setUI(transaction, repository.getBalance());
    }

    public void removeItem() {
        repository.removeItem(transaction);
    }

}
