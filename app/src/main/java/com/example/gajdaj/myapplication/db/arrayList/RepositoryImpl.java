package com.example.gajdaj.myapplication.db.arrayList;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.domain.TransactionType;

import java.util.ArrayList;

public class RepositoryImpl implements TransactionRepository {

    private ArrayList<FinanceTransaction> list;
    private static RepositoryImpl instance;
    private int CURRENT_ID = 0;

    private RepositoryImpl() {
        this.list = new ArrayList<>();
    }

    public static RepositoryImpl getInstance() {
        if (instance == null) {
            instance = new RepositoryImpl();
        }
        return instance;
    }

    @Override
    public FinanceTransaction getItem(int id) {

        FinanceTransaction result = null;
        for (int i = 0; i < list.size(); i++) {
            FinanceTransaction transaction = list.get(i);
            if (transaction.getId() == id) {
                result = transaction;
            }
        }
        return result;

    }

    @Override
    public double getBalance() {

        double result = 0;
        for (FinanceTransaction tr : list) {
            if (tr.getType() == TransactionType.INCOME) {
                result += tr.getSum();
            } else {
                result -= tr.getSum();
            }
        }
        return result;
    }

    @Override
    public int getId(FinanceTransaction transaction) {

        int id = -1;
        for (int i = 0; i < list.size(); i++) {
            FinanceTransaction item = list.get(i);
            if (item.getTitle().equals(transaction.getTitle())
                    && item.getSum() == item.getSum()) {
                id = item.getId();
            }
        }
        return id;

    }

    @Override
    public void editItem(FinanceTransaction transaction, final int id) {
        replace(transaction, id);
    }

    private void replace(FinanceTransaction transaction, int id) {
        list.remove(getItem(id));
        add(transaction);
    }

    @Override
    public void addNewItem(FinanceTransaction transaction) {
        add(transaction);
    }

    private void add(FinanceTransaction transaction) {
        transaction.setId(++CURRENT_ID);
        list.add(transaction);
    }

    @Override
    public void removeItem(int id) {
        remove(id);
    }

    private void remove(int id) {
        list.remove(getItem(id));
    }

    @Override
    public void removeItem(FinanceTransaction transaction) {
        FinanceTransaction t = transaction;
        remove(t);
    }

    private void remove(FinanceTransaction transaction) {
        list.remove(transaction);
    }

    @Override
    public ArrayList<FinanceTransaction> getList() {
        return list;
    }
}
