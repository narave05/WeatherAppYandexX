package com.chog0.weatherappyandexschool.web;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import com.chog0.weatherappyandexschool.model.ResponseModel.ResponseWeather;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("weather?")
    Observable<ResponseWeather> getCurrentWeather(@Query("id") String cityId, @Query("appid") String apiKey);
}
