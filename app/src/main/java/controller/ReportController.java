package controller;

import android.app.Activity;

import com.example.healthcare.R;

import api.APISetting;
import api.PatientAPI;
import api.ReportAPI;
import model.LoginResponse;
import model.ReportModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import setting.ShowMessage;

public class ReportController {
    Activity activity;

    public ReportController() {
    }

    public ReportController(Activity activity) {

        this.activity = activity;
    }

    public void addReportFromController(ReportModel reportModel) {
        ReportAPI reportAPI = APISetting.createAPIInstance().create(ReportAPI.class);
        Call<LoginResponse> registerResponseCall = reportAPI.addReport(reportModel);
        registerResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    ShowMessage.AlertMessage("Success", "Report Added!", R.color.gradient_end_color, activity);
                } else {
                    ShowMessage.AlertMessage("Not Success", "Report not added", R.color.gradient_end_color, activity);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                System.out.println(t.getLocalizedMessage());
                ShowMessage.AlertMessage("Error", "something went wrong", R.color.gradient_end_color, activity);

            }
        });


    }
}
