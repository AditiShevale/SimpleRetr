package com.example.aditishevale999.simpleretr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager LayoutManager;
    private Contact contacts;
    private RecyclerAdapter adapter;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();
        callRetrofit();
    }


    private void setupRecyclerView() {

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LayoutManager);
    }



    private void callRetrofit() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Contact> call = apiInterface.getcontacts();
        call.enqueue(new Callback<Contact>() {

            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                contacts = response.body().getResponseData();
                String url= String.valueOf(response.raw().request().url());
                List<Contact> mContact= Collections.singletonList(contacts);

                adapter = new RecyclerAdapter(mContact);
                recyclerView.setAdapter(adapter);
                Log.e("Hey",contacts.getEmail()+ " " + url);
            }
            @Override
            public void onFailure(Call<Contact> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }


}
