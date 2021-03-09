package com.example.hospital_management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmationActivity extends AppCompatActivity {
    ArrayList appoinment;
    EditText pname, email, chooseDoctor, bg, gender, contact, dob, bt, nid, appointdate, appointidserach;
    Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        appointidserach = findViewById(R.id.cappointsearchtid);
        pname=findViewById(R.id.cpatientid);
        email=findViewById(R.id.cemailid);
        chooseDoctor=findViewById(R.id.cdoctorid);
        bg=findViewById(R.id.cbgid);
        gender=findViewById(R.id.cgenderid);
        contact=findViewById(R.id.ccontactid);
        dob=findViewById(R.id.cdobid);
        bt=findViewById(R.id.cbtid);
        nid=findViewById(R.id.cnid);
        appointdate=findViewById(R.id.cappointdateid);
        search=findViewById(R.id.csearchid);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppointService appointService = AppointClient.getRetrofitInstance().create(AppointService.class);
                appointService.getAppointmentById(Integer.parseInt(appointidserach.getText().toString())).enqueue(new Callback<Appointment>() {
                    @Override
                    public void onResponse(Call<Appointment> call, Response<Appointment> response) {
                        if(response.body()!=null){
                            Appointment  a = response.body();
                            pname.setText(a.getPatientName());
                            System.out.println("Patient----"+ a.getPatientName());
                            email.setText(response.body().getEmail());
                            chooseDoctor.setText(response.body().getDoctorName());
                            bg.setText(response.body().getBloodGroup());
                            gender.setText(response.body().getGender());
                            contact.setText(response.body().getContactNumber());
                            dob.setText(response.body().getDateOfBirth());
                            bt.setText(response.body().getBloodType());
                            nid.setText(response.body().getNid());
                            appointdate.setText(response.body().getAppointDate());
                        }

                    }

                    @Override
                    public void onFailure(Call<Appointment> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

            }
        });
    }
}