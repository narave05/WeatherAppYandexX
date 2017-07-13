package com.chog0.weatherappyandexschool.interactor;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import com.chog0.weatherappyandexschool.model.ResponseWeather;

import io.reactivex.Observable;

public interface Interactor {
    Observable<ResponseWeather> getWeather(String cityId);
}
