package com.chog0.weatherappyandexschool.di;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */

import com.chog0.weatherappyandexschool.presentation.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = RepositoryModule.class)
@Singleton

public interface RepositoryComponent {
    void inject(MainPresenter mainPresenter);
}
