package id.umma.prayertimes.fatahillah.db;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PrayerTimeRepo {

    private PrayerTimeDao prayerTimeDao;
    private LiveData<List<PrayerTime>> prayerTimeLists;

    public PrayerTimeRepo(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        prayerTimeDao = db.prayerTimeDao();
        prayerTimeLists = prayerTimeDao.getPrayerTime();
    }

    public LiveData<List<PrayerTime>> getPrayerTimeLists() {
        return prayerTimeLists;
    }

    public void insert(PrayerTime prayerTime) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            prayerTimeDao.insert(prayerTime);
        });
    }
}
