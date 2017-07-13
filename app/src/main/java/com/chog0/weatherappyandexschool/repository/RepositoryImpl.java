package com.chog0.weatherappyandexschool.repository;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.content.Context;

import com.chog0.weatherappyandexschool.R;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.model.ResponseWeather;
import com.chog0.weatherappyandexschool.web.WeatherApi;

import javax.inject.Inject;

import io.reactivex.Observable;

public class RepositoryImpl implements Repository {

    @Inject
    WeatherApi weatherApi;
    @Inject
    Context context;
    private String apiKey;

    public RepositoryImpl() {
        WeatherApp.getAppComponent().inject(this);
        apiKey = context.getString(R.string.api_key);
    }

    @Override
    public Observable<ResponseWeather> getWeather(String cityId) {
        return weatherApi.getCurrentWeather(cityId, apiKey);
    }

    @Override
    public void storeWeather() {

    }
}
