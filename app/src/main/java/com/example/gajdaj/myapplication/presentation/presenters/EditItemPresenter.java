package com.example.gajdaj.myapplication.presentation.presenters;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.presentation.Presenter;
import com.example.gajdaj.myapplication.ui.history.edit.EditItemView;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;

public class EditItemPresenter extends Presenter<EditItemView> {

    private static final String ENTER_TITLE = "Введите название";
    private static final String ENTER_SUM = "Введите cумму";
    private static final String SUN_IS_NOT_CORRECT = "Сумма введена не верно";

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

        Completable o;
        view.showLoadView();

        if (isValid(transaction)) {

            if (id > -1) {
                o = Completable.fromAction(() -> repository.editItem(transaction, id))
                        .subscribeOn(subscribeThread);
            } else {
                o = Completable.fromAction(() -> repository.addNewItem(transaction))
                        .subscribeOn(subscribeThread);
            }

            observer = o.subscribeWith(new DisposableCompletableObserver() {
                @Override
                public void onComplete() {
                    view.closeView();
                }

                @Override
                public void onError(Throwable e) {
                    view.showSaveError();
                }
            });
        }
    }

    private boolean isValid (FinanceTransaction transaction) {

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
}
