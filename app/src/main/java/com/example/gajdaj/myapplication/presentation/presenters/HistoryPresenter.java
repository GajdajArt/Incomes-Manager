package com.example.gajdaj.myapplication.presentation.presenters;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.presentation.Presenter;
import com.example.gajdaj.myapplication.ui.history.list.HistoryView;

import java.util.ArrayList;

import javax.inject.Inject;

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
    private Disposable observer;


    @Inject
    public HistoryPresenter(TransactionRepository repository, HistoryView view, Scheduler mainThread) {
        this.repository = repository;
        this.view = view;
        this.mainThread = mainThread;
    }

    public void getData() {

        Observable<ArrayList<FinanceTransaction>> o = Observable.fromCallable(()-> repository.getList())
                .subscribeOn(Schedulers.io())
                .observeOn(mainThread);

        observer = o.subscribe(list -> view.showData(list));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        observer.dispose();
    }
}
