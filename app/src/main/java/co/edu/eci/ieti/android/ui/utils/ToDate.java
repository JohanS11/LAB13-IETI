package co.edu.eci.ieti.android.ui.utils;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.Date;

public class ToDate {

    @TypeConverter
    public static Date toDate(Long timestamp){
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}

