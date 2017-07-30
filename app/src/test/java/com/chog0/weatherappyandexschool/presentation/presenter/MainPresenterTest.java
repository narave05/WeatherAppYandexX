package com.chog0.weatherappyandexschool.presentation.presenter;

import com.chog0.weatherappyandexschool.presentation.navigation.Router;
import com.chog0.weatherappyandexschool.presentation.view.MainView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MainPresenterTest {

    @Mock
    private Router mockRouter;
    @Mock
    private MainView view;

    private MainPresenter testPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testPresenter = new MainPresenter(mockRouter);
        testPresenter.attachView(view);
    }

    @Test
    public void testPresenterInitialize() throws Exception {
        verify(view, times(1)).initView();
    }
}