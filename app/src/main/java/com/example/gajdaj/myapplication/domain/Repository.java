package com.example.gajdaj.myapplication.domain;

import java.util.ArrayList;

public interface Repository {

    void addNewItem(FinanceTransaction transaction);
    void removeItem(FinanceTransaction transaction);
    ArrayList<FinanceTransaction> getList();
}
