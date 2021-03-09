package com.example.hospital_management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SearchView;

public class DoctorActivity extends AppCompatActivity {
    int [] doctors = {R.drawable.doctor1, R.drawable.doctor2,R.drawable.doctor3,R.drawable.doctor4,
            R.drawable.doctor5,R.drawable.doctor6,R.drawable.doctor7,R.drawable.doctor8};
    private GridView gridView;
    String[]doctorname;
    String[]specialist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        gridView = findViewById(R.id.gridviewid);
        doctorname = getResources().getStringArray(R.array.doctorname);
        specialist = getResources().getStringArray(R.array.specialist);

        CustomAdapter adapter = new CustomAdapter(this,doctors,doctorname,specialist);
        gridView.setAdapter(adapter);

    }


}