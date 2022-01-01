package id.umma.prayertimes.fatahillah.di;

import id.umma.prayertimes.fatahillah.models.RootResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServiceInterface {

    @GET("times/today.json")
    Call<RootResponse> getPrayerTimeToday(
            @Query("city") String city
    );

}
