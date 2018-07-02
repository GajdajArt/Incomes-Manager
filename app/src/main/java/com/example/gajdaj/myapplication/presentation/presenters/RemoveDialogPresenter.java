package com.example.gajdaj.myapplication.presentation.presenters;

import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.presentation.Presenter;
import com.example.gajdaj.myapplication.ui.transaction.RemoveDialog;

import javax.inject.Inject;

public class RemoveDialogPresenter extends Presenter<RemoveDialog> {

    TransactionRepository repository;

    public RemoveDialogPresenter(TransactionRepository repository) {
        this.repository = repository;
    }

    public void removeItem(int id) {
        repository.removeItem(id);
    }
}
