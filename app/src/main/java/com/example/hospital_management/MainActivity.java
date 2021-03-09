package com.example.hospital_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button docbutton, appointbutton, servicebutton, confirmationbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        docbutton = findViewById(R.id.doctorbuttonid);
        appointbutton = findViewById(R.id.appointid);
        servicebutton = findViewById(R.id.serviceid);
        confirmationbutton = findViewById(R.id.confirmationid);
       confirmationbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent= new Intent(MainActivity.this,ConfirmationActivity.class);
               startActivity(intent);
           }
       });
        docbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,DoctorActivity.class);
                startActivity(intent);
            }
        });
        appointbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AppointActivity.class);
                startActivity(intent);
            }
        });
        servicebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ServiceActivity.class);
                startActivity(intent);
            }
        });

    }
}