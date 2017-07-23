package com.chog0.weatherappyandexschool.interactor;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.support.annotation.NonNull;
import android.util.Log;

import com.chog0.weatherappyandexschool.Constants;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.model.ResponseModel.ResponseWeather;
import com.chog0.weatherappyandexschool.model.ResponseModel.place_detail.PlaceDetails;
import com.chog0.weatherappyandexschool.model.ResponseModel.places_suggest.PlacesSuggest;
import com.chog0.weatherappyandexschool.model.ResponseModel.places_suggest.Prediction;
import com.chog0.weatherappyandexschool.model.app_model.CitySuggest;
import com.chog0.weatherappyandexschool.model.app_model.WeatherDTO;
import com.chog0.weatherappyandexschool.repository.RepositoryImpl;
import com.chog0.weatherappyandexschool.settings.PreferencesManager;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class InteractorImpl implements Interactor {

    public static final int K = 273;
    public static final double MMHG = 0.75006375541921;

    @Inject
    RepositoryImpl repository;
    @Inject
    PreferencesManager preferencesManager;

    private ObjectMapper mapper = new ObjectMapper();

    public InteractorImpl() {
        WeatherApp.getAppComponent().inject(this);
    }

    @Override
    public Observable<String> getWeather(float lat, float lon) {
        return repository.getWeather(lat, lon);
    }

    @Override
    public void saveWeather(@NonNull String response) {
        repository.storeWeather(response);
    }

    private WeatherDTO builWeather(@NonNull ResponseWeather responseWeather) {

        return WeatherDTO.newBuilder()
                .setCity(Constants.MOSCOW_ID)
                .setIcon(responseWeather.getWeather().get(0).getIcon())
                .setTemperature(responseWeather.getMainInfo().getTemp() - K)
                .setMaxTemperature(responseWeather.getMainInfo().getTempMax() - K)
                .setMinTemperature(responseWeather.getMainInfo().getTempMin() - K)
                .setHumidity(responseWeather.getMainInfo().getHumidity())
                .setPressure(responseWeather.getMainInfo().getPressure() * MMHG)
                .setTime(timeFormated(System.currentTimeMillis()))
                .setWind(responseWeather.getWind().getSpeed())
                .setId(responseWeather.getWeather().get(0).getId())
                .build();
    }

    @Override
    public void parseWeather(Callback callback) {

        ResponseWeather responseWeather = null;
        try {
            responseWeather = mapper.readValue(preferencesManager.getResponse(), ResponseWeather.class);
        } catch (IOException e) {
            callback.onError(e.getMessage());
        }
        if (responseWeather != null) {
            callback.onSuccess(builWeather(responseWeather));
        } else {
            // TODO: 22.07.2017
            callback.onError("error");
        }

    }

    @Override
    public Single<List<CitySuggest>> getCitySuggestList(String text) {
        return repository.getPlacesSuggestList(text)
                .map(new Function<PlacesSuggest, List<Prediction>>() {
                    @Override
                    public List<Prediction> apply(@io.reactivex.annotations.NonNull PlacesSuggest placesSuggest) throws Exception {
                        return placesSuggest.predictions;
                    }
                })
                .flatMapIterable(new Function<List<Prediction>, List<Prediction>>() {
                    @Override
                    public List<Prediction> apply(@io.reactivex.annotations.NonNull List<Prediction> predictions) throws Exception {
                        return predictions;
                    }
                })
                .map(new Function<Prediction, CitySuggest>() {
                    @Override
                    public CitySuggest apply(@io.reactivex.annotations.NonNull Prediction prediction) throws Exception {
                        return new CitySuggest(prediction.placeId, prediction.description);
                    }
                })
                .toList();
    }

    @Override
    public Single<PlaceDetails> getPlaceDetails(String placeId) {
        return repository.getPlaceDetails(placeId);
    }

    private String timeFormated(long timeStamp) {

        DateFormat sdf = new SimpleDateFormat("dd.MM hh:mm:ss", Locale.getDefault());
        Date netDate = (new Date(timeStamp));
        return sdf.format(netDate);
    }
}
