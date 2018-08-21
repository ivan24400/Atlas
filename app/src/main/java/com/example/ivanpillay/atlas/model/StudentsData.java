package com.example.ivanpillay.atlas.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StudentsData {
    @GET("/photos")
    Call<List<Student>> getData();
}
