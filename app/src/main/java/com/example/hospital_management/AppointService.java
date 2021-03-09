package com.example.hospital_management;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AppointService {
    @GET("/api/appointments")
    Call<List<Appointment>> getAllAppoints();
    @GET("/api/appointment")
    Call<Appointment> getAppointmentById(@Query("appointId") int appointId);

    @POST("/api/appointment")
    Call<Appointment> insertAppointment(@Body Appointment a);

}
