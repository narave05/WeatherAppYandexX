package com.chog0.weatherappyandexschool.repository;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import com.chog0.weatherappyandexschool.model.ResponseModel.ResponseWeather;

import io.reactivex.Observable;

public interface Repository {

    Observable<ResponseWeather> getWeather(String cityId);
    void storeWeather();
}
