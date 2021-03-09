package com.example.hospital_management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ServiceActivity extends AppCompatActivity {
    int [] services = {R.drawable.physical_exam, R.drawable.bloodtest,R.drawable.urine,R.drawable.xray};
    private ListView listView;
    String[]servicename;
    String[]serviceprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        listView = findViewById(R.id.listviewid);
        servicename = getResources().getStringArray(R.array.servaicename);
        serviceprice = getResources().getStringArray(R.array.serviceprice);
        ServiceAdapter adapter = new ServiceAdapter(this,services,servicename,serviceprice);
        listView.setAdapter(adapter);
    }
}