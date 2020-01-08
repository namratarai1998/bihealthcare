package com.example.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

<<<<<<< HEAD
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

=======
public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
>>>>>>> 35bbf15d520d935c37640b7f9fc86ce9ac2616b5

    ImageView bgapp, clover, imgNotification,imgSatisfaction, imgSearchProfession;
    LinearLayout textsplash, texthome, menus, btnAppointment;
    Animation frombottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        bgapp = findViewById(R.id.bgapp);
        clover = findViewById(R.id.clover);
        textsplash = findViewById(R.id.textsplash);
        texthome = findViewById(R.id.texthome);
        menus = findViewById(R.id.menus);


        imgSatisfaction = findViewById(R.id.imgSatisfaction);
        imgNotification = findViewById(R.id.imgNotification);
        imgSearchProfession = findViewById(R.id.imgSearchProfession);
        btnAppointment = findViewById(R.id.btnAppointment);


        imgNotification.setOnClickListener(this);
        imgSatisfaction.setOnClickListener(this);
        imgSearchProfession.setOnClickListener(this);
        btnAppointment.setOnClickListener(this);
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
            case R.id.imgNotification:
//                Intent i = new Intent(this, UpdateUserProfileActivity.class);
//                startActivity(i);
                break;
            case R.id.btnAppointment:
//                Intent ii = new Intent(this, SettingActivity.class);
//                startActivity/(ii);
                break;
            case R.id.imgSearchProfession:
//                Intent iii = new Intent(this, ProfessionMapActivity.class);
//                startActivity(iii);
                break;
<<<<<<< HEAD
            case R.id.imgSatisfaction:
=======
                case R.id.imgSatisfaction:
>>>>>>> 35bbf15d520d935c37640b7f9fc86ce9ac2616b5
                Intent iiii = new Intent(this, PatientVisualization.class);
                startActivity(iiii);
                break;

            default:
                System.out.println("nothing");
        }

    }
}
