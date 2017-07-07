package com.chog0.weatherappyandexschool.presentation.navigation;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class RouterFragment implements Router<Fragment> {

    private FragmentManager fragmentManager;
    private int container;

    public RouterFragment(FragmentManager fragmentManager, int container) {
        this.fragmentManager = fragmentManager;
        this.container = container;
    }

    @Override
    public void pushFragment(Fragment fragment, int container) {
        fragmentManager
                .beginTransaction()
                .add(container, fragment)
                .commit();
    }

    @Override
    public void popFragment() {
        fragmentManager.popBackStack();
    }
}
