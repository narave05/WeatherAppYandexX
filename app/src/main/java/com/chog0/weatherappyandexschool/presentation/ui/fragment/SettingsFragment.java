package com.chog0.weatherappyandexschool.presentation.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.chog0.weatherappyandexschool.R;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.job.WeatherSyncJob;
import com.chog0.weatherappyandexschool.model.ResponseModel.Weather;
import com.chog0.weatherappyandexschool.repository.RepositoryImpl;
import com.evernote.android.job.JobManager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SettingsFragment extends Fragment implements View.OnClickListener {

    public static final int PERIOD_60 = 60;
    public static final int PERIOD_180 = 180;
    public static final int PERIOD_15 = 15;
    public static final int PERIOD_30 = 30;
    public static final int PERIOD_45 = 45;
    public static final int PERIOD_0 = 0;
    @Inject
    RepositoryImpl repository;

    @BindView(R.id._1_h)RadioButton RadioButton1h;
    @BindView(R.id._3_h)RadioButton RadioButton3h;
    @BindView(R.id._15_min)RadioButton RadioButton15min;
    @BindView(R.id._30_min)RadioButton RadioButton30min;
    @BindView(R.id._45_min)RadioButton RadioButton45min;
    @BindView(R.id.dont_update)RadioButton RadioButtonDontUpdate;
    private Unbinder unbinder;

    public SettingsFragment() {
        // Required empty public constructor
    }

    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
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
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        ButterKnife.bind(this, view);
        WeatherApp.getAppComponent().inject(this);

        RadioButton1h.setOnClickListener(this);
        RadioButton3h.setOnClickListener(this);
        RadioButton15min.setOnClickListener(this);
        RadioButton30min.setOnClickListener(this);
        RadioButton45min.setOnClickListener(this);
        RadioButtonDontUpdate.setOnClickListener(this);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override
    public void onClick(View v) {
        boolean checked = ((RadioButton)v).isChecked();

        switch (v.getId()) {
            case R.id._1_h:
                if (checked) {
                    repository.setWeatherUpdatePeriod(PERIOD_60);
                    WeatherSyncJob.scheduleJob(repository.getWeatherUpdatePeriod());
                }
                break;
            case R.id._3_h:
                if (checked) {
                    repository.setWeatherUpdatePeriod(PERIOD_180);
                    WeatherSyncJob.scheduleJob(repository.getWeatherUpdatePeriod());
                }
                break;
            case R.id._15_min:
                if (checked) {
                    repository.setWeatherUpdatePeriod(PERIOD_15);
                    WeatherSyncJob.scheduleJob(repository.getWeatherUpdatePeriod());
                }
                break;
            case R.id._30_min:
                if (checked) {
                    repository.setWeatherUpdatePeriod(PERIOD_30);
                    WeatherSyncJob.scheduleJob(repository.getWeatherUpdatePeriod());
                }
                break;
            case R.id._45_min:
                if (checked) {
                    repository.setWeatherUpdatePeriod(PERIOD_45);
                    WeatherSyncJob.scheduleJob(repository.getWeatherUpdatePeriod());
                }
                break;
            case R.id.dont_update:
                if (checked) {
                    repository.setWeatherUpdatePeriod(PERIOD_0);
                    JobManager.instance().cancelAllForTag(WeatherSyncJob.TAG);
                }
                break;
        }
    }
}
