package com.chog0.weatherappyandexschool.presentation.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.chog0.weatherappyandexschool.R;
import com.chog0.weatherappyandexschool.presentation.navigation.Router;
import com.chog0.weatherappyandexschool.presentation.navigation.WeatherRouter;
import com.chog0.weatherappyandexschool.presentation.presenter.MainPresenter;
import com.chog0.weatherappyandexschool.presentation.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MvpAppCompatActivity implements MainView, NavigationView.OnNavigationItemSelectedListener {

    private Router<Fragment> routerFragment = new WeatherRouter(this.getSupportFragmentManager(), R.id.fragment_container);

    @InjectPresenter
    MainPresenter mainPresenter;

    @ProvidePresenter
    public MainPresenter providePresenter(){
        return new MainPresenter(routerFragment);
    }

    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        if (savedInstanceState == null) {
            mainPresenter.openWeatherFragment();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_weather:
                mainPresenter.pushWeatherFragment();
                break;
            case R.id.nav_about:
                mainPresenter.pushAboutFragment();
                break;
            case R.id.nav_settings:
                mainPresenter.pushSettingsFragment();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
