package com.chog0.weatherappyandexschool.repository;

import com.chog0.weatherappyandexschool.Constants;
import com.chog0.weatherappyandexschool.resources.MockData;
import com.chog0.weatherappyandexschool.settings.PreferencesManager;
import com.chog0.weatherappyandexschool.web.PlaceApi;
import com.chog0.weatherappyandexschool.web.WeatherApi;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RepositoryImplTest {

    private RepositoryImpl testRepository;
    private
    @Mock
    WeatherApi mockWeatherApi;
    private
    @Mock
    PlaceApi mockPlaceApi;
    private
    @Mock
    PreferencesManager mockPreferencesManager;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testRepository = new RepositoryImpl(mockWeatherApi, mockPlaceApi, mockPreferencesManager);
    }

    @Test
    public void storeWeather() throws Exception {
        testRepository.storeWeather(MockData.MOCK_WEATHER_DATA);
        verify(mockPreferencesManager, times(1)).saveResponse(MockData.MOCK_WEATHER_DATA);
    }

    @Test
    public void setWeatherUpdatePeriod() throws Exception {
        testRepository.setWeatherUpdatePeriod(anyInt());
        verify(mockPreferencesManager, times(1)).savePeriodUpdate(anyInt());
    }

    @Test
    public void getWeatherUpdatePeriod() throws Exception {
        testRepository.getWeatherUpdatePeriod();
        verify(mockPreferencesManager, times(1)).getPeriod();
    }

    @Test
    public void getPlacesSuggestList() throws Exception {
        testRepository.getPlacesSuggestList(MockData.MOCK_SUGGEST_TEXT);
        verify(mockPlaceApi, times(1)).getPlacesSuggestList(Constants.GOOGLE_PLACE_API_ID,
                Constants.PLACE_TYPES, MockData.MOCK_SUGGEST_TEXT);
    }

    @Test
    public void getPlaceDetails() throws Exception {
        testRepository.getPlaceDetails(MockData.MOCK_SUGGEST_TEXT);
        verify(mockPlaceApi, times(1)).getPlaceDetails(Constants.GOOGLE_PLACE_API_ID, MockData.MOCK_SUGGEST_TEXT);
    }

    @Test
    public void getWeather() throws Exception {
        testRepository.getWeather(Constants.MOSCOW_LATITUDE, Constants.MOSCOW_LONGITUDE);
        verify(mockWeatherApi, times(1)).getCurrentWeather(Constants.API_KEY, Constants.MOSCOW_LATITUDE,
                Constants.MOSCOW_LONGITUDE);
    }

}