package api;

import java.util.List;
import java.util.Map;

import model.AppointmentModel;
import model.LoginResponse;
import model.PatientModel;
import model.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PatientAPI {
    //ladd patient Data

    @POST("patient/api/p")
    Call<LoginResponse> addPatientDetail(@Body PatientModel patientModel);

    //reteriving all patient detail
    @GET("patient/api/p")
    Call<List<PatientModel>> getPatientDetail();

    @PUT("patient/api/p/{pid}")
    Call<Void> updatePatientAPI(@Path("pid") int uid, @FieldMap Map<String,String> usermap);

    @DELETE("patient/api/p/{pid}")
    Call<Void> deletePatientData(@Path("pid") int uid);


    @GET("patient/api/p/{id}")
    Call<PatientModel> getPatientById(@Path("id") int id);

    @GET("patient/api/p/profile/{name}")
    Call<PatientModel> getPatientProfile(@Path("name") String name);

//    @PUT("patient/api/update/{id}")
//    Call<LoginResponse> updateUserProfile(@Body PatientModel patientModel,@Path("id") int id  );


//    @GET("mobilehealthcare/v1/patient/getappointmenthistory/{id}")
//    Call<List<AppointmentModel>> getAppointmentHistory( @Path("id") int id );



}
