package com.chog0.weatherappyandexschool.presentation.presenter;

import android.os.Handler;
import android.support.annotation.VisibleForTesting;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chog0.weatherappyandexschool.R;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.interactor.InteractorImpl;
import com.chog0.weatherappyandexschool.model.app_model.CitySuggest;
import com.chog0.weatherappyandexschool.presentation.view.SearchView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import static android.support.annotation.VisibleForTesting.NONE;

@InjectViewState
public class SearchPresenter extends MvpPresenter<SearchView> {

    public static final int DELAY_MILLIS = 200;

    @Inject
    InteractorImpl interactor;

    private CompositeDisposable compositeDisposable;

    public SearchPresenter() {
        WeatherApp.getAppComponent().inject(this);
        compositeDisposable = new CompositeDisposable();
    }

    @VisibleForTesting(otherwise = NONE)
    public SearchPresenter(InteractorImpl interactor) {
        this.interactor = interactor;
        compositeDisposable = new CompositeDisposable();
    }

    public void init() {
        getViewState().subscribeTextChanges();
    }

    public void onSearchTextChange(String text) {
        if (text.isEmpty()) {
            hideProgressAndShowSuggestList(new ArrayList<>());
        } else {
            getCitySuggestList(text);
        }
    }

    public void getCitySuggestList(String text) {
        getViewState().showProgress();
        compositeDisposable.add(
                interactor.getCitySuggestList(text)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<List<CitySuggest>>() {
                            @Override
                            public void onSuccess(List<CitySuggest> citySuggests) {
                                hideProgressAndShowSuggestList(citySuggests);
                            }

                            @Override
                            public void onError(Throwable e) {
                                hideProgressAndshowError();
                            }
                        }));
    }

    public void onSuggestSelect(CitySuggest suggest) {
        getViewState().returnActivityResultOk(suggest.getPlaceId());
        finishActivityPostDelayed();
    }

    public void handleOnBackPressed() {
        getViewState().returnActivityResultCancel();
        getViewState().finishSearchActivity();
    }

    private void hideProgressAndshowError() {
        getViewState().hideProgress();
        getViewState().showError(R.string.error_text);
    }

    private void hideProgressAndShowSuggestList(List<CitySuggest> citySuggests) {
        getViewState().hideProgress();
        getViewState().showSuggestList(citySuggests);
    }

    private void finishActivityPostDelayed() {
        new Handler().postDelayed(() -> getViewState().finishSearchActivity(), DELAY_MILLIS);
    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
        super.onDestroy();
    }
}
