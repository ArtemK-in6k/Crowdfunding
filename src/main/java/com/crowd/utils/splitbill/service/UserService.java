package com.crowd.utils.splitbill.service;


import com.crowd.utils.splitbill.model.LoginRequest;
import com.crowd.utils.splitbill.model.response.LoginResponse;
import com.crowd.utils.splitbill.model.response.UserResponse;
import retrofit.Call;
import retrofit.http.*;

public interface UserService {
    @GET("api/user")
    Call<UserResponse> getUserData(@Header("X-AUTH-TOKEN")String token);

    @Headers( "Content-Type: application/json" )
    @POST("api/user/login")
    Call<LoginResponse> login(@Body LoginRequest request);
}