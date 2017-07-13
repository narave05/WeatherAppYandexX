package com.chog0.weatherappyandexschool.presentation.presenter;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.chog0.weatherappyandexschool.R;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.interactor.InteractorImpl;
import com.chog0.weatherappyandexschool.model.ResponseWeather;
import com.chog0.weatherappyandexschool.presentation.navigation.Router;
import com.chog0.weatherappyandexschool.presentation.navigation.RouterFragment;
import com.chog0.weatherappyandexschool.presentation.ui.fragment.AboutFragment;
import com.chog0.weatherappyandexschool.presentation.ui.fragment.SettingsFragment;
import com.chog0.weatherappyandexschool.presentation.ui.fragment.WeatherFragment;
import com.chog0.weatherappyandexschool.repository.RepositoryImpl;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {

    private static final String TAG_PRESENTER = "MainPresenter";

    @Inject
    InteractorImpl interactor;
    @Inject
    Context context;


    public MainPresenter() {
        WeatherApp.getAppComponent().inject(this);
    }

    private Router<Fragment> routerFragment;

    public void setRouterFragment(Router<Fragment> routerFragment) {
        this.routerFragment = routerFragment;
    }

    public void openWeatherFragment (){
        routerFragment.openFirstFragment(WeatherFragment.newInstance());
    }

    public void pushSettingsFragment(){
        routerFragment.pushFragment(SettingsFragment.newInstance());
    }

    public void pushAboutFragment(){
        routerFragment.pushFragment(AboutFragment.newInstance());
    }

    public void pushWeatherFragment() {
        routerFragment.pushFragment(WeatherFragment.newInstance());
    }


    public void getWeather(){
        interactor.getWeather(context.getString(R.string.moscow_id))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(e -> {
                    Log.e(TAG_PRESENTER, "getWeather: ", e.getCause());
                    return new ResponseWeather();
                })
                .subscribe(responseWeather -> {
                    Log.d(TAG_PRESENTER, "getWeather: weather come");
                });

    }
}
