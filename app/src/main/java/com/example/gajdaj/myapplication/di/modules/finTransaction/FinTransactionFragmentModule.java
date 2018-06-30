package com.example.gajdaj.myapplication.di.modules.finTransaction;

import com.example.gajdaj.myapplication.domain.TransactionRepository;
import com.example.gajdaj.myapplication.presentation.RemoveDialogPresenter;
import com.example.gajdaj.myapplication.ui.editNew.EditItemFragment;
import com.example.gajdaj.myapplication.ui.editNew.EditItemView;
import com.example.gajdaj.myapplication.ui.transaction.FinTransactionFragment;
import com.example.gajdaj.myapplication.ui.transaction.FinTransactionView;
import com.example.gajdaj.myapplication.ui.transaction.RemoveDialog_MembersInjector;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by pc on 30.06.2018.
 */
@Module
public abstract class FinTransactionFragmentModule {

    @Binds
    public abstract FinTransactionView myView(FinTransactionFragment finTransactionFragment);

    @Provides
    @Named("trId")
    public static int provideFinTransactionId(FinTransactionFragment finTransactionFragment) {
        return finTransactionFragment.getArguments().getInt(FinTransactionView.ID_KEY);
    }

    @Provides
    public static RemoveDialogPresenter provideRemovePresenter(TransactionRepository repository) {
        return new RemoveDialogPresenter(repository);
    }

}
