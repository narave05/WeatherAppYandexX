package com.chog0.weatherappyandexschool;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.app.Application;

import com.chog0.weatherappyandexschool.di.DaggerPresenterComponent;
import com.chog0.weatherappyandexschool.di.DaggerRepositoryComponent;
import com.chog0.weatherappyandexschool.di.PresenterComponent;
import com.chog0.weatherappyandexschool.di.PresenterModule;
import com.chog0.weatherappyandexschool.di.RepositoryComponent;
import com.chog0.weatherappyandexschool.di.RepositoryModule;
import com.chog0.weatherappyandexschool.repository.Repository;

public class WeatherApp extends Application {

    private static PresenterComponent presenterComponent;
    private static RepositoryComponent repositoryComponent;

    public static PresenterComponent getPresenterComponent() {
        return presenterComponent;
    }
    public static RepositoryComponent getRepositoryComponent() {
        return repositoryComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        presenterComponent = buildPresenterComponent();
        repositoryComponent = buildRepositoryComponent();
    }

    protected PresenterComponent buildPresenterComponent(){
        return DaggerPresenterComponent.builder()
                .presenterModule(new PresenterModule())
                .build();
    }
    protected RepositoryComponent buildRepositoryComponent(){
        return DaggerRepositoryComponent.builder()
                .repositoryModule(new RepositoryModule())
                .build();
    }
}
