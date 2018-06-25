package com.example.gajdaj.myapplication.settings_screen;

public class SettingsPresenter implements SettingsContract.Presenter {

    SettingsContract.View view;

    public SettingsPresenter(SettingsContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }
}
