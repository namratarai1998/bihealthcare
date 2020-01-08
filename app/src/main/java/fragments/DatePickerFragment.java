package fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),dateSetListener,year,month,day);
    }

    private DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener(){

                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    Toast.makeText(getActivity(),"Selected data is",Toast.LENGTH_LONG).show();
                }

    };
}
