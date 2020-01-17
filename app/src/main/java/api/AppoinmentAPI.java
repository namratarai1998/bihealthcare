package api;

import java.util.List;
import java.util.Map;

import model.LoginResponse;
import model.PatientModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AppoinmentAPI {

    @POST("patient/api/p")
    Call<LoginResponse> addPatientDetail(@Body PatientModel patientModel);

    //reteriving all patient detail
    @GET("patient/api/p")
    Call<List<PatientModel>> getPatientDetail();

    @PUT("patient/api/p/{pid}")
    Call<Void> updatePatientAPI(@Path("pid") int uid, @FieldMap Map<String,String> usermap);

    @DELETE("patient/api/p/{pid}")
    Call<Void> deletePatientData(@Path("pid") int uid);
}
