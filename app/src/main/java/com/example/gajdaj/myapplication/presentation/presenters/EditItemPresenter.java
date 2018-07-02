package com.example.gajdaj.myapplication.presentation.presenters;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.presentation.Presenter;
import com.example.gajdaj.myapplication.ui.history.edit.EditItemView;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class EditItemPresenter extends Presenter<EditItemView> {

    private static final String ENTER_TITLE = "Введите название";
    private static final String ENTER_SUM = "Введите cумму";
    private static final String SUN_IS_NOT_CORRECT = "Сумма введена не верно";


    private TransactionRepository repository;
    private Scheduler mainThread;
    private Disposable observer;

    @Inject
    public EditItemPresenter(TransactionRepository repository, Scheduler mainThread) {
        this.repository = repository;
        this.mainThread = mainThread;
    }

    public String validateTitle(String title) {

        String message = null;
        if (title.isEmpty()) {
            message = ENTER_TITLE;
        }
        return message;
    }

    public String validateSum(String sum) {

        String message = null;
        if (sum.isEmpty()) {
            message = ENTER_SUM;
        } else {

            try {
                Double.parseDouble(sum);
            } catch (NumberFormatException e) {
                message = SUN_IS_NOT_CORRECT;
            }
        }

        return message;
    }

    public void setUiByID(int id) {

        Observable<FinanceTransaction> o = Observable.fromCallable(() -> repository.getItem(id))
                .subscribeOn(Schedulers.io())
                .observeOn(mainThread);
        observer = o.subscribe(transaction -> view.showData(transaction));
    }

    public void editItem(FinanceTransaction transaction, int id) {

        Completable o = Completable.fromAction(() -> repository.editItem(transaction, id))
                .subscribeOn(Schedulers.io());
        observer = o.subscribe();
    }


    public void addNewItem(FinanceTransaction transaction) {

        Completable o = Completable.fromAction(() -> repository.addNewItem(transaction))
                .subscribeOn(Schedulers.io());
        observer = o.subscribe();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        observer.dispose();
    }
}
