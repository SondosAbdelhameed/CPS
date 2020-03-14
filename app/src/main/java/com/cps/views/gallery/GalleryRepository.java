package com.cps.views.gallery;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cps.helpers.ApiClient;
import com.cps.interfaces.ApiInterface;
import com.cps.models.responses.GalleryItem;
import com.cps.models.responses.JsonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryRepository {

    public MutableLiveData<List<GalleryItem>> requestdata() {

        final MutableLiveData<List<GalleryItem>> mutableLiveData = new MutableLiveData<>();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonResponse> responseCall = apiInterface.gallery();
        responseCall.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                if (response.isSuccessful() && response.body()!=null ) {
                    mutableLiveData.setValue(response.body().getData().getGallery());
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.d("Test", "tt  "+t);
            }
        });


        return mutableLiveData;
    }
}
