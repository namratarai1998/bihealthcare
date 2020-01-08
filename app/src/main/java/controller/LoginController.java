package controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.healthcare.LoginActivity;
import com.example.healthcare.MainActivity;
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

public class LoginController {
    Activity context;
    //    private String useremail;
//    private String password;
    boolean isSuccess = false;
    private static String tempToken = "";
    private static String tempEmail = "";
    UserModel userModel;

    public LoginController(UserModel userModel) {
        this.userModel = userModel;

    }

    public boolean checkLogin() {

        UserAPI patientAPI = APISetting.createAPIInstance().create(UserAPI.class);
        Call<LoginResponse> patientCall = patientAPI.loginValidation(userModel);

        try {
            Response<LoginResponse> res = patientCall.execute();
            if (res.body().isStatus()) {
                tempToken = res.body().getAccessToken();
                tempEmail = res.body().getEmail();
                APISetting.Cookie = tempToken;
                isSuccess = true;
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }


//        patientCall.enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                if (!response.body().isStatus()) {
//                    ShowMessage.AlertMessage("Error", response.body().getMesasge(), R.color.bgColor, context);
//                    return;
//                } else {
//                    System.out.println("true rishav");
//                    isSuccess = true;
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                ShowMessage.AlertMessage("Error", t.getLocalizedMessage(), R.color.bgColor, context);
//            }
//        });
//        UserAPI userAPI = APISetting.createAPIInstance().create(UserAPI.class);
//        Map<String, String> loginMap = new HashMap<>();
//        loginMap.put("email", useremail);
//        loginMap.put("password", password);
//        Call<LoginResponse> loginCall = userAPI.loginValidation(loginMap);
//        try {
//            Response<LoginResponse> res = loginCall.execute();
//            System.out.println(res.body().getUserId());
//            System.out.println(res.body().isStatus());
//            System.out.println(res.body().getMesasge());
//            System.out.println(res.body().getEmail());
////            if (res.body().isStatus()) {
////                tempToken = res.body().getAccessToken();
////                tempEmail = res.body().getEmail();
////                APISetting.Cookie = tempToken;
////                isSuccess = true;
////            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return isSuccess;
//       }
        System.out.println(isSuccess);
        return isSuccess;
    }

    //method for token and email setup for all classes
    public static String getTempToken() {
        return tempToken;
    }

    public static String getTempEmail() {
        return tempEmail;
    }
}
