package com.chog0.weatherappyandexschool;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.app.Application;

import com.chog0.weatherappyandexschool.di.DaggerPresenterComponent;
import com.chog0.weatherappyandexschool.di.PresenterComponent;
import com.chog0.weatherappyandexschool.di.PresenterModule;

public class WeatherApp extends Application {

    private static PresenterComponent presenterComponent;

    public static PresenterComponent getPresenterComponent() {
        return presenterComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        presenterComponent = buildPresenterComponent();

    }

    protected PresenterComponent buildPresenterComponent(){
        return DaggerPresenterComponent.builder()
                .presenterModule(new PresenterModule())
                .build();
    }
}
