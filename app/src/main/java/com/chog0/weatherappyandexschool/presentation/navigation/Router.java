package com.chog0.weatherappyandexschool.presentation.navigation;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


public interface Router<T> {

    void pushFragment(T fragment, int containerId);
    void popFragment();

}
