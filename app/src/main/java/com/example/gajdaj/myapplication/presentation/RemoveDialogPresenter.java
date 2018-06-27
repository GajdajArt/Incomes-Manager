package com.example.gajdaj.myapplication.presentation;

import com.example.gajdaj.myapplication.domain.Repository;
import com.example.gajdaj.myapplication.ui.transaction.RemoveDialog;

public class RemoveDialogPresenter extends Presenter<RemoveDialog> {

    Repository repository;

    public RemoveDialogPresenter(Repository repository) {
        this.repository = repository;
    }

    public void removeItem(int id) {
        repository.removeItem(id);
    }
}
