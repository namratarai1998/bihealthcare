package fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.healthcare.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    TextView txtName,txtAge,txtGender,txtAddress,txtContact,txtWardName,
            txtDoctorAppoint,txtReasonForAdmit,txtDiagnose,txtTreatMentTaken,txtPatientType,txtDateAdmit,txtDischargeDate,txtStayLength;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
//        String name = getArguments().getString("name");
        Intent intent = getActivity().getIntent();
        init(view);
        txtName.setText("Name: "+intent.getStringExtra("name"));
        txtAge.setText("Age: "+intent.getStringExtra("age"));
        txtGender.setText("Gender: "+intent.getStringExtra("gender"));
        txtAddress.setText("Address: "+intent.getStringExtra("address"));
        txtContact.setText("Contact: "+intent.getStringExtra("contact"));
        txtWardName.setText("Ward: "+intent.getStringExtra("wardname"));
        txtDateAdmit.setText("Admitted: "+intent.getStringExtra("dateA"));
        txtReasonForAdmit.setText("Reason: "+intent.getStringExtra("summary"));
        txtDiagnose.setText(intent.getStringExtra("Disease: "+"disease"));
//        txtDoctorAppoint.setText(intent.getStringExtra("Doctor: "+"doctorAppoint"));
//        txtDischargeDate.setText(intent.getStringExtra("Discharge: "+"discharge"));
//        txtTreatMentTaken.setText(intent.getStringExtra("Treatment: "+"treat"));
        txtPatientType.setText(intent.getStringExtra("Type: "+"patientype"));
//        txtStayLength.setText(intent.getStringExtra("Stay: "+"staylength"));
        return view;
    }

    private void init(View view) {
        txtName = view.findViewById(R.id.tvPatientname);
        txtAge = view.findViewById(R.id.tvAge);
        txtGender = view.findViewById(R.id.tvGender);
        txtAddress = view.findViewById(R.id.tvAddress);
        txtContact = view.findViewById(R.id.tvContact);
        txtDateAdmit = view.findViewById(R.id.tvDateadmitted);
        txtDischargeDate = view.findViewById(R.id.tvDatedischarged);
        txtGender = view.findViewById(R.id.tvDoctorappointed);
        txtReasonForAdmit = view.findViewById(R.id.tvReason);
        txtDiagnose = view.findViewById(R.id.tvDisease);
        txtPatientType = view.findViewById(R.id.tvPatienttype);
        txtWardName = view.findViewById(R.id.tvWard);
        txtStayLength = view.findViewById(R.id.tvStay);
    }



//        etDatePicker = view.findViewById(R.id.etDatepicker);
//        txtMinBP = view.findViewById(R.id.txtMinBP);
//        txtMaxBP = view.findViewById(R.id.txtMaxBP);
//        txtGLevel = view.findViewById(R.id.txtGLevel);
//        btnAddReport = view.findViewById(R.id.btnAddReport);
//        etDatePicker.setEnabled(false);
//        etDatePicker.setOnClickListener(this);
//        btnAddReport.setOnClickListener(this);
}
