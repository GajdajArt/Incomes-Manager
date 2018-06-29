package com.example.gajdaj.myapplication.ui.transaction;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.gajdaj.myapplication.app.App;
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
        presenter = new RemoveDialogPresenter(App.getRepository());
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
