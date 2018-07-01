package com.example.gajdaj.myapplication.ui.transaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gajdaj.myapplication.R;
import com.example.gajdaj.myapplication.app.App;
import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.presentation.FinTransactionPresenter;
import com.example.gajdaj.myapplication.ui.BaseFragment;

import javax.inject.Inject;
import javax.inject.Named;

public class FinTransactionFragment extends BaseFragment implements FinTransactionView {

    @Inject
    FinTransactionPresenter presenter;

    private TextView titleTV;
    private TextView sumTV;
    private TextView typeTV;
    private TextView balanceTV;

    @Inject
    @Named("trId")
    int id;


    public static FinTransactionFragment getInstance() {
        return new FinTransactionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        id = 0;
//        if (this.getArguments() != null) {
//            id = this.getArguments().getInt(ID_KEY);
//        }

        return inflater.inflate(R.layout.fragment_transaction, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        initUI();
    }

    private void initUI() {
        titleTV = (TextView) getActivity().findViewById(R.id.title_text_view);
        sumTV = (TextView) getActivity().findViewById(R.id.sum_text_view);
        typeTV = (TextView) getActivity().findViewById(R.id.type_text_view);
        balanceTV = (TextView) getActivity().findViewById(R.id.balance_text_view);

    }

    public void setUI(FinanceTransaction transaction, double balance) {

        balanceTV.setText(String.valueOf(balance));
        titleTV.setText(transaction.getTitle());
        sumTV.setText(String.valueOf(transaction.getSum()));
        switch (transaction.getType()) {
            case INCOME:
                typeTV.setText(R.string.icome);
                break;
            case EXPENSES:
                typeTV.setText(R.string.expenses);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onAttach(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

}
