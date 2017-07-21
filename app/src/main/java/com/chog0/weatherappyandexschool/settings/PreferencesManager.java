package com.chog0.weatherappyandexschool.settings;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.content.Context;
import android.content.SharedPreferences;

import com.chog0.weatherappyandexschool.WeatherApp;

public class PreferencesManager {
    private static final String RESPONSE = "RESPONSE";
    private static final String PERIOD = "PERIOD";
    private static final String ID = "ID";
    public static final int DONT_UPDATE_BUTTON_ID = 2131558554;

    private SharedPreferences sharedPreferences;

    public PreferencesManager() {
        this.sharedPreferences = WeatherApp.getContext().getSharedPreferences("com.chog0.weatherappyandexschool", Context.MODE_PRIVATE);
    }

    public void saveResponse(String response) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(RESPONSE, response);
        editor.apply();
    }
    public String getResponse() {
        return sharedPreferences.getString(RESPONSE, "");
    }

    public void savePeriodUpdate(int period){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PERIOD, period);
        editor.apply();
    }
    public int getPeriod() {
        return sharedPreferences.getInt(PERIOD, 0);
    }
    public void saveRadioButtonId(int id){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(ID, id);
        editor.apply();
    }
    public int getRadioButtonId() {
        return sharedPreferences.getInt(ID, DONT_UPDATE_BUTTON_ID);
    }

}
