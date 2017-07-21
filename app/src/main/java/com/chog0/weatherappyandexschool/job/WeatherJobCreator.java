package com.chog0.weatherappyandexschool.job;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import com.chog0.weatherappyandexschool.repository.RepositoryImpl;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

public class WeatherJobCreator implements JobCreator {

    private RepositoryImpl repository;

    public WeatherJobCreator(RepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public Job create(String tag) {
        switch (tag) {
            case WeatherSyncJob.TAG:
                return new WeatherSyncJob(repository);
            default:
                return null;
        }
    }
}
