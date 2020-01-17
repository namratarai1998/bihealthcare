package adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.healthcare.PatientlistActivity;
import com.example.healthcare.R;
import com.example.healthcare.ViewPagerActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import api.APISetting;
import api.PatientAPI;
import fragments.ProfileFragment;
import model.PatientModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import setting.RecyclerTouchListener;
import setting.ShowMessage;

public class PatientListAdapter extends RecyclerView.Adapter<PatientListAdapter.MyHolder> {

    //    RecyclerTouchListeners recyclerTouchListener;
//    public interface RecyclerTouchListeners{
//        void onClickItem(View v,int position);
//    }
    Context context;
    //    LayoutInflater inflater;
    List<PatientModel> patientModels;

    public PatientListAdapter(Context context, List<PatientModel> patientModels) {
//        inflater = LayoutInflater.from(context);
        this.context = context;
        this.patientModels = patientModels;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_patient, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        //     System.out.println(patientModels.get(0).getName());
        holder.txtPatientName.setText(patientModels.get(position).getName());
        holder.btnViewInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                System.out.println(patientModels.get(position).getName());
                PatientAPI patientAPI = APISetting.createAPIInstance().create(PatientAPI.class);
                Call<PatientModel> patientProfileCall = patientAPI.getPatientProfile(patientModels.get(position).getName());

                try {
                    Response<PatientModel> response = patientProfileCall.execute();
                    System.out.println(response.body().getDATES());
                    Intent intent = new Intent(context,
                            ViewPagerActivity.class);

                    intent.putExtra("name", response.body().getName());
                    intent.putExtra("age", response.body().getAge());
                    intent.putExtra("gender", response.body().getGENDER());
                    intent.putExtra("address", response.body().getADDRESS());
                    intent.putExtra("contact", response.body().getCONTACT_NO());
                    intent.putExtra("wardname", response.body().getWard_name());
                    intent.putExtra("dateA", response.body().getDATES());
                    intent.putExtra("summary", response.body().getSummary());
                    intent.putExtra("disease", response.body().getSummary());
                    intent.putExtra("doctorAppoint", response.body().getAppointDoctor());
                    intent.putExtra("discharge", response.body().getDischarge());
                    intent.putExtra("treatment", response.body().getTreatmentby());
                    intent.putExtra("patientype", response.body().getPatient_type());
                    intent.putExtra("staylength", response.body().getStayLength());
                    context.startActivity(intent);

//                System.out.println(response.body().getPatient_id());
//                Bundle bundle = new Bundle();
//                bundle.putString("name", response.body().getName());
//                bundle.putString("gender", response.body().getGENDER());
//                bundle.putString("age", response.body().getAge());
//                ProfileFragment profileFragment = new ProfileFragment();
//                profileFragment.setArguments(bundle);
//                Intent i = new Intent(context, ViewPagerActivity.class);
//                context.startActivity(i);
//                    moment().format();                                // "2019-08-12T17:52:17-05:00" (ISO 8601, no fractional seconds)
//                    moment().format("dddd, MMMM Do YYYY, h:mm:ss a"); // "Monday, August 12th 2019, 5:52:00 pm"
//                    moment().format("ddd, hA");                       // "Mon, 5PM"
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    //    public void setOnclickListener(RecyclerTouchListeners listener){
//        this.recyclerTouchListener = listener;
//    }
    @Override
    public int getItemCount() {
        return patientModels.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView txtPatientName;
        Button btnDischarge, btnViewInfo;

        public MyHolder(@NonNull View view) {
            super(view);
            txtPatientName = view.findViewById(R.id.txtPatientName);
            btnDischarge = view.findViewById(R.id.btnDischarge);
            btnViewInfo = view.findViewById(R.id.btnViewInfo);

//            view.setTag(view);
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(recyclerTouchListener!=null)recyclerTouchListener.onClickItem(v,getAdapterPosition());
//                }
//            });
        }

    }
}
