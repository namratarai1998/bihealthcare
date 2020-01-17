package fragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.healthcare.R;

import controller.ReportController;
import model.ReportModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class LabreportFragment extends Fragment implements View.OnClickListener {

    EditText etDatePicker;
    DatePicker datePicker;
    EditText txtMaxBP,txtMinBP,txtGLevel;
    Button btnAddReport;
    ReportModel reportModel;
    ReportController reportController;
    public LabreportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_labreport, container, false);
        etDatePicker = view.findViewById(R.id.etDatepicker);
        txtMinBP = view.findViewById(R.id.txtMinBP);
        txtMaxBP = view.findViewById(R.id.txtMaxBP);
        txtGLevel = view.findViewById(R.id.txtGLevel);
        btnAddReport = view.findViewById(R.id.btnAddReport);
        etDatePicker.setEnabled(false);
        etDatePicker.setOnClickListener(this);
        btnAddReport.setOnClickListener(this);

        return view;
    }

    public void addReportFromActivity(){
       int maxbp=Integer.parseInt(txtMaxBP.getText().toString());
       int minbp =Integer.parseInt(txtMinBP.getText().toString());
       int glucoselevel= Integer.parseInt(txtGLevel.getText().toString());
       int patientid = 11;

        reportModel = new ReportModel(maxbp,minbp,glucoselevel,patientid);
        reportController = new ReportController(getActivity());
        reportController.addReportFromController(reportModel);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.etDatepicker:
                DialogFragment newfDialogFragment = new DatePickerFragment();
                newfDialogFragment.show(getActivity().getSupportFragmentManager(),"date picker");
                break;
            case R.id.btnAddReport:
              addReportFromActivity();
                 break;

        }
    }
}
