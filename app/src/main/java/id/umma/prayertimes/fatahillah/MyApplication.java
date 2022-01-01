package id.umma.prayertimes.fatahillah;

import android.app.Application;

import id.umma.prayertimes.fatahillah.di.ApiComponent;
import id.umma.prayertimes.fatahillah.di.ApiModule;
import id.umma.prayertimes.fatahillah.di.DaggerApiComponent;

public class MyApplication extends Application {

    private ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        apiComponent = DaggerApiComponent.builder()
                .apiModule(new ApiModule())
                .build();
    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}
