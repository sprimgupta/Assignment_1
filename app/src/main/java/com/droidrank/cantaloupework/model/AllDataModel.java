package com.droidrank.cantaloupework.model;


import com.droidrank.cantaloupework.constants.Constants;
import com.droidrank.cantaloupework.retrofit.ApiClient;
import com.droidrank.cantaloupework.retrofit.NYTDataApi;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllDataModel extends BaseObservable {
    MutableLiveData<AllData> mostPopularDataMutableLiveData = new MutableLiveData<>();


    public MutableLiveData<AllData> getMostPopularDataMutableLiveData() {
        return mostPopularDataMutableLiveData;
    }

    public void setMostPopularDataMutableLiveData(MutableLiveData<AllData> mostPopularDataMutableLiveData) {
        this.mostPopularDataMutableLiveData = mostPopularDataMutableLiveData;
    }

    public void fetchList() {
        Callback<AllData> callback = new Callback<AllData>() {
            @Override
            public void onResponse(Call<AllData> call, Response<AllData> response) {
                AllData body = response.body();
                mostPopularDataMutableLiveData.setValue(body);
            }

            @Override
            public void onFailure(Call<AllData> call, Throwable t) {

            }
        };
        NYTDataApi apiService = ApiClient.getClient().create(NYTDataApi.class);

        Call<AllData> call = apiService.getMostPopularArticles(7, Constants.NYT_API_KEY, 0);
        call.enqueue(callback);
    }
}
