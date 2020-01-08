package setting;

public class StrictMode {

    public static void activeMode(){

            android.os.StrictMode.ThreadPolicy threadPolicy = new android.os.StrictMode.ThreadPolicy.Builder().permitAll().build();
            android.os.StrictMode.setThreadPolicy(threadPolicy);

    }
}
