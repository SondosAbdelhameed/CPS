package com.cps.interfaces;


import com.cps.models.requests.SendAdmission;
import com.cps.models.requests.SendAdmissionMedia;
import com.cps.models.requests.SendContact;
import com.cps.models.responses.JsonResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import static com.cps.helpers.Constant.*;


/**
 * Created by Tranxit Technologies Pvt Ltd, Chennai
 */

public interface ApiInterface {


    @FormUrlEncoded
    @POST(SERVER_EVENT_NEWS)
    Call<JsonResponse> event_news(@Field("type") int type);

    @POST(SERVER_CONTACTUS)
    Call<JsonResponse> contactus(@Body SendContact sendContact);

    @POST(SERVER_ADMISSION_DATA)
    Call<JsonResponse> admission_data(@Body SendAdmission admission);

    @POST(SERVER_ADMISSION_MEDIA)
    Call<JsonResponse> admission_media(@Body SendAdmissionMedia admission);

    @POST(SERVER_GALLERY)
    Call<JsonResponse> gallery();
}
