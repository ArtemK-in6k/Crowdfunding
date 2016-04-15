package com.crowd.utils.splitbill;

import com.crowd.utils.DateUtils;
import com.crowd.utils.splitbill.model.LoginRequest;
import com.crowd.utils.splitbill.model.event.Event;
import com.crowd.utils.splitbill.model.response.LoginResponse;
import com.crowd.utils.splitbill.model.response.UserResponse;
import com.crowd.utils.splitbill.service.EventService;
import com.crowd.utils.splitbill.service.UserService;
import com.squareup.okhttp.ResponseBody;
import retrofit.Callback;
import retrofit.JacksonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import java.io.IOException;
import java.util.Date;

public class SplitBillApi {
    private Retrofit retrofit;
    private UserService userService;
    private EventService eventService;

    public SplitBillApi() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://split-bill.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        userService = retrofit.create(UserService.class);
        eventService = retrofit.create(EventService.class);
    }

    private void getUser(String token) {

        userService.getUserData(token).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Response<UserResponse> response, Retrofit retrofit) {
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }


    private void login(String email){
        userService.login(new LoginRequest(email)).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Response<LoginResponse> response, Retrofit retrofit) {
                System.out.println(response);

            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

    public void createEvent(String email, String title, Date date) {
        Event event = prepareEvent(title, date);
        eventService.createEvent(email, event).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    String str = new String(response.body().bytes());
                    System.out.println(str);

                } catch (IOException e) {
                    System.out.println("bla");

                }
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

    private Event prepareEvent(String title, Date date) {
        Event event = new Event();

        event.setTitle(title);
        event.setDate(DateUtils.getFormattedDate(date));

        return event;
    }
}
