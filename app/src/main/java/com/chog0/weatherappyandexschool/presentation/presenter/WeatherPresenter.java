package com.chog0.weatherappyandexschool.presentation.presenter;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.support.annotation.NonNull;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chog0.weatherappyandexschool.Constants;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.interactor.Callback;
import com.chog0.weatherappyandexschool.interactor.InteractorImpl;
import com.chog0.weatherappyandexschool.model.app_model.CitySuggest;
import com.chog0.weatherappyandexschool.model.app_model.WeatherDTO;
import com.chog0.weatherappyandexschool.presentation.ui.WeatherView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class WeatherPresenter extends MvpPresenter<WeatherView> {

    private static final String TAG_PRESENTER = "MainPresenter";

    @Inject
    InteractorImpl interactor;

    public WeatherPresenter() {
        WeatherApp.getAppComponent().inject(this);
        getViewState().setInfoToViews();
    }

    public void getWeather() {
        interactor.getWeather(Constants.MOSCOW_LATITUDE, Constants.MOSCOW_LONGITUDE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(e -> {
                    showError(e.getMessage());
                    return e.getMessage();
                })
                .subscribe(response -> {
                    Log.d(TAG_PRESENTER, "getWeather: weather come");
                    interactor.saveWeather(response);
                    parseWeatherFromSP();
                });
    }

    public void getCitySuggestList(String text) {
        interactor.getCitySuggestList(text)
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableSingleObserver<List<CitySuggest>>() {
                    @Override
                    public void onSuccess(List<CitySuggest> citySuggests) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void parseWeatherFromSP() {

        interactor.parseWeather(new Callback() {
            @Override
            public void onSuccess(WeatherDTO weatherDTO) {
                showWeather(weatherDTO);
            }

            @Override
            public void onError(String message) {
                showError(message);
            }
        });
    }

    public void showWeather(@NonNull WeatherDTO weatherDTO) {
        getViewState().showData(weatherDTO);

    }

    public void showError(@NonNull String e) {
        getViewState().showError(e);
    }

}
