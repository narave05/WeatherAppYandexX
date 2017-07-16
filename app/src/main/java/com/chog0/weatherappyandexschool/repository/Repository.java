package com.chog0.weatherappyandexschool.repository;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import com.chog0.weatherappyandexschool.model.ResponseModel.ResponseWeather;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;

public interface Repository {

    Observable<String> getWeather(String cityId);
    void storeWeather(String response);

}
