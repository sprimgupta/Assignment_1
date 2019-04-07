package com.droidrank.cantaloupework.retrofit;

import com.droidrank.cantaloupework.model.AllData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NYTDataApi {

    @GET("{duration}.json")
    Call<AllData> getMostPopularArticles(@Path("duration") int duration, @Query("api-key") String apiKey, @Query("offset") int offset);
}