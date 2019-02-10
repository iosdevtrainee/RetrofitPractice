package pursuit.iosdevtrainee.com.retrofitpractice.network;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RetrofitSingleton {
    private static Retrofit instance;
    private RetrofitSingleton() { }
    public static Retrofit getInstance(){
        if (instance == null){
            instance = new Retrofit.Builder()
                                .baseUrl("https://api-v2.intrinio.com/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
            return instance;
        }
        return instance;
    }

}
