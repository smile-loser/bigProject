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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("contentType", "text/html; charset=utf-8");
        //2.获取参数
        Map<String,String[]> map=request.getParameterMap();
        System.out.println("名字是       : "+request.getParameter("name"));
        System.out.println(new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8"));
        //封装对象
        User user=new User();
        try{
            BeanUtils.populate(user,map);
        }catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch(InvocationTargetException e)
        {
            e.printStackTrace();
        }

        //4.调用service保存
        UserService service=new UserServiceImpl();
        service.addUser(user);

        //实施添加信息后，刷新时到最后一页的标志
        HttpSession session = request.getSession();
        session.setAttribute("add_flag",true);
        //5.重定向到加载用户信息的Servlet
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
