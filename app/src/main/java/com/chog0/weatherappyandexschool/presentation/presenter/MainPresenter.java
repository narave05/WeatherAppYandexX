package com.chog0.weatherappyandexschool.presentation.presenter;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.support.v4.app.Fragment;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chog0.weatherappyandexschool.Constants;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.interactor.InteractorImpl;
import com.chog0.weatherappyandexschool.model.ResponseWeather;
import com.chog0.weatherappyandexschool.presentation.view.MainView;
import com.chog0.weatherappyandexschool.presentation.navigation.Router;
import com.chog0.weatherappyandexschool.presentation.ui.fragment.AboutFragment;
import com.chog0.weatherappyandexschool.presentation.ui.fragment.SettingsFragment;
import com.chog0.weatherappyandexschool.presentation.ui.fragment.WeatherFragment;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView>{

    private static final String TAG_PRESENTER = "MainPresenter";

    @Inject
    InteractorImpl interactor;


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
        interactor.getWeather(Constants.MOSCOW_ID)
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
