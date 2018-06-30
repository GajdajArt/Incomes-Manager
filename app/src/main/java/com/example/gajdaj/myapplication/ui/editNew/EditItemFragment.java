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
import com.example.gajdaj.myapplication.app.App;
import com.example.gajdaj.myapplication.domain.FinanceTransaction;
import com.example.gajdaj.myapplication.domain.TransactionType;
import com.example.gajdaj.myapplication.presentation.EditItemPresenter;
import com.example.gajdaj.myapplication.presentation.PresenterView;
import com.example.gajdaj.myapplication.ui.BaseFragment;
import com.example.gajdaj.myapplication.ui.MyAsyncTask;

import java.util.ArrayList;

import javax.inject.Inject;


public class EditItemFragment extends BaseFragment implements EditItemView {

    @Inject
    EditItemPresenter presenter;
    private EditText title;
    private TextView sum;
    private Spinner type;

    private int id = -1;

    public static EditItemFragment getInstance() {
        return new EditItemFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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


        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isValid()) {

                    final FinanceTransaction transaction = new FinanceTransaction();
                    transaction.setTitle(title.getText().toString());
                    transaction.setSum(Double.parseDouble(sum.getText().toString()));

                    if (type.getSelectedItem().equals(TransactionType.INCOME.toString())) {
                        transaction.setType(TransactionType.INCOME);
                    } else {
                        transaction.setType(TransactionType.EXPENSES);
                    }

                    MyAsyncTask a = new MyAsyncTask(new MyAsyncTask.ActionCallback() {
                        @Override
                        public void run() {
                            if (id != -1) {
                                presenter.editItem(transaction, id);
                            } else {
                                presenter.addNewItem(transaction);
                            }
                        }
                    }, null);
                    a.execute(transaction);
                    getActivity().onBackPressed();
                }
            }
        });
    }

    private void setUI() {
        if (this.getArguments() != null) {
            id = this.getArguments().getInt(PresenterView.ID_KEY);
            presenter.setUiByID(id);
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
        setUI();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }
}
