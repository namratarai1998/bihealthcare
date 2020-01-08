package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.healthcare.R;

import java.util.ArrayList;

import model.PatientModel;
import setting.RecyclerTouchListener;

public class PatientListAdapter extends RecyclerView.Adapter<PatientListAdapter.MyHolder> {

    RecyclerTouchListeners recyclerTouchListener;
    public interface RecyclerTouchListeners{
        void onClickItem(View v,int position);
    }


    Context context;
    LayoutInflater inflater;
    ArrayList<PatientModel> patientModels;

    public PatientListAdapter(Context context, ArrayList<PatientModel> patientModels) {
        this.context = context;
        this.patientModels = patientModels;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View v = inflater.inflate(R.layout.layout_patient,parent,false);

        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
    holder.txtPatientName.setText(patientModels.get(position).getName());

    }

    public void setOnclickListener(RecyclerTouchListeners listener){
        this.recyclerTouchListener = listener;
    }
    @Override
    public int getItemCount() {
        return patientModels.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView txtPatientName;
        Button btnDischarge,btnViewInfo;

        public MyHolder(@NonNull View view) {
            super(view);
            txtPatientName = view.findViewById(R.id.txtPatientname);
            btnDischarge = view.findViewById(R.id.btnDischarge);
            btnViewInfo = view.findViewById(R.id.btnViewInfo);
            view.setTag(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerTouchListener!=null)recyclerTouchListener.onClickItem(v,getAdapterPosition());
                }
            });
        }

    }
}
