package com.chog0.weatherappyandexschool.di;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */

import com.chog0.weatherappyandexschool.interactor.Interactor;
import com.chog0.weatherappyandexschool.interactor.InteractorImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Singleton
    @Provides
    public InteractorImpl provideInteractor(){
        return new InteractorImpl();
    }
}
