package com.chog0.weatherappyandexschool.model.app_model;

/*
 * @author <a href="mailto: alyonamalchikhina@gmail.com">Alena Malchikhina</a>
 * @since 0.1
 */


public class WeatherDTO {
    private String icon;
    private Double temperature;
    private Double minTemperature;
    private Double maxTemperature;
    private Double pressure;
    private int wind;
    private int humidity;
    private String city;
    public long time;

    public long getTime() {
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


    public int getWind() {
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

        public Builder setIcon(String icon){
            WeatherDTO.this.icon = icon;
            return this;
        }

        public Builder setTemperature(Double temp){
            WeatherDTO.this.temperature = temp;
            return this;
        }
        public Builder setMaxTemperature(Double temp){
            WeatherDTO.this.maxTemperature = temp;
            return this;
        }
        public Builder setMinTemperature(Double temp){
            WeatherDTO.this.minTemperature = temp;
            return this;
        }
        public Builder setWind(int wind){
            WeatherDTO.this.wind = wind;
            return this;
        }
        public Builder setPressure(Double pressure){
            WeatherDTO.this.pressure = pressure;
            return this;
        }
        public Builder setHumidity(int humidity){
            WeatherDTO.this.humidity = humidity;
            return this;
        }
        public Builder setCity(String city){
            WeatherDTO.this.city = city;
            return this;
        }
        public Builder setTime(long time){
            WeatherDTO.this.time = time;
            return this;
        }
        public WeatherDTO build(){
            return WeatherDTO.this;
        }

    }

}
