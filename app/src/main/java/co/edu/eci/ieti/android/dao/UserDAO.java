package co.edu.eci.ieti.android.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import co.edu.eci.ieti.android.network.data.User;

public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);

    @Query("SELECT * FROM user")
    List<User> getUsers();

    @Delete
    void delete(User user);
}
