package com.chog0.weatherappyandexschool.interactor;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.support.annotation.NonNull;

import com.chog0.weatherappyandexschool.model.ResponseModel.places_suggest.PlacesSuggest;
import com.chog0.weatherappyandexschool.model.ResponseModel.place_detail.PlaceDetails;
import com.chog0.weatherappyandexschool.model.app_model.CitySuggest;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface Interactor {
    Observable<String> getWeather(float lat, float lon);

    void saveWeather(@NonNull String response);

    void parseWeather(Callback callback);

    Single<List<CitySuggest>> getCitySuggestList(String text);

    Single<PlaceDetails> getPlaceDetails(String placeId);
}
