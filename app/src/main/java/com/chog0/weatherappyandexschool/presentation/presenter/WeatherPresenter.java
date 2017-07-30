package com.chog0.weatherappyandexschool.presentation.presenter;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.Pair;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.interactor.Callback;
import com.chog0.weatherappyandexschool.interactor.InteractorImpl;
import com.chog0.weatherappyandexschool.model.app_model.WeatherDTO;
import com.chog0.weatherappyandexschool.presentation.ui.WeatherView;
import com.chog0.weatherappyandexschool.presentation.ui.fragment.WeatherFragment;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import static android.support.annotation.VisibleForTesting.NONE;
import static com.chog0.weatherappyandexschool.presentation.ui.activity.SearchActivity.PLACE_ID_INTENT_KEY;

@InjectViewState
public class WeatherPresenter extends MvpPresenter<WeatherView> {

    private static final String TAG_PRESENTER = "MainPresenter";

    @Inject
    InteractorImpl interactor;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public WeatherPresenter() {
        WeatherApp.getAppComponent().inject(this);
        getViewState().setInfoToViews();
    }

    @VisibleForTesting(otherwise = NONE)
    public WeatherPresenter(InteractorImpl interactor) {
        this.interactor = interactor;
    }

    public void getWeather() {
        interactor.getWeather()
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

    private void showWeather(@NonNull WeatherDTO weatherDTO) {
        getViewState().showData(weatherDTO);

    }

    private void showError(@NonNull String e) {
        getViewState().showError(e);
    }

    public void handleOnActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == WeatherFragment.REQUEST_CODE) {
            if (data != null) {
                String placeId = data.getStringExtra(PLACE_ID_INTENT_KEY);
                getPlaceDetails(placeId);
            }
        }
    }

    private void getPlaceDetails(String placeId) {
        compositeDisposable.add(
                interactor.getPlaceDetails(placeId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<Pair<Float, Float>>() {
                            @Override
                            public void onSuccess(Pair<Float, Float> pair) {
                                float lat = pair.first;
                                float lon = pair.second;
                                interactor.saveCurrentCityGeoCodes(lat,lon);
                                getWeather();
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        }));
    }

    public void onSearchClick() {
        getViewState().openSearchScreen();
    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
        super.onDestroy();
    }
}
