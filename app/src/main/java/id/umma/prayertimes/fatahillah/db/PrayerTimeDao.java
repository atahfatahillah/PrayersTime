package id.umma.prayertimes.fatahillah.db;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PrayerTimeDao {

    @Query("SELECT * FROM prayertime")
    LiveData<List<PrayerTime>> getPrayerTime();

    @Insert(onConflict = REPLACE)
    void insert(PrayerTime prayerTime);

}
