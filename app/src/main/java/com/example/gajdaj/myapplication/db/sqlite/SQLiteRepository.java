package com.example.gajdaj.myapplication.db.sqlite;

import android.content.Context;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.domain.TransactionType;

import java.util.ArrayList;

public class SQLiteRepository implements TransactionRepository {

    private TransactionDAO dao;

    public SQLiteRepository(Context context) {
        dao = new TransactionSQLiteDAO(context);
    }

    @Override
    public void addNewItem(FinanceTransaction transaction) {
        dao.create(transaction);
    }

    @Override
    public FinanceTransaction getItem(int id) {
        return dao.read(id);
    }

    @Override
    public int getId(FinanceTransaction transaction) {

        ArrayList<FinanceTransaction> list = dao.getList();
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
    public void removeItem(FinanceTransaction transaction) {
        dao.delete(getId(transaction));
    }

    @Override
    public void removeItem(int id) {
        dao.delete(id);
    }

    @Override
    public ArrayList<FinanceTransaction> getList() {
        return dao.getList();
    }

    @Override
    public double getBalance() {

        ArrayList<FinanceTransaction> list = dao.getList();
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
    public void editItem(FinanceTransaction transaction, int id) {
        dao.update(transaction, id);
    }
}
