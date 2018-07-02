package com.example.gajdaj.myapplication.ui.history.edit;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.presentation.PresenterView;

public interface EditItemView extends PresenterView {
    void showData(FinanceTransaction transaction);
}
