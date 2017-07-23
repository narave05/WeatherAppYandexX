package com.chog0.weatherappyandexschool.repository;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.support.annotation.NonNull;

import com.chog0.weatherappyandexschool.Constants;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.model.ResponseModel.places_suggest.PlacesSuggest;
import com.chog0.weatherappyandexschool.model.ResponseModel.place_detail.PlaceDetails;
import com.chog0.weatherappyandexschool.settings.PreferencesManager;
import com.chog0.weatherappyandexschool.web.PlaceApi;
import com.chog0.weatherappyandexschool.web.WeatherApi;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class RepositoryImpl implements Repository {

    @Inject
    WeatherApi weatherApi;

    @Inject
    PlaceApi placeApi;

    @Inject
    PreferencesManager preferencesManager;

    public RepositoryImpl() {
        WeatherApp.getAppComponent().inject(this);
    }

    @Override
    public Observable<String> getWeather(float lat, float lon) {
        return weatherApi.getCurrentWeather(Constants.API_KEY, lat, lon);
    }

    @Override
    public void storeWeather(@NonNull String response) {
        preferencesManager.saveResponse(response);
    }

    @Override
    public void setWeatherUpdatePeriod(int period) {
        preferencesManager.savePeriodUpdate(period);
    }

    @Override
    public int getWeatherUpdatePeriod() {
        return preferencesManager.getPeriod();
    }

    @Override
    public Flowable<PlacesSuggest> getPlacesSuggestList(String text) {
        return placeApi.getPlacesSuggestList(Constants.GOOGLE_PLACE_API_ID, Constants.PLACE_TYPES, text);
    }

    @Override
    public Single<PlaceDetails> getPlaceDetails(String placeId) {
        return placeApi.getPlaceDetails(Constants.GOOGLE_PLACE_API_ID, placeId);
    }

}
