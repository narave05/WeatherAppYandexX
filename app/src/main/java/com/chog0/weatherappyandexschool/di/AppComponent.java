package com.chog0.weatherappyandexschool.di;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */

import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.interactor.InteractorImpl;
import com.chog0.weatherappyandexschool.presentation.presenter.MainPresenter;
import com.chog0.weatherappyandexschool.presentation.presenter.WeatherPresenter;
import com.chog0.weatherappyandexschool.presentation.ui.activity.MainActivity;
import com.chog0.weatherappyandexschool.presentation.ui.fragment.WeatherFragment;
import com.chog0.weatherappyandexschool.repository.RepositoryImpl;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {PresenterModule.class, RepositoryModule.class, NetworkModule.class, ContextModule.class, InteractorModule.class})
@Singleton
public interface AppComponent {


    void inject(InteractorImpl interactor);
    void inject(RepositoryImpl repository);
    void inject(WeatherPresenter weatherPresenter);
}
