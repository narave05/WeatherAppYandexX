package com.chog0.weatherappyandexschool.presentation.presenter;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chog0.weatherappyandexschool.Constants;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.interactor.InteractorImpl;
import com.chog0.weatherappyandexschool.model.ResponseModel.ResponseWeather;
import com.chog0.weatherappyandexschool.presentation.ui.WeatherView;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class WeatherPresenter extends MvpPresenter<WeatherView> {

    public WeatherPresenter() {
        WeatherApp.getAppComponent().inject(this);
    }

    private static final String TAG_PRESENTER = "MainPresenter";

    @Inject
    InteractorImpl interactor;

    public void getWeather(){
        interactor.getWeather(Constants.MOSCOW_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(e -> {
                    Log.e(TAG_PRESENTER, "getWeather: ", e.getCause());
                    showError(e);
                    return new ResponseWeather();

                })
                .subscribe(responseWeather -> {
                    Log.d(TAG_PRESENTER, "getWeather: weather come");

                    showWeather(responseWeather);
                });

    }

    private void showWeather(ResponseWeather responseWeather) {
        getViewState().showData(interactor.builWeather(responseWeather));
    }

    private void showError(Throwable e) {
        getViewState().showError(e);
    }

}
