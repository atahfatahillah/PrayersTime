package id.umma.prayertimes.fatahillah.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Utils {

    private static final String TAG = "Utils";
    
    public static String dateTimeFormat(String datetime, String pattern, Locale locale) {
        String reformattedDateTime = "";
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat fromFormat = new SimpleDateFormat("yyyy-MM-dd");
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat toFormat = new SimpleDateFormat(pattern, locale);
        try {
            reformattedDateTime = toFormat.format(fromFormat.parse(datetime));
        } catch (Exception e) {
            reformattedDateTime = datetime;
        }
        return reformattedDateTime;
    }

}
