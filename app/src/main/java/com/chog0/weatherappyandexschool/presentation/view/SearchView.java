package com.chog0.weatherappyandexschool.presentation.view;


import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.chog0.weatherappyandexschool.model.app_model.CitySuggest;

import java.util.List;

public interface SearchView extends MvpView {
    void showProgress();

    void hideProgress();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showError(@StringRes int messageId);

    void showSuggestList(List<CitySuggest> citySuggests);

    void subscribeTextChanges();

    void returnActivityResultOk(String placeId);

    void returnActivityResultCancel();

    void finishSearchActivity();


}
