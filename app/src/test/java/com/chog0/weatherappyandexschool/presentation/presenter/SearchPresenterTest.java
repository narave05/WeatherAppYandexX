package com.chog0.weatherappyandexschool.presentation.presenter;

import com.chog0.weatherappyandexschool.Constants;
import com.chog0.weatherappyandexschool.interactor.InteractorImpl;
import com.chog0.weatherappyandexschool.model.app_model.CitySuggest;
import com.chog0.weatherappyandexschool.presentation.view.SearchView;
import com.chog0.weatherappyandexschool.resources.MockData;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SearchPresenterTest {

    @Mock
    private InteractorImpl testInteractor;
    @Mock
    private SearchView mockView;

    private SearchPresenter testPresenter;
    private List<CitySuggest> citySuggests = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testPresenter = Mockito.spy(new SearchPresenter(testInteractor));
        testPresenter.attachView(mockView);

        citySuggests.add(new CitySuggest("ChIJybDUc_xKtUYRTM9XV8zWRD0", "Moscow, Russia"));
        citySuggests.add(new CitySuggest("ChIJN8KDzdWNQQ0RkhLXONCLKRw", "Móstoles, Spain"));
        citySuggests.add(new CitySuggest("ChIJo_-SrTusEmsREMIyFmh9AQU", "Mosman, New South Wales, Australia"));
        citySuggests.add(new CitySuggest("ChIJqUBjO6RDSxMRWnzj1LIyTwE", "Mostar, Federation of Bosnia and Herzegovina, Bosnia and Herzegovina"));
        citySuggests.add(new CitySuggest("ChIJ27vfjjU_mVQRJCDl7OXrUD8", "Moses Lake, WA, United States"));


        when(testInteractor.getCitySuggestList(anyString())).thenReturn(Single.just(citySuggests));

        // Override RxAndroid schedulers
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                __ -> Schedulers.trampoline());
    }

    @Test
    public void init() throws Exception {
        testPresenter.init();
        verify(mockView, times(1)).subscribeTextChanges();
    }

    @Test
    public void onSearchTextChange_EMPTI_STRING() throws Exception {
        testPresenter.onSearchTextChange(Constants.EMPTY_STRING);
        verify(mockView, times(1)).hideProgress();
        verify(mockView, times(1)).showSuggestList(new ArrayList<>());
    }

    @Test
    public void onSearchTextChange_NO_EMPTI_STRING() throws Exception {
        testPresenter.onSearchTextChange(MockData.MOCK_SUGGEST_TEXT);
        verify(mockView, times(1)).showProgress();
        verify(testPresenter, times(1)).getCitySuggestList(MockData.MOCK_SUGGEST_TEXT);
    }

    @Test
    public void onSuggestSelect() throws Exception {
        CitySuggest suggest = mock(CitySuggest.class);
        testPresenter.onSuggestSelect(suggest);
        verify(mockView, times(1)).returnActivityResultOk(suggest.getPlaceId());
    }

    @Test
    public void handleOnBackPressed() throws Exception {
        testPresenter.handleOnBackPressed();
        verify(mockView, times(1)).returnActivityResultCancel();
        verify(mockView, times(1)).finishSearchActivity();
    }
}