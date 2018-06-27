package com.example.gajdaj.myapplication.ui.transaction;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.gajdaj.myapplication.domain.Repository;
import com.example.gajdaj.myapplication.domain.RepositoryImpl;
import com.example.gajdaj.myapplication.presentation.PresenterView;
import com.example.gajdaj.myapplication.presentation.RemoveDialogPresenter;
import com.example.gajdaj.myapplication.ui.BaseActivity;

public class RemoveDialog implements PresenterView{

    private RemoveDialogPresenter presenter;
    private int id;
    private BaseActivity context;

    protected RemoveDialog(BaseActivity context, int id) {
        this.context = context;
        this.id = id;
        Repository repository = RepositoryImpl.getInstance();
        presenter = new RemoveDialogPresenter(repository);
    }

    public void show(){
        buildDialog();
    }

    private void buildDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Удалить?");
        builder.setPositiveButton("ДА", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.removeItem(id);
                dialog.cancel();
            }
        });
        builder.setNegativeButton("НЕТ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
