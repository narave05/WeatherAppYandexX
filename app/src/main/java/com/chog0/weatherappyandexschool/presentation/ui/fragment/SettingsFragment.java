package com.chog0.weatherappyandexschool.presentation.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.chog0.weatherappyandexschool.R;
import com.chog0.weatherappyandexschool.WeatherApp;
import com.chog0.weatherappyandexschool.job.WeatherSyncJob;
import com.chog0.weatherappyandexschool.model.ResponseModel.Weather;
import com.chog0.weatherappyandexschool.presentation.presenter.SettingsPresenter;
import com.chog0.weatherappyandexschool.presentation.view.SettingsView;
import com.chog0.weatherappyandexschool.repository.RepositoryImpl;
import com.evernote.android.job.JobManager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SettingsFragment extends BaseFragment implements View.OnClickListener, SettingsView {

    @InjectPresenter
    SettingsPresenter presenter;

    public static final int PERIOD_60 = 60;
    public static final int PERIOD_180 = 180;
    public static final int PERIOD_15 = 15;
    public static final int PERIOD_30 = 30;
    public static final int PERIOD_45 = 45;
    public static final int PERIOD_0 = 0;

    @BindView(R.id._1_h)RadioButton RadioButton1h;
    @BindView(R.id._3_h)RadioButton RadioButton3h;
    @BindView(R.id._15_min)RadioButton RadioButton15min;
    @BindView(R.id._30_min)RadioButton RadioButton30min;
    @BindView(R.id._45_min)RadioButton RadioButton45min;
    @BindView(R.id.dont_update)RadioButton RadioButtonDontUpdate;
    private View view;

    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        WeatherApp.getAppComponent().inject(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getRadioButtonId();
        setListenersOnRadioButtons();
    }

    private void setListenersOnRadioButtons() {

        RadioButton1h.setOnClickListener(this);
        RadioButton3h.setOnClickListener(this);
        RadioButton15min.setOnClickListener(this);
        RadioButton30min.setOnClickListener(this);
        RadioButton45min.setOnClickListener(this);
        RadioButtonDontUpdate.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        boolean checked = ((RadioButton)v).isChecked();

        if (checked) {
            switch (v.getId()) {
                case R.id._1_h:
                        presenter.scheduleJob(PERIOD_60, v.getId());
                    break;
                case R.id._3_h:
                        presenter.scheduleJob(PERIOD_180, v.getId());
                    break;
                case R.id._15_min:
                        presenter.scheduleJob(PERIOD_15, v.getId());
                    break;
                case R.id._30_min:
                        presenter.scheduleJob(PERIOD_30, v.getId());
                    break;
                case R.id._45_min:
                        presenter.scheduleJob(PERIOD_45, v.getId());
                    break;
                case R.id.dont_update:
                        presenter.scheduleJob(PERIOD_0, v.getId());
                    break;
            }
        }

    }

    @Override
    public void setRadioButton(int id) {
        ((RadioButton) view.findViewById(id)).setChecked(true);
    }
}
