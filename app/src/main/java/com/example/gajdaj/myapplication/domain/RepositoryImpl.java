package com.example.gajdaj.myapplication.domain;

import java.util.ArrayList;

public class RepositoryImpl implements Repository {

    private ArrayList<FinanceTransaction> list;

    public RepositoryImpl() {
        this.list = new ArrayList<>();
        FinanceTransaction transaction = new FinanceTransaction();
        transaction.setSum(345.45);
        transaction.setTitle("Зарплата");
        transaction.setType(TransactionType.INCOME);
        list.add(transaction);
    }

    @Override
    public void addNewItem(FinanceTransaction transaction) {
        list.add(transaction);
    }

    @Override
    public void removeItem(FinanceTransaction transaction) {
        list.add(transaction);
    }

    @Override
    public ArrayList<FinanceTransaction> getList() {
        return list;
    }
}
