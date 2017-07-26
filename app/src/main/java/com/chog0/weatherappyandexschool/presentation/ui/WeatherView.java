package com.chog0.weatherappyandexschool.presentation.ui;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.chog0.weatherappyandexschool.model.app_model.WeatherDTO;

public interface WeatherView extends MvpView{
    void showData(@NonNull WeatherDTO weatherDTO);
    void showError(@NonNull String e);
    void setInfoToViews();
    @StateStrategyType(OneExecutionStateStrategy.class)
    void openSearchScreen();
}
