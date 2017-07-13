package com.chog0.weatherappyandexschool.interactor;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.di.AppComponent;
import com.chog0.weatherappyandexschool.model.ResponseWeather;
import com.chog0.weatherappyandexschool.repository.RepositoryImpl;

import javax.inject.Inject;

import io.reactivex.Observable;

public class InteractorImpl implements Interactor {

    @Inject
    RepositoryImpl repository;

    public InteractorImpl() {
        WeatherApp.getAppComponent().inject(this);
    }

    @Override
    public Observable<ResponseWeather> getWeather(String cityId) {
        return repository.getWeather(cityId);
    }
}
