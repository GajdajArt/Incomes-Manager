package com.example.gajdaj.myapplication.domain;

import java.util.ArrayList;


public interface TransactionRepository {

    void addNewItem(FinanceTransaction transaction);

    FinanceTransaction getItem(int id);

    int getId (FinanceTransaction transaction);

    void removeItem(FinanceTransaction transaction);

    void removeItem(int id);

    ArrayList<FinanceTransaction> getList();

    void editItem(FinanceTransaction transaction, int id);

}
