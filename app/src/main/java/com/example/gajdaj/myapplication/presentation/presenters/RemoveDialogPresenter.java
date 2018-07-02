package com.example.gajdaj.myapplication.presentation.presenters;

import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.presentation.Presenter;
import com.example.gajdaj.myapplication.ui.transaction.RemoveDialog;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class RemoveDialogPresenter extends Presenter<RemoveDialog> {

    TransactionRepository repository;
    private Scheduler subscribeThread;


    public RemoveDialogPresenter(TransactionRepository repository,
                                 @Named("subscribe") Scheduler subscribeThread) {
        this.repository = repository;
        this.subscribeThread = subscribeThread;

    }

    public void removeItem(int id) {
        Completable.fromAction(() -> repository.removeItem(id))
                .subscribeOn(subscribeThread)
                .subscribe();
    }
}
