package com.cps.views.events_news;

import android.app.Application;
import android.app.ProgressDialog;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cps.R;
import com.cps.helpers.ApiClient;
import com.cps.interfaces.ApiInterface;
import com.cps.models.responses.EventsNewsItem;
import com.cps.models.responses.JsonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventNewsFragmentRepository {

    //Application application;
    public MutableLiveData<List<EventsNewsItem>> requestdata(int type) {
      //  application = new Application();
        //ProgressDialog dialog = new ProgressDialog(application);
        //dialog = new ProgressDialog(getContext());
        //dialog.setCancelable(false);
        //dialog.setMessage(application.getString(R.string.loading));
        //dialog.show();
        final MutableLiveData<List<EventsNewsItem>> mutableLiveData = new MutableLiveData<>();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonResponse> responseCall = apiInterface.event_news(type);
        responseCall.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                //dialog.dismiss();
                if (response.isSuccessful() && response.body()!=null ) {
                    mutableLiveData.setValue(response.body().getData().getEventsNews());
                    Log.d("Test", ""+response.code());

                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                //dialog.dismiss();
                Log.d("Test", "tt  "+t);
            }
        });


        return mutableLiveData;
    }
}
