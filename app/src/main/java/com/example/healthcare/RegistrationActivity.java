package com.example.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import controller.RegisterController;
import model.UserModel;
import setting.ErrorPopup;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin,btnSignup,btnRegister;
    private Spinner chooseUserType;
    private UserModel userModel;
    private EditText txtEmail,txtPwd,txtPwdC;
    RegisterController registerController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        btnLogin=findViewById(R.id.btnLogin);
        btnSignup=findViewById(R.id.btnSignup);
        btnRegister=findViewById(R.id.btnRegister);
        txtEmail = findViewById(R.id.txtEmail);
        txtPwd = findViewById(R.id.txtPwd);
        txtPwdC = findViewById(R.id.txtPwdC);
        chooseUserType = findViewById(R.id.spinUsertype);
btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private int counter=0;

    private void registerPatient() {
        if (validation()) {
            return;
        } else {
//            counter++;
            userModel = new UserModel(txtEmail.getText().toString(),
                    txtPwdC.getText().toString(),
                    chooseUserType.getSelectedItem().toString());
            registerController = new RegisterController(RegistrationActivity.this);
            registerController.registerNewUser(userModel);
        }
    }

    private boolean validation() {
        if (TextUtils.isEmpty(txtEmail.getText())) {
            ErrorPopup.errorValidation(txtEmail, "Enter email");
            return true;
        } else if (TextUtils.isEmpty(txtPwdC.getText())) {
           ErrorPopup.errorValidation(txtPwdC, "Enter password");
            return true;
        } else {
            return false;
        }

    }


    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                registerPatient();
                break;
        }
    }
}
