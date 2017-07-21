package com.chog0.weatherappyandexschool.interactor;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import com.chog0.weatherappyandexschool.model.ResponseModel.ResponseWeather;
import com.chog0.weatherappyandexschool.model.app_model.WeatherDTO;
import com.chog0.weatherappyandexschool.presentation.presenter.WeatherPresenter;

import io.reactivex.Observable;
import retrofit2.Response;

public interface Interactor {
    Observable<String> getWeather(String cityId);

    void saveWeather(String response);

    WeatherDTO parseWeather(WeatherPresenter weatherPresenter);
}
