package com.chog0.weatherappyandexschool;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.app.Application;

import com.chog0.weatherappyandexschool.di.AppComponent;
import com.chog0.weatherappyandexschool.di.ContextModule;
import com.chog0.weatherappyandexschool.di.DaggerAppComponent;
import com.chog0.weatherappyandexschool.di.InteractorModule;
import com.chog0.weatherappyandexschool.di.NetworkModule;
import com.chog0.weatherappyandexschool.di.PreferencesModule;
import com.chog0.weatherappyandexschool.di.RepositoryModule;
import com.chog0.weatherappyandexschool.job.WeatherJobCreator;
import com.chog0.weatherappyandexschool.job.WeatherSyncJob;
import com.chog0.weatherappyandexschool.repository.RepositoryImpl;
import com.chog0.weatherappyandexschool.settings.PreferencesManager;
import com.evernote.android.job.JobManager;
import com.facebook.stetho.Stetho;

import javax.inject.Inject;

public class WeatherApp extends Application {

    @Inject
    RepositoryImpl repository;
    @Inject
    PreferencesManager preferencesManager;

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

        appComponent.inject(this);

        JobManager manager = JobManager.create(context);

        runJob(manager);
    }

    private void runJob(JobManager manager) {
        if (preferencesManager.getPeriod() != 0) {
            manager.addJobCreator(new WeatherJobCreator(repository));
            WeatherSyncJob.scheduleJob(repository.getWeatherUpdatePeriod());
        }else {
            manager.cancelAllForTag(WeatherSyncJob.TAG);
        }
    }

    protected AppComponent buildAppComponent(){
        return DaggerAppComponent.builder()
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
