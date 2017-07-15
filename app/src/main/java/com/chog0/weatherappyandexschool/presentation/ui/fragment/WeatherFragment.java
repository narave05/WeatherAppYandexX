package com.chog0.weatherappyandexschool.presentation.ui.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.chog0.weatherappyandexschool.R;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.model.app_model.WeatherDTO;
import com.chog0.weatherappyandexschool.presentation.presenter.MainPresenter;
import com.chog0.weatherappyandexschool.presentation.presenter.WeatherPresenter;
import com.chog0.weatherappyandexschool.presentation.ui.WeatherView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class WeatherFragment extends MvpAppCompatFragment implements WeatherView{

    private Typeface weatherFont;

    @InjectPresenter
    WeatherPresenter weatherPresenter;

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
        weatherPresenter.getWeather();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showData(WeatherDTO weatherDTO) {
        cityTv.setText(getString(R.string.moscow));
        temperatureTv.setText(String.valueOf(weatherDTO.getTemperature().intValue()));
        maxTempTv.setText(String.valueOf(weatherDTO.getMaxTemperature().intValue()));
        minTempTv.setText(String.valueOf(weatherDTO.getMinTemperature().intValue()));
        iconTv.setText(weatherDTO.getIcon());
        udateTimeTv.setText(timeFormated(weatherDTO.getTime()));
    }

    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(getActivity(), getString(R.string.impossible_to_get_weather), Toast.LENGTH_LONG).show();
    }
    private String timeFormated(long timeStamp){

        try{
            DateFormat sdf = new SimpleDateFormat("dd.MM hh:mm:ss", Locale.getDefault());
            Date netDate = (new Date(timeStamp));
            return sdf.format(netDate);
        }
        catch(Exception ex){
            Log.e(this.getClass().getName(), "timeFormated: ", ex.getCause());
            return getString(R.string.impossible_convert_data);
        }
    }
}
