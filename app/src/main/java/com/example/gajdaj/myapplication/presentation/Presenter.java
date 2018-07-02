package com.example.gajdaj.myapplication.presentation;

public abstract class Presenter<T extends PresenterView> {

    protected T view;

    public void onAttach(T view) {
        this.view =  view;
    }

    public void onDetach() {
        view = null;
    }
}
