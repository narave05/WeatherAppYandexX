package com.chog0.weatherappyandexschool;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.app.Application;
import android.content.Context;

import com.chog0.weatherappyandexschool.di.AppComponent;
import com.chog0.weatherappyandexschool.di.ContextModule;
import com.chog0.weatherappyandexschool.di.DaggerAppComponent;
import com.chog0.weatherappyandexschool.di.InteractorModule;
import com.chog0.weatherappyandexschool.di.NetworkModule;
import com.chog0.weatherappyandexschool.di.PreferencesModule;
import com.chog0.weatherappyandexschool.di.PresenterModule;
import com.chog0.weatherappyandexschool.di.RepositoryModule;
import com.facebook.stetho.Stetho;

public class WeatherApp extends Application {

    private static AppComponent appComponent;
    public static AppComponent getAppComponent() {
        return appComponent;
    }
    private static WeatherApp context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        appComponent = buildAppComponent();
        Stetho.initializeWithDefaults(this);

    }

    protected AppComponent buildAppComponent(){
        return DaggerAppComponent.builder()
                .presenterModule(new PresenterModule())
                .repositoryModule(new RepositoryModule())
                .networkModule(new NetworkModule())
                .contextModule(new ContextModule(this))
                .interactorModule(new InteractorModule())
                .preferencesModule(new PreferencesModule())
                .build();
    }
    public static WeatherApp getContext(){
        return context;
    }

}
