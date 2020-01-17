package com.example.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainPatientActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView bgapp, clover;
    LinearLayout textsplash, texthome, menus, btnViewReport, btnBookAppoint,btnSatisfaction;
    Animation frombottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_patient);
        init();
    }


    private void init() {
        bgapp = findViewById(R.id.bgapp);
        clover = findViewById(R.id.clover);
        textsplash = findViewById(R.id.textsplash);
        texthome = findViewById(R.id.texthome);
        menus = findViewById(R.id.menus);

        btnBookAppoint = findViewById(R.id.liyBookAppoint);
        btnViewReport = findViewById(R.id.liyViewReportPatient);
        btnSatisfaction = findViewById(R.id.liySatisfaction);

        animateDashboardBackground();
    }

    private void animateDashboardBackground() {

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        bgapp.animate().translationY(-1900).setDuration(800).setStartDelay(300);
        clover.animate().alpha(0).setDuration(800).setStartDelay(600);
        textsplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);
        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.liyBookAppoint:
                Intent iiii = new Intent(this, DoctorlistActivity.class);
                startActivity(iiii);
                break;
            case R.id.liyViewReportPatient:
                Intent iii = new Intent(this, PatientlistActivity.class);
                startActivity(iii);
                break;

            case R.id.liySatisfaction:
                Intent iiiii = new Intent(this, PatientsatisfactionActivity.class);
                startActivity(iiiii);
                break;

            default:
                System.out.println("nothing");
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
