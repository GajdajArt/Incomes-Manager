package com.example.gajdaj.myapplication.presentation.presenters;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.presentation.Presenter;
import com.example.gajdaj.myapplication.ui.history.list.HistoryView;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HistoryPresenter extends Presenter<HistoryView> {

    private TransactionRepository repository;
    private Scheduler mainThread;
    private Scheduler subscribeThread;
    private Disposable observer;


    @Inject
    public HistoryPresenter(TransactionRepository repository, HistoryView view,
                            @Named("observe") Scheduler mainThread,
                            @Named("subscribe") Scheduler subscribeThread) {
        this.repository = repository;
        this.view = view;
        this.mainThread = mainThread;
        this.subscribeThread = subscribeThread;
    }

    public void getData() {

        Observable<ArrayList<FinanceTransaction>> o = Observable.fromCallable(()-> repository.getList())
                .subscribeOn(subscribeThread)
                .observeOn(mainThread);

        observer = o.subscribe(list -> view.showData(list));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        observer.dispose();
    }
}
