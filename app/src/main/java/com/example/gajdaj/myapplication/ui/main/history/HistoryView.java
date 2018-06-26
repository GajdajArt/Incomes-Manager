package com.example.gajdaj.myapplication.ui.main.history;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.presentation.PresenterView;

import java.util.ArrayList;

public interface HistoryView extends PresenterView {

    void showData(ArrayList<FinanceTransaction> list);
}
