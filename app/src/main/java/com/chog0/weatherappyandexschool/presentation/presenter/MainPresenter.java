package com.chog0.weatherappyandexschool.presentation.presenter;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.presentation.view.MainView;
import com.chog0.weatherappyandexschool.presentation.navigation.Router;
import com.chog0.weatherappyandexschool.presentation.ui.fragment.AboutFragment;
import com.chog0.weatherappyandexschool.presentation.ui.fragment.SettingsFragment;
import com.chog0.weatherappyandexschool.presentation.ui.fragment.WeatherFragment;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView>{

    private Router<Fragment> routerFragment;

    public MainPresenter(@NonNull Router<Fragment> routerFragment) {
        this.routerFragment = routerFragment;
        getViewState().initView();
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
