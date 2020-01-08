package controller;

import android.app.Activity;

import com.example.healthcare.R;

import api.APISetting;
import api.DoctorAPI;
import api.PatientAPI;
import model.DoctorModel;
import model.LoginResponse;
import model.PatientModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import setting.ShowMessage;

public class DoctorController {
    Activity activity;
//    PatientModel patientModel;

    public DoctorController() {
    }

    public DoctorController(Activity activity) {

        this.activity = activity;
    }

    public void addDoctor(DoctorModel doctorModel) {
        DoctorAPI patientAPI = APISetting.createAPIInstance().create(DoctorAPI.class);
        Call<LoginResponse> registerResponseCall = patientAPI.addoctorDetail(doctorModel);
        registerResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
<<<<<<< HEAD
                    ShowMessage.AlertMessage("Success", "Doctor Detail Added!", R.color.gradient_end_color,     activity);
=======
                    ShowMessage.AlertMessage("Success", "Doctor Detail Added!", R.color.gradient_end_color, activity);
>>>>>>> 35bbf15d520d935c37640b7f9fc86ce9ac2616b5
                } else {
                    ShowMessage.AlertMessage("Not Success", "Doctor detail not added", R.color.gradient_end_color, activity);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                ShowMessage.AlertMessage("Error", "cannot register something went wrong", R.color.gradient_end_color, activity);

            }
        });


    }
}
