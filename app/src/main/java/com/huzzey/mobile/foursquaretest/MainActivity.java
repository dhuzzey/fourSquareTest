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
import com.huzzey.mobile.foursquaretest.datatypes.Items;
import com.huzzey.mobile.foursquaretest.model.GetData;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private MainPresenter presenter;
    private RecyclerView resultList;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
                presenter.afterTextChanged(s.toString());
            }
        });
        resultList = (RecyclerView) findViewById(R.id.resultList);
        resultList.setLayoutManager(new LinearLayoutManager(this));
        resultList.setAdapter(new MainActivityAdapter(MainActivity.this));
        spinner = (ProgressBar) findViewById(R.id.spinner);
        presenter = new MainPresenter(this, new GetData());
    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void hideList() {
        resultList.setVisibility(View.GONE);
    }

    @Override
    public void updateList(List<Items> list) {
        resultList.setVisibility(View.VISIBLE);
        ((MainActivityAdapter)resultList.getAdapter()).updateData(list);
    }

    @Override
    public void showSpinner() {
        spinner.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideSpinner() {
        spinner.setVisibility(View.GONE);
    }

    @Override
    public void updateActionbar(String title) {
        setTitle(title);
    }

    @Override
    public void updateActionbar(int title) {
        updateActionbar(getString(title));
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
