package id.umma.prayertimes.fatahillah.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    private static final String TAG = "ApiModule";
    private static final String PRAYER_TIME_API_URL = "https://api.pray.zone/v2/";

    @Provides
    @Singleton
    public ApiServiceInterface getApiInstannce(Retrofit retrofit) {
        return retrofit.create(ApiServiceInterface.class);
    }

    @Singleton
    @Provides
    public Retrofit getRetrofitInstance() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PRAYER_TIME_API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}
