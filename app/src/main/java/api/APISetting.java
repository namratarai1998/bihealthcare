package api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APISetting {
    public static String Cookie="";
//    public static final String BASE_URL = "https://profession-app.herokuapp.com/";
//    public static final String BASE_URL = "http://172.26.4.22:5000/"; //auth/login   or /patient/api/p / . .
public static final String BASE_URL = "http://192.168.0.111:5000/"; //auth/login   or /patient/api/p / . .
//    public static final String BASE_URL = "http://172.26.2.101:5000/"; //auth/login   or /patient/api/p / . .

    public static Retrofit createAPIInstance()
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }
}
