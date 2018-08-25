package com.huzzey.mobile.foursquaretest;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.huzzey.mobile.foursquaretest.adapters.MainActivityAdapter;
import com.huzzey.mobile.foursquaretest.datatypes.Items;
import com.huzzey.mobile.foursquaretest.model.FourSquareResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.searchEditText) EditText searchEditText;
    @BindView(R.id.resultList) RecyclerView resultList;
    @BindView(R.id.spinner) ProgressBar spinner;

    private MainViewModel presenter;
    public ViewModelProvider viewModelProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = getProvider().get(MainViewModel.class);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s != null && s.length() >= 3) {
                    hideList();
                    spinner.setVisibility(View.VISIBLE);
                    presenter.afterTextChanged(s.toString())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new SingleObserver<FourSquareResponse>() {
                                @Override
                                public void onSubscribe(Disposable d) {

                                }

                                @Override
                                public void onSuccess(FourSquareResponse fourSquareResponse) {
                                    hideSpinner();
                                    updateList(fourSquareResponse.getList());
                                    updateActionbar(fourSquareResponse.getResponse().getLocation());
                                }

                                @Override
                                public void onError(Throwable e) {
                                    hideSpinner();
                                    updateActionbar(R.string.actionBarDefault);
                                }
                            });
                } else {
                    hideList();
                    hideSpinner();
                    updateActionbar(R.string.actionBarDefault);
                }
            }
        });
        resultList.setLayoutManager(new LinearLayoutManager(this));
        resultList.setAdapter(new MainActivityAdapter(MainActivity.this));
    }


    @Override
    protected void onResume() {
        super.onResume();
        hideSpinner();
        updateActionbar(R.string.actionBarDefault);
    }


    public void hideList() {
        resultList.setVisibility(View.GONE);
    }


    public void updateList(List<Items> list) {
        resultList.setVisibility(View.VISIBLE);
        ((MainActivityAdapter)resultList.getAdapter()).updateData(list);
    }



    public void hideSpinner() {
        spinner.setVisibility(View.GONE);
    }


    public void updateActionbar(String title) {
        setTitle(title);
    }


    public void updateActionbar(int title) {
        updateActionbar(getString(title));
    }

    public ViewModelProvider getProvider() {
        if (viewModelProvider == null) {
            viewModelProvider = ViewModelProviders.of(this);
        }
        return viewModelProvider;
    }
}
