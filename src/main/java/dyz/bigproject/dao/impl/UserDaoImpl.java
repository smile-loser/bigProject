package dyz.bigproject.dao.impl;

import dyz.bigproject.dao.UserDao;
import dyz.bigproject.daomain.User;
import dyz.bigproject.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查找所有用户
     * @return
     */
    @Override
    public List<User> findAll() {
//        用JDBC操作数据库
        String sql="select * from user;";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }


    /**
     * 根据提交信息创建用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        String sql="insert into user values(null,?,?,?,?,?,?);";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQQ(),user.getEmail());

    }

    /**
     * 根据ID删除
     * @param userId
     */
    @Override
    public void delUser(int userId)
    {
        String sql="delete from user where id=?;";
        template.update(sql,userId);
    }

    /**
     * 更改用户信息
     * @param user
     */
    @Override
    public void updateUser(User user) {
        System.out.println(user.getQQ());
        String sql=" update user set name=?, gender = ?,age=?,address=?,qq=?,email=? where id=?;";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQQ(),user.getEmail(),user.getId());

    }

    /**
     * 根据Id找到那个用户
     * @param id
     * @return
     */

    @Override
    public User findById(String id) {
        /*id时int的但也行*/
        String sql="select * from user  where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    /**
     * 分页操作中实现统计所有记录个数,或根据条件来统计·
     * @return
     * @param condition
     */
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.初始化sql
        String sql="Select count(*) from User where 1=1  ";/*注意拼接时字符串前后的空格，否则没有空格阻拦它们连接在一起就会查询异常*/
        StringBuilder sb=new StringBuilder(sql);/*方便拼接*/
        //2.获得map里面关键字
        Set<String> keySet=condition.keySet();
        //3.定义参数的集合，最后当做？添加template里面
        List<String> params=new ArrayList<>();
        for(String key:keySet)
        {
            //排除掉分页参数currentPage 和rows,但当刚开始从查询所有用户信息页面进入时这两个为空，是服务器为他们赋值，所以一开始没有这两个键
            if("currentPage".equals(key)||"rows".equals(key))
            {
                continue;/*下一个关键词*/
            }
            //获取value
            String value=condition.get(key)[0];/*Map<String, String[]>,name,address,email只有一个参数，键值是数组，所有值在String[0]*/
            if(value!=null&&!"".equals(value))/*==null，是判断对象是否引用了具体的地址，而==“ ”是判断对象引用的地址中所存储的值是否为“”*/
            {
                sb.append("  and "+key+" like  ?  ");/*注意拼接时流出空格*/
                params.add("%"+value+"%");
            }
        }
        //可变参本质上就是数组
        //template.query里面第一个参数是sql语句，第二个是你想要返回的对象具体类型，它会帮你转换
        //第三个至后面是代表？
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }



    /**
     * 在分页操作中找到要展示那一页的所有User信息
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {


        String sql = "select * from user  where 1 = 1 ";

        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }

        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        sql = sb.toString();
       /* System.out.println(sql);
        System.out.println(params);*/

        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}
