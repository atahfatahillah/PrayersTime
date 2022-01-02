package id.umma.prayertimes.fatahillah.db;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "prayertime", indices = {@Index(value = {"shalat_code"},
        unique = true)})
public class PrayerTime {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String shalat_code;
    private String shalat_time;

    public PrayerTime(String shalat_code, String shalat_time) {
        this.shalat_code = shalat_code;
        this.shalat_time = shalat_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShalat_code() {
        return shalat_code;
    }

    public void setShalat_code(String shalat_code) {
        this.shalat_code = shalat_code;
    }

    public String getShalat_time() {
        return shalat_time;
    }

    public void setShalat_time(String shalat_time) {
        this.shalat_time = shalat_time;
    }
}
