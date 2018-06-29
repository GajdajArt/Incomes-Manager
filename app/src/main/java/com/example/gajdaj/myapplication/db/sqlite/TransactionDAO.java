package com.example.gajdaj.myapplication.db.sqlite;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;

import java.util.ArrayList;

public interface TransactionDAO {

    void create(FinanceTransaction transaction);
    FinanceTransaction read(int id);
    ArrayList<FinanceTransaction> getList();
    void update(FinanceTransaction transaction, int id);
    void delete(int id);
}
