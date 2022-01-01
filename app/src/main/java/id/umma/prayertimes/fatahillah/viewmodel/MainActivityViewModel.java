package id.umma.prayertimes.fatahillah.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import id.umma.prayertimes.fatahillah.MyApplication;
import id.umma.prayertimes.fatahillah.di.ApiServiceInterface;
import id.umma.prayertimes.fatahillah.models.RootResponse;
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

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        ((MyApplication)application).getApiComponent()
                .inject(MainActivityViewModel.this);
        mutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<RootResponse> getMutableLiveData() {
        return mutableLiveData;
    }

    public void makeApiCall() {
        Log.d(TAG, "makeApiCall: called");
        Call<RootResponse> call = serviceInterface.getPrayerTimeToday(
                "jakarta");
        call.enqueue(new Callback<RootResponse>() {
            @Override
            public void onResponse(Call<RootResponse> call, Response<RootResponse> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.postValue(response.body());
                } else {
                    mutableLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<RootResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
                mutableLiveData.postValue(null);
            }
        });
    }
}
