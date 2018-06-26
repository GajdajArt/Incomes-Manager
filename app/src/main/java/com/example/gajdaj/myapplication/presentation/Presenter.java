package com.example.gajdaj.myapplication.presentation;

public abstract class Presenter<T extends PresenterView> {

    protected T view;

    public void onAttach(T view) {
        this.view = (T) view;
    }

    public void onDetach() {
        view = null;
    }
}
