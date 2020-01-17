package com.example.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import controller.PatientController;
import controller.RegisterController;
import model.PatientModel;
import model.UserModel;

public class AddpatientActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnAddpatient;
    private ImageButton btnNext;
    private EditText etName, etAge, etAddress, etContact, etDate,etSummary;

    private Spinner spinGender, spinWard,spinPatientType;
    private PatientModel patientModel;
    private PatientController patientController;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        btnAddpatient = findViewById(R.id.btnAddpatient);
        btnNext = findViewById(R.id.btnNext);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etAddress = findViewById(R.id.etAddress);
        etContact = findViewById(R.id.etContact);
        etSummary = findViewById(R.id.etSummary  );
        spinWard = findViewById(R.id.spinWard);
        spinGender = findViewById(R.id.spinGender);
        spinPatientType = findViewById(R.id.spinPatientType);
        btnAddpatient.setOnClickListener(this);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddpatientActivity.this, PatientlistActivity.class);
                startActivity(intent);
            }
        });


    }

    private void registerPatient() {

//        if (validation()) {
//            return;
//        } else {
//        counter++;
        String patientName=etName.getText().toString();
        String patientAge = etAge.getText().toString();
        String patientAddress= etAddress.getText().toString();
        String patientContact = etContact.getText().toString();
        String patientWard = spinWard.getSelectedItem().toString();
        String patientType = spinPatientType.getSelectedItem().toString();
        String patientGender= spinGender.getSelectedItem().toString();
        String patientSummary= etSummary.getText().toString();
        patientModel = new PatientModel(patientName, patientAddress,patientAge,patientGender,patientContact,patientWard,patientType,patientSummary);
        patientController = new PatientController(AddpatientActivity.this);
        patientController.addPatient(patientModel);
//        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddpatient:
                registerPatient();
                break;
        }
    }
}
