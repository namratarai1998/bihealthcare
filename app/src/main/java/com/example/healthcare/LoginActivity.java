package com.example.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import api.APISetting;
import api.UserAPI;
import controller.LoginController;
import model.LoginResponse;
import model.UserModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import setting.ShowMessage;
import setting.StrictMode;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {
    private Button btnLogins, btnLoginAction, btnSignup;
    private EditText txtUserEmail, txtUserPassword;
    private LoginController loginController;
    private UserModel usermodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogins = findViewById(R.id.btnLogins);
        btnLoginAction = findViewById(R.id.btnLoginAction);
        txtUserEmail = findViewById(R.id.txtLoginEmail);
        txtUserPassword = findViewById(R.id.txtLoginPwd);
        btnSignup = findViewById(R.id.btnSignup);
        btnLoginAction.setOnClickListener(this);
        btnSignup.setOnClickListener(this);
        txtUserEmail.setText("namrata@gmail.com");
        txtUserPassword.setText("Namra1");
<<<<<<< HEAD
=======

>>>>>>> 35bbf15d520d935c37640b7f9fc86ce9ac2616b5
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            android.os.StrictMode.ThreadPolicy threadPolicy = new android.os.StrictMode.ThreadPolicy.Builder().permitAll().build();
            android.os.StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLoginAction:
<<<<<<< HEAD
                doLogin();
=======
//                doLogin();
                Intent i = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(i);

>>>>>>> 35bbf15d520d935c37640b7f9fc86ce9ac2616b5
                break;
            case R.id.btnSignup:
                openActivity(RegistrationActivity.class);
                break;
            default:
        }
    }
<<<<<<< HEAD

    private void doLogin() {
        try {
            //Test Phase
            Intent i = new Intent(this, PatientlistActivity.class);
            startActivity(i);

//            if (validation()) {
//                return;
//            } else {
//                usermodel =  new UserModel(0,txtUserEmail.getText().toString(),
//                        txtUserPassword.getText().toString(),null);
//                loginController = new LoginController(usermodel);
//                if (loginController.checkLogin()) {
//                    Intent i = new Intent(this, MainActivity.class);
//                    startActivity(i);
//                } else {
//                    ShowMessage.AlertMessage("Error", "Not loged in", R.color.bgColor, this);
//                }
//            }
        } catch (Exception e) {
            ShowMessage.AlertMessage("Error", "Failed", R.color.bgColor, this);
        }
    }

=======

    private void doLogin() {
        try {
            if (validation()) {
                return;
            } else {
                usermodel =  new UserModel(0,txtUserEmail.getText().toString(),
                        txtUserPassword.getText().toString(),null);
                loginController = new LoginController(usermodel);
                if (loginController.checkLogin()) {
                    Intent i = new Intent(this, AddDoctorActivity.class);
                    startActivity(i);
                } else {
                    ShowMessage.AlertMessage("Error", "Not loged in", R.color.bgColor, this);
                }
            }
        } catch (Exception e) {
            ShowMessage.AlertMessage("Error", "Failed", R.color.bgColor, this);
        }
    }

>>>>>>> 35bbf15d520d935c37640b7f9fc86ce9ac2616b5
    private boolean validation() {
        if (TextUtils.isEmpty(txtUserEmail.getText().toString())) {
            errorValidation(txtUserEmail, "Enter email address");
            ShowMessage.AlertMessage("Fill the field", "Email and password", R.color.bgColor, this);
            return true;
        } else if (TextUtils.isEmpty(txtUserPassword.getText().toString())) {
            errorValidation(txtUserPassword, "Enter correct password ");
            ShowMessage.AlertMessage("Fill the field", "Email and password", R.color.bgColor, this);
            return true;
        }
        return false;
    }

   static private void errorValidation(EditText editText, String msg) {
        editText.setFocusableInTouchMode(true);
        editText.setFocusable(true);
        editText.requestFocus();
        editText.setError(msg);
    }

    private void openActivity(Class className) {
        Intent intent = new Intent(this, className);
        startActivity(intent);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return false;
    }
}
