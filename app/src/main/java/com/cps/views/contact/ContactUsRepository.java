package com.cps.views.contact;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cps.helpers.ApiClient;
import com.cps.interfaces.ApiInterface;
import com.cps.models.requests.SendContact;
import com.cps.models.responses.JsonResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactUsRepository {

    public MutableLiveData<Integer> requestdata(SendContact contact) {
        Log.d("Test","Contact test 1");

        Log.d("Test","Contact test 2  "+ contact.getSubject());

        final MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonResponse> responseCall = apiInterface.contactus(contact);
        responseCall.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                if (response.isSuccessful() && response.body()!=null ) {
                    //mutableLiveData.setValue(response.body().getData().getEventsNews());
                    mutableLiveData.setValue(response.body().getStatus().getCode());
                    Log.d("Test", "Contact   "+response.code());
                }else {
                    Log.d("Test", "Contact  m "+response.message());
                    Log.d("Test", "Contact  c "+response.code());
                    Log.d("Test", "Contact  r "+response.toString());

                    mutableLiveData.setValue(response.code());
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
