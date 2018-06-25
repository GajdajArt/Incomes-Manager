package com.example.gajdaj.myapplication.history_screen;

public class HistoryPresenter implements HistoryContract.Presenter{

    private HistoryContract.View view;

    public HistoryPresenter(HistoryContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }
}
