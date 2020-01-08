package controller;

import android.app.Activity;

import com.example.healthcare.R;

import java.util.HashMap;
import java.util.Map;

import api.APISetting;
import api.UserAPI;
import model.LoginResponse;
import model.UserModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import setting.ShowMessage;

public class RegisterController {

    Activity activity;

    public RegisterController() {
    }

    public RegisterController(  Activity activity) {

        this.activity = activity;
    }

    public void registerNewUser(UserModel userModel) {

        UserAPI userAPI = APISetting.createAPIInstance().create(UserAPI.class);
        Call<LoginResponse> registerResponseCall = userAPI.registerNewUserAccount(userModel);
        registerResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    ShowMessage.AlertMessage("Success", "Registration Done!", R.color.gradient_end_color, activity);
                } else {
                    ShowMessage.AlertMessage("Not Success", "Failed! Check\n Email|Username", R.color.gradient_end_color, activity);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                ShowMessage.AlertMessage("Error", "cannot register something went wrong", R.color.gradient_end_color, activity);

            }
        });


    }

}
