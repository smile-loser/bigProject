package dyz.bigproject.service;

import dyz.bigproject.daomain.PageBean;
import dyz.bigproject.daomain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/*用户管理的业务接口*/
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();
    public void addUser(User user);
    public void delUser(int UserId);
    public void updateUser(User user);

    public  User findUserById(String id);

    public void delSelectedUsers(String[] ids);

    public  PageBean<User> findUsersByPage(String currentPage, String rows, Map<String, String[]> condition, HttpServletRequest request);
}
