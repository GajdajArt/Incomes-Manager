package com.example.gajdaj.myapplication.ui.transaction;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.presentation.PresenterView;

public interface FinTransactionView extends PresenterView {
    void setUI(FinanceTransaction transaction, double balance);
}
