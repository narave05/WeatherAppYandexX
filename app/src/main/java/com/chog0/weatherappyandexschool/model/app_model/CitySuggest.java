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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CitySuggest)) return false;

        CitySuggest suggest = (CitySuggest) o;

        if (!getPlaceId().equals(suggest.getPlaceId())) return false;
        return getDescription().equals(suggest.getDescription());

    }

    @Override
    public int hashCode() {
        int result = getPlaceId().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }
}
