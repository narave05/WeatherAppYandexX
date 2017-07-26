package com.chog0.weatherappyandexschool.presentation.ui.fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.chog0.weatherappyandexschool.Constants;
import com.chog0.weatherappyandexschool.R;
import com.chog0.weatherappyandexschool.model.app_model.WeatherDTO;
import com.chog0.weatherappyandexschool.presentation.presenter.WeatherPresenter;
import com.chog0.weatherappyandexschool.presentation.ui.WeatherView;
import com.chog0.weatherappyandexschool.presentation.ui.activity.SearchActivity;

import butterknife.BindView;
import butterknife.OnClick;


public class WeatherFragment extends BaseFragment implements WeatherView {

    public static final int REQUEST_CODE = 152;
    private Typeface weatherFont;

    @InjectPresenter
    WeatherPresenter weatherPresenter;

    @BindView(R.id.icon_id_tv)
    TextView iconTv;
    @BindView(R.id.temp_tv)
    TextView temperatureTv;
    @BindView(R.id.city_id)
    TextView cityTv;
    @BindView(R.id.update_time_tv)
    TextView udateTimeTv;
    @BindView(R.id.min_temp_tv)
    TextView minTempTv;
    @BindView(R.id.max_temp_tv)
    TextView maxTempTv;
    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.wind_tv)
    TextView windTv;
    @BindView(R.id.humidity_tv)
    TextView humidityTv;
    @BindView(R.id.pressure_tv)
    TextView pressureTv;
    @BindView(R.id.error_tv)
    TextView errorTv;
    @BindView(R.id.constrain_weather)
    ConstraintLayout container;

    public static WeatherFragment newInstance() {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        weatherPresenter.parseWeatherFromSP();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshWeather();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        weatherPresenter.handleOnActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void setInfoToViews() {
        weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weather.ttf");

        iconTv.setTypeface(weatherFont);
        pressureTv.setTypeface(weatherFont);
        windTv.setTypeface(weatherFont);
        humidityTv.setTypeface(weatherFont);
        maxTempTv.setTypeface(weatherFont);
        minTempTv.setTypeface(weatherFont);
    }

    private void refreshWeather() {
        refreshLayout.setOnRefreshListener(() -> {
            errorTv.setVisibility(View.GONE);
            weatherPresenter.getWeather();
        });

        refreshLayout.setColorSchemeResources(R.color.colorAccent);
    }

    @Override
    public void showData(@NonNull WeatherDTO weatherDTO) {
        container.setVisibility(View.VISIBLE);
        errorTv.setVisibility(View.GONE);
        cityTv.setText(weatherDTO.getCity());
        temperatureTv.setText(String.valueOf(weatherDTO.getTemperature().intValue()) + getString(R.string.celsius));
        maxTempTv.setText(getString(R.string.temp) + " " + String.valueOf(weatherDTO.getMaxTemperature().intValue()) + getString(R.string.celsius));
        minTempTv.setText(getString(R.string.temp) + " " + String.valueOf(weatherDTO.getMinTemperature().intValue()) + getString(R.string.celsius));
        setWeatherIcon(weatherDTO.getId());
        udateTimeTv.setText(weatherDTO.getTime());
        pressureTv.setText(getString(R.string.pressure) + " " + String.valueOf(weatherDTO.getPressure().intValue()) + " " + getString(R.string.mmhg));
        windTv.setText(getString(R.string.wind) + " " + String.valueOf(weatherDTO.getWind()) + " " + getString(R.string.msec));
        humidityTv.setText(getString(R.string.humidity) + " " + String.valueOf(weatherDTO.getHumidity()) + " " + getString(R.string.percents));
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showError(@NonNull String throwable) {
        Log.e(this.getClass().getName(), throwable);
        refreshLayout.setRefreshing(false);
        container.setVisibility(View.GONE);
        errorTv.setVisibility(View.VISIBLE);
    }

    @Override
    public void openSearchScreen() {
        startActivityForResult(SearchActivity.getStartIntent(getActivity()),REQUEST_CODE);
    }

    @OnClick({R.id.city_id,R.id.search_img})
    public void onSearchClick(View view) {
        weatherPresenter.onSearchClick();
    }



    private void setWeatherIcon(int actualId) {
        int id = actualId / 100;
        String icon = "";

        switch (id) {
            case 2:
                icon = getActivity().getString(R.string.weather_thunder);
                break;
            case 3:
                icon = getActivity().getString(R.string.weather_drizzle);
                break;
            case 7:
                icon = getActivity().getString(R.string.weather_foggy);
                break;
            case 8:
                icon = getActivity().getString(R.string.weather_cloudy);
                break;
            case 6:
                icon = getActivity().getString(R.string.weather_snowy);
                break;
            case 5:
                icon = getActivity().getString(R.string.weather_rainy);
                break;
        }
        iconTv.setText(icon);
    }


}
