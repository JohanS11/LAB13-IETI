package co.edu.eci.ieti.android.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import co.edu.eci.ieti.android.dao.TaskDAO;
import co.edu.eci.ieti.android.dao.UserDAO;
import co.edu.eci.ieti.android.network.data.Task;
import co.edu.eci.ieti.android.network.data.User;

@Database(entities = {Task.class, User.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();
    public abstract TaskDAO taskDAO();

    private static volatile WordRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "task_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
