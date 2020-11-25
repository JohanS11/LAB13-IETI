package co.edu.eci.ieti.android.persistence;

import android.app.Application;

import java.util.List;

import co.edu.eci.ieti.android.dao.UserDAO;
import co.edu.eci.ieti.android.network.data.User;
import co.edu.eci.ieti.android.roomdb.WordRoomDatabase;

public class UserRepository {

    private UserDAO userDAO;

    public UserRepository(Application application){
        userDAO = WordRoomDatabase.getDatabase(application).userDAO();
    }

    public List<User> getUsers(){
        return userDAO.getUsers();
    }

    public void addUser(User user){
        userDAO.insert(user);
    }
}
