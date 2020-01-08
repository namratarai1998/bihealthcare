package setting;

import android.app.Activity;
import android.content.Context;

import com.tapadoo.alerter.Alerter;

public class ShowMessage {

    public static void showMsg(Context context,String msg){


    }

    public static void AlertMessage(String title, String msg, int color,final Context c) {
        Alerter.create((Activity) c)
                .setText(msg)
                .setTitle(title)
                .setDuration(800)
                .setBackgroundColor(color).show();
    }

}
