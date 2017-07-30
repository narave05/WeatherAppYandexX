package com.chog0.weatherappyandexschool.settings;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;
import android.util.Log;

import com.chog0.weatherappyandexschool.Constants;
import com.chog0.weatherappyandexschool.WeatherApp;

public class PreferencesManager {
    private static final String RESPONSE = "RESPONSE";
    private static final String PERIOD = "PERIOD";
    private static final String ID = "ID";
    private static final String CURRENT_CITY_CODES = "CURRENT_CITY_CODES";
    public static final int DONT_UPDATE_BUTTON_ID = 2131558554;

    private SharedPreferences sharedPreferences;

    public PreferencesManager() {
        this.sharedPreferences = WeatherApp.getContext().getSharedPreferences("com.chog0.weatherappyandexschool", Context.MODE_PRIVATE);
    }

    public void saveResponse(@NonNull String response) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(RESPONSE, response);
        editor.apply();
    }

    public String getResponse() {
        return sharedPreferences.getString(RESPONSE, "");
    }

    public void savePeriodUpdate(int period) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PERIOD, period);
        editor.apply();
    }

    public int getPeriod() {
        return sharedPreferences.getInt(PERIOD, 0);
    }

    public void saveRadioButtonId(int id) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(ID, id);
        editor.apply();
    }

    public int getRadioButtonId() {
        return sharedPreferences.getInt(ID, DONT_UPDATE_BUTTON_ID);
    }

    public void saveCurrentCityGeoCodes(float lat, float lon) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(CURRENT_CITY_CODES, lat + " " + lon);
        editor.apply();
    }

    public Pair<Float, Float> getCurrentCityGeoCodes() {
        String[] temp = sharedPreferences
                .getString(CURRENT_CITY_CODES, Constants.MOSCOW_LATITUDE + " " + Constants.MOSCOW_LONGITUDE)
                .split("\\s+");
        float lat = Float.parseFloat(temp[0]);
        float lon = Float.parseFloat(temp[1]);
        return new Pair<>(lat, lon);
    }

}
