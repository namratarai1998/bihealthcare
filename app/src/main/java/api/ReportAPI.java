package api;

import java.util.List;
import java.util.Map;

import model.LoginResponse;
import model.PatientModel;
import model.ReportModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ReportAPI {

    //ladd patient Data

    @POST("patient/api/p/report")
    Call<LoginResponse> addReport(@Body ReportModel reportModel);

    //reteriving all patient detail
    @GET("patient/api/p/report")
    Call<List<ReportModel>> getReportDetailOfPatient();

    @PUT("patient/api/p/{pid}")
    Call<Void> updateReport(@Path("pid") int uid, @FieldMap Map<String,String> usermap);

}
