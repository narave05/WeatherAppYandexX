package com.chog0.weatherappyandexschool.repository;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import com.chog0.weatherappyandexschool.Constants;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.model.ResponseModel.ResponseWeather;
import com.chog0.weatherappyandexschool.web.WeatherApi;

import javax.inject.Inject;

import io.reactivex.Observable;

public class RepositoryImpl implements Repository {

    @Inject
    WeatherApi weatherApi;

    public RepositoryImpl() {
        WeatherApp.getAppComponent().inject(this);
    }

    @Override
    public Observable<ResponseWeather> getWeather(String cityId) {
        return weatherApi.getCurrentWeather(cityId, Constants.API_KEY);
    }

    @Override
    public void storeWeather() {

    }
}
