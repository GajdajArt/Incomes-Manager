package com.example.gajdaj.myapplication.ui.main.history;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gajdaj.myapplication.R;
import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.TransactionType;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {

    List<FinanceTransaction> items;

    public HistoryAdapter() {
        this.items = new ArrayList<>();
    }

    @Override
    public HistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        return new HistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryHolder holder, final int position) {
        FinanceTransaction transaction = items.get(position);

        holder.title.setText(transaction.getTitle());
        holder.sum.setText(String.valueOf(transaction.getSum()));

        switch (transaction.getType()) {
            case INCOME:
                holder.type.setText(R.string.icome);
                break;
            case EXPENSES:
                holder.type.setText(R.string.expenses);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItemsList(List<FinanceTransaction> list) {
        items.addAll(list);
        notifyDataSetChanged();
    }

    public void addNewItem(FinanceTransaction transaction) {
        items.add(0, transaction);
        notifyItemInserted(0);
    }

    public void removeItem(FinanceTransaction transaction) {
        items.remove(transaction);
        notifyDataSetChanged();
    }


    public class HistoryHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView type;
        TextView sum;

        HistoryHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.item_title);
            type = (TextView) view.findViewById(R.id.item_type);
            sum = (TextView) view.findViewById(R.id.item_sum);
        }

    }

}

