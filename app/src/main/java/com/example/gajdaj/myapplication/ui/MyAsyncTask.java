package com.example.gajdaj.myapplication.ui;

import android.os.AsyncTask;

public class MyAsyncTask extends AsyncTask {

    ActionCallback actionCallback;
    ResultCallback resultCallback;


    public MyAsyncTask(ActionCallback actionCallback, ResultCallback resultCallback) {
        this.actionCallback = actionCallback;
        this.resultCallback = resultCallback;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        actionCallback.run();
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        if (resultCallback != null) {
            resultCallback.run();
        }
    }

    public interface ActionCallback {
        void run();
    }

    public interface ResultCallback{
        void run();
    }
}

