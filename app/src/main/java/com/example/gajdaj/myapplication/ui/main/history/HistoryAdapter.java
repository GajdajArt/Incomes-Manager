package com.example.gajdaj.myapplication.ui.main.history;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gajdaj.myapplication.R;
import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.TransactionType;
import com.example.gajdaj.myapplication.presentation.HistoryPresenter;
import com.example.gajdaj.myapplication.ui.main.MainActivity;
import com.example.gajdaj.myapplication.ui.transaction.FinTransactionActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {

    private List<FinanceTransaction> items;
    private HistoryPresenter presenter;

    @Inject
    public HistoryAdapter(HistoryPresenter presenter) {
        this.items = new ArrayList<>();
        this.presenter = presenter;
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
        holder.id = transaction.getId();

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
    }

    public void addNewItem(FinanceTransaction transaction) {
        items.add(0, transaction);
        notifyItemInserted(0);
    }

    public void removeItem(FinanceTransaction transaction) {
        items.remove(transaction);
        notifyDataSetChanged();
    }


    public class HistoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        TextView type;
        TextView sum;
        int id;


        HistoryHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            title = (TextView) view.findViewById(R.id.item_title);
            type = (TextView) view.findViewById(R.id.item_type);
            sum = (TextView) view.findViewById(R.id.item_sum);
        }

        @Override
        public void onClick(View v) {
            MainActivity mainActivity = (MainActivity) v.getContext();
            mainActivity.getRouter().startActivity(FinTransactionActivity.class, id);
        }
    }
}

