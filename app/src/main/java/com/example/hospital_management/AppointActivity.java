package com.example.hospital_management;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppointActivity extends AppCompatActivity implements View.OnClickListener{
String[]doctornames;
    ArrayList appoinment;
    EditText dateappointtext, pname, email,  contact, dob,  nid, appointdate;
    Button dateappointbutton, save, dobbutton;
    AlertDialog.Builder alertbuilder;
    Spinner spinner;
    RadioGroup radioGroup,bt,bg;
    RadioButton radioButton,btbutton,bgbutton;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoint);
        getAllAppoints();
        dob = findViewById(R.id.dobid);
        dobbutton = findViewById(R.id.dobbutton);
        dobbutton.setOnClickListener(this);
        dateappointtext = findViewById(R.id.appointdateid);
        dateappointbutton = findViewById(R.id.appointdatebuttonid);
        dateappointbutton.setOnClickListener(this);
//         appointidserach = findViewById(R.id.appointsearchtid);
       doctornames = getResources().getStringArray(R.array.doctorname);
       spinner = findViewById(R.id.spinnerid);
//       spinner.setOnClickListener(this);
       ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,R.layout.activity_spinnerview,R.id.spinnertextid,doctornames);
       spinner.setAdapter(adapter);
        pname=findViewById(R.id.patientid);
save = findViewById(R.id.saveid);
         email=findViewById(R.id.emailid);
//        chooseDoctor=findViewById(R.id.doctorid);
         bg=findViewById(R.id.bgid);
//         gender=findViewById(R.id.genderid);
        radioGroup = findViewById(R.id.genderid);
         contact=findViewById(R.id.contactid);
         dob=findViewById(R.id.dobid);
         bt=findViewById(R.id.btid);
        nid=findViewById(R.id.nid);
         appointdate=findViewById(R.id.appointdateid);
//         search=findViewById(R.id.searchid);
//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AppointService appointService = AppointClient.getRetrofitInstance().create(AppointService.class);
//                appointService.getAppointmentById(Integer.parseInt(appointidserach.getText().toString())).enqueue(new Callback<Appointment>() {
//                    @Override
//                    public void onResponse(Call<Appointment> call, Response<Appointment> response) {
//                        if(response.body()!=null){
//                            Appointment  a = response.body();
//                            pname.setText(a.getPatientName());
//                            System.out.println("Patient----"+ a.getPatientName());
//                            email.setText(response.body().getEmail());
//                            chooseDoctor.setText(response.body().getDoctorName());
//                            bg.setText(response.body().getBloodGroup());
//                            gender.setText(response.body().getGender());
//                            contact.setText(response.body().getContactNumber());
//                            dob.setText(response.body().getDateOfBirth());
//                            bt.setText(response.body().getBloodType());
//                            nid.setText(response.body().getNid());
//                            appointdate.setText(response.body().getAppointDate());
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<Appointment> call, Throwable t) {
//                        t.printStackTrace();
//                    }
//                });
//
//            }
//        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedid = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectedid);
                int selectedidbt = bt.getCheckedRadioButtonId();
               btbutton = findViewById(selectedidbt);
                int selectedidbg = bg.getCheckedRadioButtonId();
                bgbutton = findViewById(selectedidbg);
               Appointment a = new Appointment();
                a.setPatientName(pname.getText().toString());
                a.setAppointDate(dateappointtext.getText().toString());
                a.setBloodGroup(bgbutton.getText().toString());
                a.setBloodType(btbutton.getText().toString());
                a.setContactNumber(contact.getText().toString());
                a.setDateOfBirth(dob.getText().toString());
                a.setDoctorName(spinner.getSelectedItem().toString());
                a.setEmail(email.getText().toString());
                a.setGender(radioButton.getText().toString());
                a.setNid(nid.getText().toString());
                AppointService appointService = AppointClient.getRetrofitInstance().create(AppointService.class);
                appointService.insertAppointment(a).enqueue(new Callback<Appointment>() {
                    @Override
                    public void onResponse(Call<Appointment> call, Response<Appointment> response) {
alertbuilder = new AlertDialog.Builder(AppointActivity.this);
alertbuilder.setTitle("Appoinment Successfull");
                        alertbuilder.setMessage("Your Id is " + response.body().getAppointId());
                        alertbuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                        AlertDialog alertDialog = alertbuilder.create();
                        alertDialog.show();

                    }

                    @Override
                    public void onFailure(Call<Appointment> call, Throwable t) {

                    }
                });
            }
        });

    }


    public void getAllAppoints() {
        AppointService appointService = AppointClient.getRetrofitInstance().create(AppointService.class);
        appointService.getAllAppoints().enqueue(new Callback<List<Appointment>>() {
            @Override
            public void onResponse(Call<List<Appointment>> call, Response<List<Appointment>> response) {
                appoinment = (ArrayList<Appointment>) response.body();
                System.out.println("Size...." + appoinment.size());

            }

            @Override
            public void onFailure(Call<List<Appointment>> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.appointdatebuttonid){
            DatePicker datePicker = new DatePicker(this);
            int currentDay=datePicker.getDayOfMonth();
            int currentMonth=datePicker.getMonth();
            int currentYear=datePicker.getYear();

            datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            dateappointtext.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                        }
                    },currentYear,currentMonth,currentDay);
            datePickerDialog.show();
        }
        if(v.getId()==R.id.dobbutton){
            DatePicker datePicker = new DatePicker(this);
            int currentDay=datePicker.getDayOfMonth();
            int currentMonth=datePicker.getMonth();
            int currentYear=datePicker.getYear();

            datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            dob.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                        }
                    },currentYear,currentMonth,currentDay);
            datePickerDialog.show();
        }
    }

}


