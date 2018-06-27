package com.example.gajdaj.myapplication.presentation;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.Repository;
import com.example.gajdaj.myapplication.ui.editNew.EditItemView;

public class EditItemPresenter extends Presenter<EditItemView> {

    private Repository repository;

    public EditItemPresenter(Repository repository) {
        this.repository = repository;
    }

    public String validateTitle(String title) {

        String message = null;
        if (title.isEmpty()) {
            message = "Введите название";
        }
        return message;
    }

    public String validateSum(String sum) {

        String message = null;
        if (sum.isEmpty()) {
            message = "Введите cумму";
        } else {

            try {
                Double.parseDouble(sum);
            } catch (NumberFormatException e) {
                message = "Сумма введена не верно";
            }
        }

        return message;
    }

    public void setUiByID(int id) {
        FinanceTransaction transaction = repository.getItem(id);
    }

    public void editItem(FinanceTransaction transaction, int id) {
        repository.editItem(transaction, id);
    }


    public void addNewItem(FinanceTransaction transaction) {
        repository.addNewItem(transaction);
    }
}
