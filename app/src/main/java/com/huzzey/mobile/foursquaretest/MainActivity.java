package com.huzzey.mobile.foursquaretest;

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
import com.huzzey.mobile.foursquaretest.datatypes.Venue;
import com.huzzey.mobile.foursquaretest.helpers.VolleyHelper;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private MainPresenter presenter;
    private RecyclerView resultList;
    private MainActivityAdapter adapter;
    private ProgressBar spinner;

    @Inject
    VolleyHelper volleyHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppApplication.getContextComponent().inject(this);

        setContentView(R.layout.activity_main);

        EditText searchEditText = (EditText) findViewById(R.id.searchEditText);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onTextChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.afterTextChanged(s);
            }
        });
        resultList = (RecyclerView) findViewById(R.id.resultList);
        resultList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainActivityAdapter(this);
        resultList.setAdapter(adapter);
        spinner = (ProgressBar) findViewById(R.id.spinner);
        presenter = new MainPresenter(this, volleyHelper);
    }



    @Override
    public void hideList() {
        resultList.setVisibility(View.GONE);
    }

    @Override
    public void updateList(List<Venue> list) {
        resultList.setVisibility(View.VISIBLE);
        adapter.updateData(list);
    }

    @Override
    public void showSpinner() {
        spinner.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideSpinner() {
        spinner.setVisibility(View.GONE);
    }
}
