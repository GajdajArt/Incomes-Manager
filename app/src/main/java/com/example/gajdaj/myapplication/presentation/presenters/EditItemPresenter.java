package com.example.gajdaj.myapplication.presentation.presenters;

import android.widget.Toast;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.presentation.Presenter;
import com.example.gajdaj.myapplication.ui.history.edit.EditItemView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class EditItemPresenter extends Presenter<EditItemView> {

    private static final String ENTER_TITLE = "Введите название";

    private TransactionRepository repository;
    private Scheduler observeThread;
    private Scheduler subscribeThread;
    private Disposable observer;

    @Inject
    public EditItemPresenter(TransactionRepository repository, @Named("observe") Scheduler observeThread,
                             @Named("subscribe") Scheduler subscribeThread) {
        this.repository = repository;
        this.observeThread = observeThread;
        this.subscribeThread = subscribeThread;
    }

    public void loadHistoryItem(int id) {

        Observable<FinanceTransaction> o = Observable.fromCallable(() -> repository.getItem(id))
                .subscribeOn(subscribeThread)
                .observeOn(observeThread);
        observer = o.subscribe(transaction -> view.showHistoryItem(transaction));
    }

    public void save(FinanceTransaction transaction, int id) {

        Observable o;
        view.showLoadView();

        o = Observable.just(transaction)
                .map(new ValidateAndSave())
                .flatMap(new Function<Observable<FinanceTransaction>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Observable<FinanceTransaction> financeTransactionObservable) throws Exception {
                        if (id > -1) {
                            repository.editItem(transaction, id);
                        } else {
                            repository.addNewItem(transaction);
                        }
                        return null;
                    }
                }).subscribeOn(subscribeThread);

        observer = o.subscribe(new Consumer() {

            @Override
            public void accept(Object o) throws Exception {
                view.closeView();
            }
        }, new Consumer<Throwable>() {

            @Override
            public void accept(Throwable throwable) throws Exception {
                view.showTitleError(throwable.getMessage());
            }
        });

    }

    private boolean isValid(FinanceTransaction transaction) {

        boolean result = true;

        String titleValidMessage = validateTitle(transaction.getTitle());

        if (titleValidMessage != null) {
            view.showTitleError(titleValidMessage);
            result = false;
        }
        return result;
    }


    private String validateTitle(String title) {

        String message = null;
        if (title.isEmpty()) {
            message = ENTER_TITLE;
        }
        return message;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        observer.dispose();
    }


    private static class ValidateAndSave implements Function<FinanceTransaction, Observable<FinanceTransaction>> {

        @Override
        public Observable<FinanceTransaction> apply(FinanceTransaction transaction) throws Exception {

            Observable result;

            List<String> errors = new ArrayList<>();

            if (!validateTitle(transaction.getTitle()).isEmpty()) {
                errors.add(ENTER_TITLE);
            }

            if (!errors.isEmpty()) {
                result = Observable.error(new Throwable(errors.get(0)));
            } else {
                result = Observable.just(transaction);
            }

            return result;
        }

        private String validateTitle(String title) {
            String message = null;
            if (title.isEmpty()) {
                message = ENTER_TITLE;
            }
            return message;
        }
    }


}
