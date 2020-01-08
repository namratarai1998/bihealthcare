package com.example.healthcare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

public class DischargeActivity extends AppCompatActivity {
    CheckBox checkbox1, checkbox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discharge);

        checkbox1 = (CheckBox)findViewById(R.id.checkbox1);
        checkbox2 = (CheckBox)findViewById(R.id.checkbox2);

    }
}
