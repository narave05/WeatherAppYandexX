package com.chog0.weatherappyandexschool.interactor;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import com.chog0.weatherappyandexschool.model.ResponseModel.Weather;
import com.chog0.weatherappyandexschool.model.app_model.WeatherDTO;

public interface Callback {
    void onSuccess(WeatherDTO weatherDTO);
    void onError(String message);
}
