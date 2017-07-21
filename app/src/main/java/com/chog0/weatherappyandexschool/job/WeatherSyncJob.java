package com.chog0.weatherappyandexschool.job;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.support.annotation.NonNull;
import android.util.Log;

import com.chog0.weatherappyandexschool.Constants;
import com.chog0.weatherappyandexschool.repository.RepositoryImpl;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.support.PersistableBundleCompat;

import java.util.concurrent.TimeUnit;


public class WeatherSyncJob extends Job{

    public static final String TAG = "Weather_job";
    private RepositoryImpl repository;

    public WeatherSyncJob(@NonNull RepositoryImpl repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    protected Result onRunJob(Params params) {
        Log.d(TAG, "onRunJob: job is running");

        repository
                .getWeather(Constants.MOSCOW_ID)
                .doOnError(Throwable::printStackTrace)
                .subscribe(response -> {
                    repository.storeWeather(response);
                    Log.d(TAG, "onRunJob: weather came");
                });

        return Result.SUCCESS;
    }
    public static void scheduleJob(int min) {
        new JobRequest.Builder(WeatherSyncJob.TAG)
                .setPeriodic(TimeUnit.MINUTES.toMillis(min), TimeUnit.MINUTES.toMillis(5))
                .setRequiredNetworkType(JobRequest.NetworkType.CONNECTED)
                .setUpdateCurrent(true)
                .setPersisted(true)
                .build()
                .schedule();
    }
}
