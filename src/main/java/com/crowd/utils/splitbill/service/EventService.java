package com.crowd.utils.splitbill.service;


import com.crowd.utils.splitbill.model.event.Event;
import com.squareup.okhttp.ResponseBody;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Header;
import retrofit.http.POST;

public interface EventService {
    @POST("api/events")
    Call<ResponseBody> createEvent(@Header("X-AUTH-TOKEN")String token, @Body Event event);
}
