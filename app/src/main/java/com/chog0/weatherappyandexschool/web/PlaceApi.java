package com.chog0.weatherappyandexschool.web;

import com.chog0.weatherappyandexschool.model.ResponseModel.places_suggest.PlacesSuggest;
import com.chog0.weatherappyandexschool.model.ResponseModel.place_detail.PlaceDetails;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlaceApi {

    @GET("queryautocomplete/json")
    Flowable<PlacesSuggest> getPlacesSuggestList(@Query("key") String id, @Query("types") String types, @Query("input") String param);

    @GET("details/json")
    Single<PlaceDetails> getPlaceDetails(@Query("key") String id, @Query("placeid") String placeid);
}
