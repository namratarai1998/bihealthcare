package com.example.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.PatientListAdapter;
import api.APISetting;
import api.PatientAPI;
import model.PatientModel;
import model.UserModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import setting.RecyclerTouchListener;
import setting.ShowMessage;

public class PatientlistActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<PatientModel> patientModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientlist);

        recyclerView = findViewById(R.id.patientListRecyclerView);
        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(PatientlistActivity.this));
        loadPatientData();
//        final PatientListAdapter patientListAdapter = new PatientListAdapter(getApplicationContext(), patientModelArrayList);
//        recyclerView.setAdapter(patientListAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                ShowMessage.AlertMessage("Message","One Click",R.color.gradient_end_color,PatientlistActivity.this);
            }

            @Override
            public void onLongClick(View view, int position) {
               ShowMessage.AlertMessage("Message","Long Click",R.color.gradient_end_color,PatientlistActivity.this);
            }
        }));

    }

    private void loadPatientData() {
        PatientAPI patientAPI = APISetting.createAPIInstance().create(PatientAPI.class);
        Call<List<PatientModel>> patientDetailCall = patientAPI.getPatientDetail();
        patientDetailCall.enqueue(new Callback<List<PatientModel>>() {
            @Override
            public void onResponse(Call<List<PatientModel>> call, Response<List<PatientModel>> response) {
                List<PatientModel> patientOnlineDataList = response.body();
                PatientListAdapter patientListAdapter = new PatientListAdapter(PatientlistActivity.this,patientOnlineDataList);
                recyclerView.setAdapter(patientListAdapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PatientlistActivity.this);
                recyclerView.setLayoutManager(linearLayoutManager);
            }
            @Override
            public void onFailure(Call<List<PatientModel>> call, Throwable t) {
                ShowMessage.showMsg(PatientlistActivity.this, t.getMessage());
            }
        });
    }
}
