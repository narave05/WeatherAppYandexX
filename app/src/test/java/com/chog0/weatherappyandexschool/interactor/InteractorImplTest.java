package com.chog0.weatherappyandexschool.interactor;

import android.support.v4.util.Pair;

import com.chog0.weatherappyandexschool.Constants;
import com.chog0.weatherappyandexschool.model.ResponseModel.ResponseWeather;
import com.chog0.weatherappyandexschool.model.ResponseModel.place_detail.PlaceDetails;
import com.chog0.weatherappyandexschool.model.ResponseModel.places_suggest.PlacesSuggest;
import com.chog0.weatherappyandexschool.model.app_model.CitySuggest;
import com.chog0.weatherappyandexschool.model.app_model.WeatherDTO;
import com.chog0.weatherappyandexschool.repository.RepositoryImpl;
import com.chog0.weatherappyandexschool.resources.MockData;
import com.chog0.weatherappyandexschool.settings.PreferencesManager;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class InteractorImplTest {

    private InteractorImpl testInteractor;

    @Mock
    private RepositoryImpl mockRepository;
    @Mock
    private PreferencesManager mockPreferencesManager;
    @Mock
    private Callback mockCallback;

    private ObjectMapper mapper = new ObjectMapper();
    private PlacesSuggest placesSuggest;
    private PlaceDetails placeDetails;
    private ResponseWeather responseWeather;
    private List<CitySuggest> citySuggests = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testInteractor = new InteractorImpl(mockRepository, mockPreferencesManager);
        placesSuggest = mapper.readValue(MockData.MOCK_PLACES_SUGGEST_DATA, PlacesSuggest.class);
        responseWeather = mapper.readValue(MockData.MOCK_WEATHER_DATA, ResponseWeather.class);
        placeDetails = mapper.readValue(MockData.MOCK_PLACES_DETAILS_DATA, PlaceDetails.class);

        citySuggests.add(new CitySuggest("ChIJybDUc_xKtUYRTM9XV8zWRD0", "Moscow, Russia"));
        citySuggests.add(new CitySuggest("ChIJN8KDzdWNQQ0RkhLXONCLKRw", "Móstoles, Spain"));
        citySuggests.add(new CitySuggest("ChIJo_-SrTusEmsREMIyFmh9AQU", "Mosman, New South Wales, Australia"));
        citySuggests.add(new CitySuggest("ChIJqUBjO6RDSxMRWnzj1LIyTwE", "Mostar, Federation of Bosnia and Herzegovina, Bosnia and Herzegovina"));
        citySuggests.add(new CitySuggest("ChIJ27vfjjU_mVQRJCDl7OXrUD8", "Moses Lake, WA, United States"));

    }


    @Test
    public void getWeather() throws Exception {
        when(mockPreferencesManager.getCurrentCityGeoCodes())
                .thenReturn(new Pair<>(Constants.MOSCOW_LATITUDE, Constants.MOSCOW_LONGITUDE));
        testInteractor.getWeather();
        verify(mockPreferencesManager, times(1)).getCurrentCityGeoCodes();
        verify(mockRepository, times(1)).getWeather(Constants.MOSCOW_LATITUDE, Constants.MOSCOW_LONGITUDE);
    }

    @Test
    public void saveWeather() throws Exception {
        testInteractor.saveWeather(anyString());
        verify(mockRepository, times(1)).storeWeather(anyString());
    }

    @Test
    public void parseWeather_Success() throws Exception {
        Callback callback = mock(Callback.class);
        when(mockPreferencesManager.getResponse()).thenReturn(MockData.MOCK_WEATHER_DATA);
        testInteractor.parseWeather(callback);
        verify(callback, times(1)).onSuccess(any());
        verify(callback, never()).onError(any());

    }

    @Test
    public void parseWeather_Error() throws Exception {
        when(mockPreferencesManager.getResponse()).thenReturn(Constants.EMPTY_STRING);
        testInteractor.parseWeather(mockCallback);
        verify(mockCallback, atLeastOnce()).onError(any());
        verify(mockCallback, never()).onSuccess(any());

    }

    @Test
    public void getCitySuggestList() throws Exception {
        when(mockRepository.getPlacesSuggestList(anyString())).thenReturn(Flowable.just(placesSuggest));
        TestObserver<List<CitySuggest>> testObserver = testInteractor.getCitySuggestList(MockData.MOCK_SUGGEST_TEXT)
                .test();
        testObserver.awaitTerminalEvent();
        testObserver.assertResult(citySuggests);
    }

    @Test
    public void getPlaceDetails() throws Exception {
        when(mockRepository.getPlaceDetails(anyString())).thenReturn(Single.just(placeDetails));
        TestObserver<Pair<Float, Float>> testObserver = testInteractor.getPlaceDetails(MockData.MOCK_PLACE_ID)
                .test();
        testObserver.awaitTerminalEvent();
        Pair<Float, Float> codes = new Pair<>(55.755826f, 37.6173f);
        testObserver.assertResult(codes);
    }

    @Test
    public void saveCurrentCityGeoCodes() throws Exception {
        testInteractor.saveCurrentCityGeoCodes(Constants.MOSCOW_LATITUDE, Constants.MOSCOW_LONGITUDE);
        verify(mockPreferencesManager, times(1)).saveCurrentCityGeoCodes(Constants.MOSCOW_LATITUDE, Constants.MOSCOW_LONGITUDE);
    }

    @Test
    public void builWeather() throws Exception {
        WeatherDTO weatherDTO = testInteractor.builWeather(responseWeather);
        assertThat(weatherDTO.getTemperature()).isEqualTo(38.14999999999998);
        assertThat(weatherDTO.getMaxTemperature()).isEqualTo(38.14999999999998);
        assertThat(weatherDTO.getMinTemperature()).isEqualTo(38.14999999999998);
        assertThat(weatherDTO.getPressure()).isEqualTo(756.0642654625636);
    }

}