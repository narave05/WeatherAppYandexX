package com.chog0.weatherappyandexschool.presentation.ui.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chog0.weatherappyandexschool.R;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.presentation.presenter.MainPresenter;
import com.chog0.weatherappyandexschool.presentation.ui.WeatherView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class WeatherFragment extends Fragment implements WeatherView {


    @Inject
    MainPresenter mainPresenter;
    private Typeface weatherFont;

    @BindView(R.id.icon_id_tv) TextView iconTv;
    @BindView(R.id.temp_tv)TextView temperatureTv;
    @BindView(R.id.city_id)TextView cityTv;
    @BindView(R.id.update_time_tv)TextView udateTimeTv;
    @BindView(R.id.min_temp_tv)TextView minTempTv;
    @BindView(R.id.max_temp_tv)TextView maxTempTv;
    private Unbinder unbinder;


    public WeatherFragment() {
        // Required empty public constructor
    }

    public static WeatherFragment newInstance() {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeatherApp.getAppComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mainPresenter.getWeather();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setIcon() {

    }

    @Override
    public void setTemperature() {

    }

    @Override
    public void setMinTemperature() {

    }

    @Override
    public void setMaxTemperature() {

    }

    @Override
    public void setCity() {

    }
}
