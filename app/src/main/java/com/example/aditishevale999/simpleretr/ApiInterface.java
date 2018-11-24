package com.example.aditishevale999.simpleretr;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("api/Login/Get")
    Call<Contact> getcontacts();
}
