package com.example.gajdaj.myapplication.db.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.TransactionType;

import java.util.ArrayList;

public class TransactionDAOImpl implements TransactionDAO {

    private MyDBHelper helper;
    private SQLiteDatabase db;

    public TransactionDAOImpl(Context context) {
        helper = new MyDBHelper(context);
    }

    @Override
    public void create(FinanceTransaction transaction) {

        db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(MyDBHelper.TITLE_COLUMN, transaction.getTitle());
        cv.put(MyDBHelper.SUM_COLUMN, transaction.getSum());
        cv.put(MyDBHelper.TYPE_COLUMN, transaction.getType().toString());

        db.insert(MyDBHelper.TABLE_TITLE, null, cv);
    }

    @Override
    public FinanceTransaction read(int id) {

        FinanceTransaction transaction = new FinanceTransaction();
        db = helper.getReadableDatabase();

        String WHERE = MyDBHelper.ID_COLUMN + "=" + id;
        Cursor c = db.query(MyDBHelper.TABLE_TITLE, null, WHERE, null,
                null, null, null);

        if (c.moveToFirst()) {

            int idColIndex = c.getColumnIndex(MyDBHelper.ID_COLUMN);
            int titleColIndex = c.getColumnIndex(MyDBHelper.TITLE_COLUMN);
            int sumColIndex = c.getColumnIndex(MyDBHelper.SUM_COLUMN);
            int typeColIndex = c.getColumnIndex(MyDBHelper.TYPE_COLUMN);

            do {
                transaction.setId(c.getInt(idColIndex));
                transaction.setTitle(c.getString(titleColIndex));
                transaction.setSum(c.getDouble(sumColIndex));

                if (c.getString(typeColIndex).equals(TransactionType.INCOME.toString())) {
                    transaction.setType(TransactionType.INCOME);
                } else {
                    transaction.setType(TransactionType.EXPENSES);
                }

            } while (c.moveToNext());
        } else
            c.close();

        return transaction;
    }

    @Override
    public ArrayList<FinanceTransaction> getList() {

        ArrayList<FinanceTransaction> result = new ArrayList<>();
        db = helper.getReadableDatabase();
        Cursor c = db.query(MyDBHelper.TABLE_TITLE, null, null, null,
                null, null, null);

        if (c.moveToFirst()) {

            int idColIndex = c.getColumnIndex(MyDBHelper.ID_COLUMN);
            int titleColIndex = c.getColumnIndex(MyDBHelper.TITLE_COLUMN);
            int sumColIndex = c.getColumnIndex(MyDBHelper.SUM_COLUMN);
            int typeColIndex = c.getColumnIndex(MyDBHelper.TYPE_COLUMN);

            do {
                FinanceTransaction transaction = new FinanceTransaction();
                transaction.setId(c.getInt(idColIndex));
                transaction.setTitle(c.getString(titleColIndex));
                transaction.setSum(c.getDouble(sumColIndex));

                if (c.getString(typeColIndex).equals(TransactionType.INCOME.toString())) {
                    transaction.setType(TransactionType.INCOME);
                } else {
                    transaction.setType(TransactionType.EXPENSES);
                }
                result.add(transaction);

            } while (c.moveToNext());
        } else
            c.close();

        return result;
    }

    @Override
    public void update(FinanceTransaction transaction, int id) {

        db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(MyDBHelper.TITLE_COLUMN, transaction.getTitle());
        cv.put(MyDBHelper.SUM_COLUMN, transaction.getSum());
        cv.put(MyDBHelper.TYPE_COLUMN, transaction.getType().toString());

        String WHERE = MyDBHelper.ID_COLUMN + " = ?";
        db.update(MyDBHelper.TABLE_TITLE, cv, WHERE, new String[] { String.valueOf(id) });
    }

    @Override
    public void delete(int id) {
        String WHERE = MyDBHelper.ID_COLUMN + " = " + id;
        db = helper.getWritableDatabase();
        db.delete(MyDBHelper.TABLE_TITLE, WHERE, null);
    }
}
