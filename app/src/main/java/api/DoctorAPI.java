package api;

import java.util.List;
import java.util.Map;

import model.DoctorModel;
import model.LoginResponse;
import model.PatientModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DoctorAPI {
    //ladd doctor Data
    @POST("doctor/api/d")
    Call<LoginResponse> addoctorDetail(@Body DoctorModel doctorModel);

    //reteriving all doctor detail
    @GET("doctor/api/d")
    Call<List<DoctorModel>> getdoctorDetail();

    @PUT("doctor/api/d/{did}")
    Call<Void> updatedoctorAPI(@Path("did") int uid, @FieldMap Map<String,String> usermap);

    @DELETE("doctor/api/d/{did}")
    Call<Void> deletedoctorData(@Path("did") int uid);
}
