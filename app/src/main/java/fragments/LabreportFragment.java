package fragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.healthcare.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LabreportFragment extends Fragment implements View.OnClickListener {

    EditText etDatePicker;
    DatePicker datePicker;
    public LabreportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_labreport, container, false);
        etDatePicker = view.findViewById(R.id.etDatepicker);
        etDatePicker.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.etDatepicker:
                DialogFragment newfDialogFragment = new DatePickerFragment();
                newfDialogFragment.show(getActivity().getSupportFragmentManager(),"date picker");
                break;
        }
    }
}
