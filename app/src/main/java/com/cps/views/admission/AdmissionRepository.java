package com.cps.views.admission;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cps.helpers.ApiClient;
import com.cps.interfaces.ApiInterface;
import com.cps.models.requests.SendAdmission;
import com.cps.models.requests.SendAdmissionMedia;
import com.cps.models.requests.SendContact;
import com.cps.models.responses.JsonResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdmissionRepository {

    public MutableLiveData<Integer> requestadmissiondata(SendAdmission admission) {

        final MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonResponse> responseCall = apiInterface.admission_data(admission);
        responseCall.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                if (response.isSuccessful() && response.body() != null) {
                    mutableLiveData.setValue(response.body().getStatus().getCode());
                } else {

                    mutableLiveData.setValue(response.code());
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.d("Test", "tt  " + t);
            }
        });


        return mutableLiveData;
    }

    public MutableLiveData<Integer> requestadmissionmedia(SendAdmissionMedia admission) {

        final MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonResponse> responseCall = apiInterface.admission_media(admission);
        responseCall.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                if (response.isSuccessful() && response.body() != null) {
                    //mutableLiveData.setValue(response.body().getData().getEventsNews());
                    mutableLiveData.setValue(response.body().getStatus().getCode());
                } else {

                    mutableLiveData.setValue(response.code());
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.d("Test", "tt  " + t);
            }
        });


        return mutableLiveData;
    }
}
