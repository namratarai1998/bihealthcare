package setting;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class HideSetting {

    public static  void hideTitleBar(Activity activity, AppCompatActivity appCompatActivity){
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);

        appCompatActivity.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
    }


}
