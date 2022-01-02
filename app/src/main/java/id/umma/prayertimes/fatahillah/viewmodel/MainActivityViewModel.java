package id.umma.prayertimes.fatahillah.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import id.umma.prayertimes.fatahillah.MyApplication;
import id.umma.prayertimes.fatahillah.db.PrayerTime;
import id.umma.prayertimes.fatahillah.db.PrayerTimeRepo;
import id.umma.prayertimes.fatahillah.di.ApiServiceInterface;
import id.umma.prayertimes.fatahillah.models.RootResponse;
import id.umma.prayertimes.fatahillah.models.Times;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {

    private static final String TAG = "MainActivityViewModel";
    
    @Inject
    ApiServiceInterface serviceInterface;
    private MutableLiveData<RootResponse> mutableLiveData;

    private PrayerTimeRepo prayerTimeRepo;
    private LiveData<List<PrayerTime>> prayerTimeList;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        ((MyApplication)application).getApiComponent()
                .inject(MainActivityViewModel.this);
        mutableLiveData = new MutableLiveData<>();
        prayerTimeRepo = new PrayerTimeRepo(application);
        prayerTimeList = prayerTimeRepo.getPrayerTimeLists();
    }

    public MutableLiveData<RootResponse> getMutableLiveData() {
        return mutableLiveData;
    }

    public LiveData<List<PrayerTime>> getPrayerTimeList() {
        return prayerTimeList;
    }

    public void makeApiCall() {
        Call<RootResponse> call = serviceInterface.getPrayerTimeToday(
                "jakarta");
        call.enqueue(new Callback<RootResponse>() {
            @Override
            public void onResponse(Call<RootResponse> call, Response<RootResponse> response) {
                if (response.isSuccessful()) {
                    Times times = response.body().getResults().getDatetime().get(0).getTimes();
                    mutableLiveData.postValue(response.body());

                    prayerTimeRepo.insert(new PrayerTime(
                            "fajr",
                            times.getFajr()
                    ));
                    prayerTimeRepo.insert(new PrayerTime(
                            "dhuhr",
                            times.getDhuhr()
                    ));
                    prayerTimeRepo.insert(new PrayerTime(
                            "asr",
                            times.getAsr()
                    ));
                    prayerTimeRepo.insert(new PrayerTime(
                            "maghrib",
                            times.getMaghrib()
                    ));
                    prayerTimeRepo.insert(new PrayerTime(
                            "isha",
                            times.getIsha()
                    ));
                } else {
                    mutableLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<RootResponse> call, Throwable t) {
                mutableLiveData.postValue(null);
            }
        });
    }
}
