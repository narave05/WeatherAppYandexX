package com.chog0.weatherappyandexschool.presentation.presenter;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */

import android.support.annotation.VisibleForTesting;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.job.WeatherSyncJob;
import com.chog0.weatherappyandexschool.presentation.ui.WeatherView;
import com.chog0.weatherappyandexschool.presentation.view.SettingsView;
import com.chog0.weatherappyandexschool.repository.RepositoryImpl;
import com.chog0.weatherappyandexschool.settings.PreferencesManager;
import com.evernote.android.job.JobManager;

import javax.inject.Inject;

import static android.support.annotation.VisibleForTesting.NONE;

@InjectViewState
public class SettingsPresenter  extends MvpPresenter<SettingsView> {

    @Inject
    PreferencesManager preferencesManager;

    @Inject
    RepositoryImpl repository;

    public SettingsPresenter() {
        WeatherApp.getAppComponent().inject(this);
    }

    @VisibleForTesting(otherwise = NONE)
    public SettingsPresenter(PreferencesManager preferencesManager, RepositoryImpl repository) {
        this.preferencesManager = preferencesManager;
        this.repository = repository;
    }


    public void getRadioButtonId(){
        getViewState().setRadioButton(preferencesManager.getRadioButtonId());
    }
    public void setRadioButtonId(int id){
        preferencesManager.saveRadioButtonId(id);
    }

    public void scheduleJob(int time, int id){
        repository.setWeatherUpdatePeriod(time);
        setRadioButtonId(id);
        if (time != 0) {
            WeatherSyncJob.scheduleJob(repository.getWeatherUpdatePeriod());
        }else {
            JobManager.instance().cancelAllForTag(WeatherSyncJob.TAG);
        }

    }
}
