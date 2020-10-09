package dyz.bigproject.service.impl;

import dyz.bigproject.dao.UserDao;
import dyz.bigproject.dao.impl.UserDaoImpl;
import dyz.bigproject.daomain.PageBean;
import dyz.bigproject.daomain.User;
import dyz.bigproject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();

    @Override
    public List<User> findAll() {
//        调用dao完成查询
        return dao.findAll();
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }
    public void delUser(int userId)
    {
        dao.delUser(userId);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(id);
    }

    @Override
    public void delSelectedUsers(String[] ids) {
        for(String id:ids)
        {
            dao.delUser(Integer.parseInt(id));
        }
    }

    /**
     * 分页查询，可能进行的条件查询再分页查询

     * @return
     */
    @Override
    public PageBean<User> findUsersByPage(String  _currentPage, String _rows, Map<String, String[]> condition, HttpServletRequest request) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows=Integer.parseInt(_rows);
        //1.创建空的PageBean对象
        PageBean<User> pb=new PageBean<User>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.用dao查询总记录数
        int totalCount=dao.findTotalCount(condition);

        pb.setTotalCount(totalCount);
        //5.计算总页码
        int totalPage=(totalCount%rows)==0?totalCount/rows:(totalCount/rows)+1;
        if(currentPage>totalPage)/*当删除这一页最后一个用户信息导致它的currentPage比总页数大*/
        {
            currentPage=totalPage;
            pb.setCurrentPage(totalPage);
        }
        if(request.getSession().getAttribute("add_flag")!=null)
        {
            if((boolean)(request.getSession().getAttribute("add_flag"))==true)/*添加用户时，变到最后一页*/
            {
                request.getSession().setAttribute("add_flag",false);
                currentPage=totalPage;
                pb.setCurrentPage(totalPage);
            }
        }

        pb.setTotalPage(totalPage);
        //4.调用dao查询这一页要展示的List集合
        //计算开始的记录索引
        int start=(currentPage-1)*rows;
        List<User> list=dao.findByPage(start,rows,condition);
        pb.setList(list);


        return pb;
    }
}













