package dyz.bigproject.dao.impl;

import dyz.bigproject.dao.AdministratorsDao;
import dyz.bigproject.daomain.Administrators;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import dyz.bigproject.util.JDBCUtils;

public class AdministratorsDaoImpl implements AdministratorsDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Administrators findIt(Administrators loginUser) {
//        用JDBC操作数据库
        try{

            String sql="Select * from Administrators where username=? and password=?;";
            Administrators  user=template.queryForObject(sql,new BeanPropertyRowMapper<Administrators>(Administrators.class),
                    loginUser.getUsername(),loginUser.getPassword());
            System.out.println("------------------");
            return user;
        }catch(Exception e)
        {
            System.out.println("账号或密码错误");
            return null;
        }
    }
}
