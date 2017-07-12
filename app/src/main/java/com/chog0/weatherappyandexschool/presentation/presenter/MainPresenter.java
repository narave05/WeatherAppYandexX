package com.chog0.weatherappyandexschool.presentation.presenter;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.support.v4.app.Fragment;

import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.presentation.navigation.Router;
import com.chog0.weatherappyandexschool.presentation.navigation.RouterFragment;
import com.chog0.weatherappyandexschool.presentation.ui.fragment.AboutFragment;
import com.chog0.weatherappyandexschool.presentation.ui.fragment.SettingsFragment;
import com.chog0.weatherappyandexschool.presentation.ui.fragment.WeatherFragment;
import com.chog0.weatherappyandexschool.repository.RepositoryImpl;

import javax.inject.Inject;

public class MainPresenter {

    @Inject
    RepositoryImpl repository;

    public MainPresenter() {
        WeatherApp.getRepositoryComponent().inject(this);
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
}
