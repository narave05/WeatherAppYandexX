package com.chog0.weatherappyandexschool.web;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("weather?")
    Observable<String> getCurrentWeather(@Query("appid") String apiKey, @Query("lat") float lat, @Query("lon") float lon);
}
