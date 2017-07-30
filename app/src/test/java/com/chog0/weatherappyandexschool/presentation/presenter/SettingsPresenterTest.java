package com.chog0.weatherappyandexschool.presentation.presenter;

import com.chog0.weatherappyandexschool.presentation.view.SettingsView;
import com.chog0.weatherappyandexschool.repository.RepositoryImpl;
import com.chog0.weatherappyandexschool.settings.PreferencesManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class SettingsPresenterTest {

    @Mock
    private RepositoryImpl mockRepository;
    @Mock
    private PreferencesManager mockPreferencesManager;
    @Mock
    private SettingsView mockView;

    private SettingsPresenter testPresenter;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testPresenter = new SettingsPresenter(mockPreferencesManager, mockRepository);
        testPresenter.attachView(mockView);
    }

    @Test
    public void getRadioButtonId() throws Exception {
        testPresenter.getRadioButtonId();
        verify(mockView, times(1)).setRadioButton(anyInt());
    }

    @Test
    public void setRadioButtonId() throws Exception {
        testPresenter.setRadioButtonId(anyInt());
        verify(mockPreferencesManager, times(1)).saveRadioButtonId(anyInt());
    }

}