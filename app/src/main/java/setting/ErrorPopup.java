package setting;

import android.widget.EditText;

public class ErrorPopup {
    static public void errorValidation(EditText editText, String msg) {
        editText.setFocusableInTouchMode(true);
        editText.setFocusable(true);
        editText.requestFocus();
        editText.setError(msg);
    }
}
