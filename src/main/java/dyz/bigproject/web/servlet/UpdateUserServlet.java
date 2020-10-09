package dyz.bigproject.web.servlet;

import dyz.bigproject.daomain.User;
import org.apache.commons.beanutils.BeanUtils;
import dyz.bigproject.service.UserService;
import dyz.bigproject.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 来更改用户信息
 */
@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("contentType", "text/html; charset=utf-8");
        //2.获取map
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        User user=new User();
        try{
            BeanUtils.populate(user,map);
        }catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }catch(InvocationTargetException c)
        {
            c.printStackTrace();
        }
        System.out.println(user);
        //4.调用Service修改
        UserService service=new UserServiceImpl();
        service.updateUser(user);

        //5.重定向userListServlet
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
