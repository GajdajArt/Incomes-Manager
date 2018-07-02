package com.example.gajdaj.myapplication.ui.transaction;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.presentation.PresenterView;
import com.example.gajdaj.myapplication.presentation.presenters.RemoveDialogPresenter;
import com.example.gajdaj.myapplication.ui.BaseActivity;

import javax.inject.Inject;
import javax.inject.Named;

public class RemoveDialog implements PresenterView{

    RemoveDialogPresenter presenter;
    private int id;
    private BaseActivity context;


    @Inject
    public RemoveDialog(FinTransactionActivity context, @Named("trId") int id, TransactionRepository repo) {
        this.context = context;
        this.id = id;
        presenter = new RemoveDialogPresenter(repo);
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
                context.onBackPressed();
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
