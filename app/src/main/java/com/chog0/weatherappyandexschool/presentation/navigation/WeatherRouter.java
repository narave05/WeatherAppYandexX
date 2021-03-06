package com.chog0.weatherappyandexschool.presentation.navigation;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class WeatherRouter implements Router<Fragment> {

    private String fragmentName;
    private FragmentManager fragmentManager;
    private int container;

    public WeatherRouter(FragmentManager fragmentManager, int container) {
        this.fragmentManager = fragmentManager;
        this.container = container;
    }

    @Override
    public void openFirstFragment(@NonNull Fragment fragment) {
        fragmentManager
                .beginTransaction()
                .replace(container, fragment)
                .commit();
    }

    @Override
    public void pushFragment(@NonNull Fragment fragment) {

        String backStateName =  fragment.getClass().getName();

        boolean fragmentPopped = fragmentManager.popBackStackImmediate (backStateName, 0);

        if (!fragmentPopped && fragmentManager.findFragmentByTag(backStateName) == null) { //fragment not in back stack, create it.
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(container, fragment, backStateName);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }
}
