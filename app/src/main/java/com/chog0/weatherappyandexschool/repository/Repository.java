package com.chog0.weatherappyandexschool.repository;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.support.annotation.NonNull;

import com.chog0.weatherappyandexschool.model.ResponseModel.places_suggest.PlacesSuggest;
import com.chog0.weatherappyandexschool.model.ResponseModel.place_detail.PlaceDetails;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface Repository {

    Observable<String> getWeather(float lat, float lon);

    void storeWeather(@NonNull String response);

    void setWeatherUpdatePeriod(int period);

    int getWeatherUpdatePeriod();

    Flowable<PlacesSuggest> getPlacesSuggestList(String text);

    Single<PlaceDetails> getPlaceDetails(String placeId);
}
