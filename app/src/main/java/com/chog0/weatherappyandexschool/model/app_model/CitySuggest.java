package com.chog0.weatherappyandexschool.model.app_model;

public class CitySuggest {
    private final String placeId;
    private final String description;

    public CitySuggest(String placeId, String description) {
        this.placeId = placeId;
        this.description = description;
    }

    public String getPlaceId() {
        return placeId;
    }

    public String getDescription() {
        return description;
    }
}
