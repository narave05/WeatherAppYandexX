package com.chog0.weatherappyandexschool.interactor;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import com.chog0.weatherappyandexschool.Constants;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.model.ResponseModel.ResponseWeather;
import com.chog0.weatherappyandexschool.model.app_model.WeatherDTO;
import com.chog0.weatherappyandexschool.repository.RepositoryImpl;
import com.chog0.weatherappyandexschool.settings.PreferencesManager;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Response;


public class InteractorImpl implements Interactor {

    @Inject
    RepositoryImpl repository;
    @Inject
    PreferencesManager preferencesManager;

    private ObjectMapper mapper = new ObjectMapper();

    public InteractorImpl() {
        WeatherApp.getAppComponent().inject(this);
    }

    @Override
    public Observable<String> getWeather(String cityId) {
        return repository.getWeather(cityId);
    }

    @Override
    public void saveWeather(String response) {
        repository.storeWeather(response);
    }

    public WeatherDTO builWeather(ResponseWeather responseWeather) {

        return WeatherDTO.newBuilder()
                .setCity(Constants.MOSCOW_ID)
                .setIcon(responseWeather.getWeather().get(0).getIcon())
                .setTemperature(responseWeather.getMainInfo().getTemp())
                .setMaxTemperature(responseWeather.getMainInfo().getTempMax())
                .setMinTemperature(responseWeather.getMainInfo().getTempMin())
                .setHumidity(responseWeather.getMainInfo().getHumidity())
                .setPressure(responseWeather.getMainInfo().getPressure())
                .setTime(System.currentTimeMillis())
                .setId(responseWeather.getWeather().get(0).getId())
                .build();
    }
    @Override
    public WeatherDTO parseWeather() {

        ResponseWeather responseWeather = null;
        try {
            responseWeather = mapper.readValue(preferencesManager.getResponse(), ResponseWeather.class);
        } catch (IOException e) {
            //TODO handle this shit
            e.printStackTrace();
        }

        return builWeather(responseWeather);

    }
}
