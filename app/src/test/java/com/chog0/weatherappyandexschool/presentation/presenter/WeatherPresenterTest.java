package com.chog0.weatherappyandexschool.presentation.presenter;

import com.chog0.weatherappyandexschool.interactor.InteractorImpl;
import com.chog0.weatherappyandexschool.presentation.ui.WeatherView;
import com.chog0.weatherappyandexschool.resources.MockData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WeatherPresenterTest {

    @Mock
    InteractorImpl testInteractor;

    @Mock
    private WeatherView mockView;

    private WeatherPresenter testPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testPresenter = Mockito.spy(new WeatherPresenter(testInteractor));
        testPresenter.attachView(mockView);

        // Override RxAndroid schedulers
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                __ -> Schedulers.trampoline());
    }

    @After
    public void tear_off() throws Exception {
        RxAndroidPlugins.reset();
    }

    @Test
    public void getWeather_Successes() throws Exception {
        when(testInteractor.getWeather()).thenReturn(Observable.just(MockData.MOCK_WEATHER_DATA));
        testPresenter.getWeather();
        verify(testInteractor, times(1)).getWeather();
        verify(testInteractor, times(1)).saveWeather(MockData.MOCK_WEATHER_DATA);
        verify(mockView, times(1)).showData(any());
        verify(mockView, never()).showError(anyString());
    }

    @Test
    public void onSearchClick() throws Exception {
        testPresenter.onSearchClick();
        verify(mockView, times(1)).openSearchScreen();
    }

}