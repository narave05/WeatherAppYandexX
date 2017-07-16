package com.chog0.weatherappyandexschool.presentation.ui;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import com.arellomobile.mvp.MvpView;
import com.chog0.weatherappyandexschool.model.app_model.WeatherDTO;

public interface WeatherView extends MvpView{
    void showData(WeatherDTO weatherDTO);
    void showError(String e);
}
