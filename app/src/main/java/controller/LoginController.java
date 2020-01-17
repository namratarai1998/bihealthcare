package controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.healthcare.LoginActivity;
import com.example.healthcare.MainActivity;
import com.example.healthcare.MainNurseActivity;
import com.example.healthcare.MainPatientActivity;
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
    boolean isNurse = false;
    boolean isDoctor = false;
    boolean isUser = false;
    private static String tempToken = "";
    private static String tempEmail = "";
    private static int tempUserId = 0;
    UserModel userModel;

    public LoginController(UserModel userModel) {
        this.userModel = userModel;

    }
    public LoginController(Context context,UserModel userModel) {
        this.userModel = userModel;

    }

    public boolean checkLogin() {
        UserAPI patientAPI = APISetting.createAPIInstance().create(UserAPI.class);
        Call<LoginResponse> patientCall = patientAPI.loginValidation(userModel);
        try {
            Response<LoginResponse> res = patientCall.execute();
            if (res.body().isStatus()) {
                String type = res.body().getUsertype();
                System.out.println(res.body().getAccessToken());
                    System.out.println(res.body().getUsertype());
                tempToken = res.body().getAccessToken();
                tempEmail = res.body().getEmail();
                tempUserId = res.body().getUserId();
                APISetting.Cookie = tempToken;
                if(type.equals("Doctor")){
                   isDoctor=true;
                   isSuccess=true;
                }else if(type.equals("Nurse")){
                    isNurse=true;
                    isSuccess=true;
                }else if(type.equals("User")){
                    isUser=true;
                    isSuccess=true;
                }
                return isSuccess;
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public boolean isNurse() {
        return isNurse;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }

    public void setNurse(boolean nurse) {
        isNurse = nurse;
    }

    public boolean isDoctor() {
        return isDoctor;
    }

    public void setDoctor(boolean doctor) {
        isDoctor = doctor;
    }

    //method for token and email setup for all classes
    public static String getTempToken() {
        return tempToken;
    }

    public static String getTempEmail() {
        return tempEmail;
    }
}
