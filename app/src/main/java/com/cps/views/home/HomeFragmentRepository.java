package com.cps.views.home;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cps.helpers.ApiClient;
import com.cps.interfaces.ApiInterface;
import com.cps.models.responses.EventsNewsItem;
import com.cps.models.responses.JsonResponse;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragmentRepository {

    public MutableLiveData<EventsNewsItem> requestnews(int type) {
        final MutableLiveData<EventsNewsItem> mutableLiveData = new MutableLiveData<>();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonResponse> responseCall = apiInterface.event_news(type);
        responseCall.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if (response.isSuccessful() && response.body()!=null ) {
                    mutableLiveData.setValue(response.body().getData().getEventsNews().get(0));
                }
            }
            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.e("Test", "getProdList onFailure" + t.toString());

            }
        });


        return mutableLiveData;
    }
}
