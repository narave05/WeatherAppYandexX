package com.chog0.weatherappyandexschool.di;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */

import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.interactor.InteractorImpl;
import com.chog0.weatherappyandexschool.presentation.presenter.SearchPresenter;
import com.chog0.weatherappyandexschool.presentation.presenter.SettingsPresenter;
import com.chog0.weatherappyandexschool.presentation.presenter.WeatherPresenter;
import com.chog0.weatherappyandexschool.presentation.ui.fragment.SettingsFragment;
import com.chog0.weatherappyandexschool.repository.RepositoryImpl;
import com.chog0.weatherappyandexschool.settings.PreferencesManager;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {RepositoryModule.class, NetworkModule.class, ContextModule.class, InteractorModule.class,
        PreferencesModule.class})
@Singleton
public interface AppComponent {

    void inject(InteractorImpl interactor);
    void inject(PreferencesManager preferencesManager);
    void inject(RepositoryImpl repository);
    void inject(WeatherPresenter weatherPresenter);
    void inject(SearchPresenter searchPresenter);
    void inject(SettingsPresenter presenter);
    void inject(WeatherApp weatherApp);
    void inject(SettingsFragment settingsFragment);

}
