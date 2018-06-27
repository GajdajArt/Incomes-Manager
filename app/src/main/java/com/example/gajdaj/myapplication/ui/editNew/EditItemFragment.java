package com.example.gajdaj.myapplication.ui.editNew;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gajdaj.myapplication.R;
import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.RepositoryImpl;
import com.example.gajdaj.myapplication.domain.TransactionType;
import com.example.gajdaj.myapplication.presentation.EditItemPresenter;
import com.example.gajdaj.myapplication.presentation.PresenterView;
import com.example.gajdaj.myapplication.ui.BaseFragment;

import java.util.ArrayList;


public class EditItemFragment extends BaseFragment implements EditItemView {

    private EditItemPresenter presenter;
    private EditText title;
    private TextView sum;
    private Spinner type;

    private int id;

    public static EditItemFragment getInstance() {
        return new EditItemFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RepositoryImpl repository = RepositoryImpl.getInstance();
        presenter = new EditItemPresenter(repository);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fin_fragment_edit_item, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        initUI();
    }

    void initUI() {

        TextInputLayout titleTIL = (TextInputLayout) getActivity().findViewById(R.id.title_edit_text);
        title = titleTIL.getEditText();

        TextInputLayout sumTIL = (TextInputLayout) getActivity().findViewById(R.id.sum_edit_text);
        sum = sumTIL.getEditText();

        type = (Spinner) getActivity().findViewById(R.id.type_spinner);

        ArrayList<String> list = new ArrayList<>();
        list.add(TransactionType.INCOME.toString());
        list.add(TransactionType.EXPENSES.toString());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(arrayAdapter);

        setUI();

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (isValid()) {

                        FinanceTransaction transaction = new FinanceTransaction();
                        transaction.setTitle(title.getText().toString());
                        transaction.setSum(Double.parseDouble(sum.getText().toString()));
                        transaction.setType(TransactionType.INCOME);

                        if (EditItemFragment.this.getArguments() != null) {
                            presenter.editItem(transaction, id);
                        } else {
                            presenter.addNewItem(transaction);
                        }
                        getActivity().onBackPressed();
                    }
            }
        });
    }

    private void setUI(){
        if (this.getArguments() != null) {
            id = this.getArguments().getInt(PresenterView.ID_KEY);
        }
    }

    public void showData(FinanceTransaction transaction) {
        title.setText(transaction.getTitle());
        sum.setText(Double.toString(transaction.getSum()));
        switch (transaction.getType()) {
            case INCOME:
                type.setSelection(0);
                break;
            case EXPENSES:
                type.setSelection(1);
                break;
        }
    }

    private boolean isValid() {

        boolean result = false;

        String titleValidMessage = presenter.validateTitle(title.getText().toString());
        String sumValidMessage = presenter.validateSum(sum.getText().toString());

        if (titleValidMessage == null) {
            if (sumValidMessage == null) {
                result = true;
            } else {
                sum.setError(sumValidMessage);
            }
        } else {
            title.setError(titleValidMessage);
        }

        return result;
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
