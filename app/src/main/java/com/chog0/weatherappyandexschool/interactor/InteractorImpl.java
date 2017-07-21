package com.chog0.weatherappyandexschool.interactor;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.support.annotation.NonNull;
import android.util.Log;

import com.chog0.weatherappyandexschool.Constants;
import com.chog0.weatherappyandexschool.R;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.model.ResponseModel.ResponseWeather;
import com.chog0.weatherappyandexschool.model.app_model.WeatherDTO;
import com.chog0.weatherappyandexschool.presentation.presenter.WeatherPresenter;
import com.chog0.weatherappyandexschool.repository.RepositoryImpl;
import com.chog0.weatherappyandexschool.settings.PreferencesManager;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Response;


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
    public Observable<String> getWeather(@NonNull String cityId) {
        return repository.getWeather(cityId);
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
        callback.onSuccess(builWeather(responseWeather));

    }
    private String timeFormated(long timeStamp) {

        DateFormat sdf = new SimpleDateFormat("dd.MM hh:mm:ss", Locale.getDefault());
        Date netDate = (new Date(timeStamp));
        return sdf.format(netDate);
    }
}
