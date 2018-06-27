package com.example.gajdaj.myapplication.domain;

import java.util.ArrayList;


public interface Repository {

    void addNewItem(FinanceTransaction transaction);
    FinanceTransaction getItem(int id);
    int getId (FinanceTransaction transaction);
    void removeItem(FinanceTransaction transaction);
    void removeItem(int id);
    ArrayList<FinanceTransaction> getList();
    double getBalance();
    void editItem(FinanceTransaction transaction, int id);

}
