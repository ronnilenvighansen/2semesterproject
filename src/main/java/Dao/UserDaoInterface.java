package Dao;

import Model.User;

import java.util.List;

/**
 * Created by Ronni on 13-12-2016.
 */
public interface UserDaoInterface {
    public void createUser(String role, String username, String password, String email, int bought_items, int location);
    public void deleteUser(int user_id);
    public void updateUser(User user);
    public List<User> getAllUsers();
    public User getUserById(int userId);
    public boolean userLogin(String username, String password);
    public boolean adminLogin(String username, String password);
}
