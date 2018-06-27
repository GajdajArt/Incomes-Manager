package com.example.gajdaj.myapplication.domain;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class RepositoryImpl implements Repository {

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

        AsyncTask<Integer, Void, FinanceTransaction> a = new AsyncTask<Integer, Void, FinanceTransaction>() {
            @Override
            protected FinanceTransaction doInBackground(Integer... integers) {
                FinanceTransaction result = null;
                for (int i = 0; i < list.size(); i++) {
                    FinanceTransaction transaction = list.get(i);
                    if (transaction.getId() == integers[0]) {
                        result = transaction;
                    }
                }
                return result;
            }
        };

        a.execute(id);
        FinanceTransaction transaction = null;
        try {
            transaction = a.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    @Override
    public double getBalance() {

        AsyncTask<Void, Void, Double> a = new AsyncTask<Void, Void, Double>() {
            @Override
            protected Double doInBackground(Void... voids) {

                double result  = 0;
                for (FinanceTransaction tr: list) {
                    if(tr.getType() == TransactionType.INCOME) {
                        result += tr.getSum();
                    } else {
                        result -= tr.getSum();
                    }
                }
                return result;
            }
        };

        a.execute();
        double result = 0;
        try {
             result = a.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getId(FinanceTransaction transaction) {

        AsyncTask<FinanceTransaction, Void, Integer> a = new AsyncTask<FinanceTransaction, Void, Integer>() {
            @Override
            protected Integer doInBackground(FinanceTransaction... transaction) {
                int id = -1;
                for (int i = 0; i < list.size(); i++) {
                    FinanceTransaction item = list.get(i);
                    if (item.getTitle().equals(transaction[0].getTitle())
                            && item.getSum() == item.getSum()) {
                        id = item.getId();
                    }
                }
                return id;
            }
        };

        a.execute(transaction);
        int result = -1;
        try {
            result = a.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void editItem(FinanceTransaction transaction, final int id) {

        AsyncTask<FinanceTransaction, Void, Void> a = new AsyncTask<FinanceTransaction, Void, Void>() {
            @Override
            protected Void doInBackground(FinanceTransaction... transactions) {
                replace(transactions[0], id);
                return null;
            }
        };
        a.execute(transaction);
    }

    private synchronized void replace(FinanceTransaction transaction, int id) {
        list.remove(getItem(id));
        add(transaction);
    }

    @Override
    public void addNewItem(FinanceTransaction transaction) {

        AsyncTask<FinanceTransaction, Void, Void> a = new AsyncTask<FinanceTransaction, Void, Void>() {
            @Override
            protected Void doInBackground(FinanceTransaction... transactions) {
                add(transactions[0]);
                return null;
            }
        };
        a.execute(transaction);
    }

    private synchronized void add(FinanceTransaction transaction) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        transaction.setId(++CURRENT_ID);
        list.add(transaction);
    }

    @Override
    public void removeItem(int id) {
        AsyncTask<Integer, Void, Void> a = new AsyncTask<Integer, Void, Void>() {

            @Override
            protected Void doInBackground(Integer... integers) {
                remove(integers[0]);
                return null;
            }
        };
        a.execute(id);
    }

    private synchronized void remove(int id) {
        list.remove(getItem(id));
    }

    @Override
    public void removeItem(FinanceTransaction transaction) {
        AsyncTask<FinanceTransaction, Void, Void> a = new AsyncTask<FinanceTransaction, Void, Void>() {
            @Override
            protected Void doInBackground(FinanceTransaction... transactions) {
                FinanceTransaction t = transactions[0];
                remove(t);
                return null;
            }
        };
        a.execute(transaction);
    }

    private synchronized void remove(FinanceTransaction transaction) {
        list.remove(transaction);
    }

    @Override
    public synchronized ArrayList<FinanceTransaction> getList() {
        return list;
    }
}
