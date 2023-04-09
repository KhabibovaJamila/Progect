package com.example.mysmartlab;

import com.example.mysmartlab.DataClass.ImageAnalyzes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInteface {
    @GET("/api/news")
    Call<List<ImageAnalyzes>> getCarsJcon();
}
