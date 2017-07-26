package com.chog0.weatherappyandexschool.presentation.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.chog0.weatherappyandexschool.R;
import com.chog0.weatherappyandexschool.model.app_model.CitySuggest;
import com.chog0.weatherappyandexschool.presentation.presenter.SearchPresenter;
import com.chog0.weatherappyandexschool.presentation.ui.adapter.SuggestListAdapter;
import com.chog0.weatherappyandexschool.presentation.ui.widget.LoadingView;
import com.chog0.weatherappyandexschool.presentation.view.SearchView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchActivity extends BaseActivity
        implements SuggestListAdapter.OnItemClickListener, SearchView {

    public static final String PLACE_ID_INTENT_KEY = "PLACE_ID";
    public static final int TIMEOUT_MILLIS = 500;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SearchActivity.class);
    }

    @InjectPresenter
    SearchPresenter presenter;

    @BindView(R.id.search_view)
    EditText searchView;

    @BindView(R.id.back_bt)
    ImageView back;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.loading_view)
    LoadingView mLoadingView;

    private SuggestListAdapter adapter;
    private Disposable editTextDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        presenter.init();
    }

    @Override
    protected void onDestroy() {
        editTextDisposable.dispose();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        mLoadingView.show();
    }

    @Override
    public void hideProgress() {
        mLoadingView.hide();
    }

    @Override
    public void showError(@StringRes int messageId) {
        Toast.makeText(this, getString(messageId), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void subscribeTextChanges() {
        editTextDisposable = RxTextView.textChanges(searchView)
                .skip(1)
                .debounce(TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> presenter.onSearchTextChange(s),
                        throwable -> {
                        });
    }

    @Override
    public void showSuggestList(List<CitySuggest> citySuggests) {
        setupAdapter(citySuggests);
    }

    @Override
    public void returnActivityResultOk(String placeId) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(PLACE_ID_INTENT_KEY, placeId);
        setResult(Activity.RESULT_OK, returnIntent);
    }

    @Override
    public void returnActivityResultCancel() {
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
    }

    @Override
    public void finishSearchActivity() {
        finish();
    }


    @Override
    public void onItemClickListener(CitySuggest citySuggest) {
        presenter.onSuggestSelect(citySuggest);
    }

    @OnClick(R.id.back_bt)
    public void onBackClick(View view) {
        presenter.handleOnBackPressed();
    }

    private void setupAdapter(List<CitySuggest> citySuggests) {
        if (adapter == null) {
            mRecyclerView.setVisibility(View.VISIBLE);
            adapter = new SuggestListAdapter(citySuggests, this);
            mRecyclerView.setAdapter(adapter);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(layoutManager);
        } else {
            adapter.newList(citySuggests);
        }
    }
}
