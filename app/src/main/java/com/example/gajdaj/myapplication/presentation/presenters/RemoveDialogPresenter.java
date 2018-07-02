package com.example.gajdaj.myapplication.presentation.presenters;

import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.presentation.Presenter;
import com.example.gajdaj.myapplication.ui.transaction.RemoveDialog;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class RemoveDialogPresenter extends Presenter<RemoveDialog> {

    TransactionRepository repository;
    Scheduler mainThread;

    public RemoveDialogPresenter(TransactionRepository repository,Scheduler mainThread) {
        this.repository = repository;
        this.mainThread = mainThread;
    }

    public void removeItem(int id) {
        Completable.fromAction(() -> repository.removeItem(id))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }
}
