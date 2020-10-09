package dyz.bigproject.dao;

import dyz.bigproject.daomain.User;

import java.util.List;
import java.util.Map;

/**
 *用户操作的dao
 */
public interface UserDao {
    public List<User> findAll();
    public void addUser(User user);
    public void delUser(int userId);
    public void updateUser(User user);

    public User findById(String id);

    public int findTotalCount(Map<String, String[]> condition);

    public List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
