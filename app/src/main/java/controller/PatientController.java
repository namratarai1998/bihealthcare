package controller;

import android.app.Activity;

import com.example.healthcare.R;

import api.APISetting;
import api.PatientAPI;
import api.UserAPI;
import model.LoginResponse;
import model.PatientModel;
import model.UserModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import setting.ShowMessage;

public class PatientController {
    Activity activity;
//    PatientModel patientModel;

    public PatientController() {
    }

    public PatientController(Activity activity) {

        this.activity = activity;
    }

    public void addPatient(PatientModel patientModel) {
        PatientAPI patientAPI = APISetting.createAPIInstance().create(PatientAPI.class);
        Call<LoginResponse> registerResponseCall = patientAPI.addPatientDetail(patientModel);
        registerResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    ShowMessage.AlertMessage("Success", "Patient Added!", R.color.gradient_end_color, activity);
                } else {
                    ShowMessage.AlertMessage("Not Success", "Patient detail not added", R.color.gradient_end_color, activity);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                ShowMessage.AlertMessage("Error", "cannot register something went wrong", R.color.gradient_end_color, activity);

            }
        });


    }
}
