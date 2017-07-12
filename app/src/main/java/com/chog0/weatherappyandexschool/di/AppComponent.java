package com.chog0.weatherappyandexschool.di;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */

import com.chog0.weatherappyandexschool.presentation.presenter.MainPresenter;
import com.chog0.weatherappyandexschool.presentation.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {PresenterModule.class, RepositoryModule.class, NetworkModule.class, ContextModule.class})
@Singleton
public interface AppComponent {

    void inject(MainActivity mainActivity);
    void inject(MainPresenter mainPresenter);
}
