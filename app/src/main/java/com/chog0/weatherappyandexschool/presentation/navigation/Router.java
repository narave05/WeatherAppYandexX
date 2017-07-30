package com.chog0.weatherappyandexschool.presentation.navigation;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

public interface Router<T> {

    void pushFragment(@NonNull T fragment);
    void openFirstFragment(@NonNull T fragment);
}
