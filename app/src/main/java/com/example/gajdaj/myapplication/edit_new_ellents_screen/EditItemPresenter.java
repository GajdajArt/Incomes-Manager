package com.example.gajdaj.myapplication.edit_new_ellents_screen;

public class EditItemPresenter implements EditItemContract.Presenter {

    private EditItemContract.View view;

    public EditItemPresenter(EditItemContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }
}
