package com.chog0.weatherappyandexschool.model.app_model;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


import android.support.annotation.NonNull;

public class WeatherDTO {
    private String icon;
    private double temperature;
    private double minTemperature;
    private double maxTemperature;
    private double pressure;
    private double wind;
    private int humidity;
    private String city;
    private String time;
    private int id;
    private long sunrise;
    private long sunset;

    public int getId() {
        return id;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public String getTime() {
        return time;
    }

    private WeatherDTO() {

    }

    public String getCity() {
        return city;
    }


    public String getIcon() {
        return icon;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }


    public Double getMaxTemperature() {
        return maxTemperature;
    }


    public Double getPressure() {
        return pressure;
    }


    public Double getWind() {
        return wind;
    }


    public int getHumidity() {
        return humidity;
    }
    public static Builder newBuilder(){
        return new WeatherDTO().new Builder();
    }

    public class Builder{
        private Builder() {

        }

        public Builder setIcon(@NonNull String icon){
            WeatherDTO.this.icon = icon;
            return this;
        }

        public Builder setTemperature(double temp){
            WeatherDTO.this.temperature = temp;
            return this;
        }
        public Builder setMaxTemperature(double temp){
            WeatherDTO.this.maxTemperature = temp;
            return this;
        }
        public Builder setMinTemperature(double temp){
            WeatherDTO.this.minTemperature = temp;
            return this;
        }
        public Builder setWind(double wind){
            WeatherDTO.this.wind = wind;
            return this;
        }
        public Builder setPressure(double pressure){
            WeatherDTO.this.pressure = pressure;
            return this;
        }
        public Builder setHumidity(int humidity){
            WeatherDTO.this.humidity = humidity;
            return this;
        }
        public Builder setCity(String city){
            WeatherDTO.this.city = city;
            return this;        }
        public Builder setTime(String time){
            WeatherDTO.this.time = time;
            return this;
        }

        public Builder setId(int id){
            WeatherDTO.this.id = id;
            return this;
        }
        public Builder setSunrise(long sunrise){
            WeatherDTO.this.sunrise = sunrise;
            return this;
        }
        public Builder setSunset(long sunset){
            WeatherDTO.this.sunset = sunset;
            return this;
        }
        public WeatherDTO build(){
            return WeatherDTO.this;
        }

    }

}
