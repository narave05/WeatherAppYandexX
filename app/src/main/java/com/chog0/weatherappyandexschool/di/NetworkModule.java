package com.chog0.weatherappyandexschool.di;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */

import com.chog0.weatherappyandexschool.web.WeatherApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module
public class NetworkModule {

    private static final long MAX_CONNECT_TIMEOUT = 15000;
    private static final long MAX_READ_TIMEOUT = 15000;


    @Singleton
    @Provides
    public Retrofit provideRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.connectTimeout(MAX_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        httpClient.readTimeout(MAX_READ_TIMEOUT, TimeUnit.MILLISECONDS);
        httpClient.addInterceptor(logging);
        return new Retrofit.Builder()

                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();
    }

    @Singleton
    @Provides
    public WeatherApi provideWeatherApi (Retrofit retrofit){
        return retrofit.create(WeatherApi.class);
    }
}
