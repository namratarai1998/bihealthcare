package api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APISetting {
    public static String Cookie="";
//    public static final String BASE_URL = "https://profession-app.herokuapp.com/";
<<<<<<< HEAD
    public static final String BASE_URL = "http://172.26.1.204:5000/"; //auth/login   or /patient/api/p / . .
=======
    public static final String BASE_URL = "http://172.26.4.223:5000/"; //auth/login   or /patient/api/p / . .
>>>>>>> 35bbf15d520d935c37640b7f9fc86ce9ac2616b5
    public static Retrofit createAPIInstance()
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }
}
