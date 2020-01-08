package api;

import java.util.List;
import java.util.Map;

import model.LoginResponse;
import model.PatientModel;
import model.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserAPI {



    @POST("auth/login")
    Call<LoginResponse> loginValidation(@Body UserModel userM);

    //register new user account
//    @FormUrlEncoded
    @POST("user/u")
    Call<LoginResponse> registerNewUserAccount(@Body UserModel userModel);

    //reteriving all patient detail
    @GET("user/api/u")
    Call<List<UserModel>> getPatientDetail();

    @PUT("user/api/u/{pid}")
    Call<Void> updatePatientAPI(@Path("pid") int uid, @FieldMap Map<String,String> usermap);

    @DELETE("user/api/u/{pid}")
    Call<Void> deletePatientData(@Path("pid") int uid);
}
