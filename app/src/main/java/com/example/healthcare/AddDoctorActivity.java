package com.example.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import controller.DoctorController;
import controller.PatientController;
import model.DoctorModel;
import model.PatientModel;

public class AddDoctorActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnAdddoctor;
    private ImageButton btnNext;
    private EditText etDoctorname, etContactno, etAddress, etEmail, etQualification, etSpecification;
    private DoctorController doctorController;
    private DoctorModel doctorModel;
    private int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);

        btnAdddoctor = findViewById(R.id.btnAdddoctor);
        btnNext = findViewById(R.id.btnNext);
        etDoctorname = findViewById(R.id.etDoctorname);
        etContactno = findViewById(R.id.etContactno);
        etAddress = findViewById(R.id.etAddress);
        etEmail = findViewById(R.id.etEmail);
        etQualification = findViewById(R.id.etQualification);
        etSpecification = findViewById(R.id.etSpecification);
btnAdddoctor.setOnClickListener(this);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddDoctorActivity.this, DoctorlistActivity.class);
            }
        });

    }


    private void registerDoctorDetail() {

//        if (validation()) {
//            return;
//        } else {
        counter++;
        String doctor_Name=      etDoctorname.getText().toString();
        String doctor_contact = etContactno.getText().toString();
        String doctor_address=  etAddress.getText().toString();
        String doctor_email =   etEmail.getText().toString();
        String qualification=   etQualification.getText().toString();
        String specification=   etSpecification.getText().toString();
        doctorModel = new DoctorModel(counter,doctor_Name,doctor_contact,doctor_address,doctor_email,qualification,specification);
        doctorController = new DoctorController(AddDoctorActivity.this);
        doctorController.addDoctor(doctorModel);
//        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdddoctor:
                registerDoctorDetail();
                break;
        }
    }
}
