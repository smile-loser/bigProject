package dyz.bigproject.web.servlet;

import dyz.bigproject.daomain.User;
import dyz.bigproject.service.UserService;
import dyz.bigproject.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 在修改User信息时充当中转站
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //1.获取ID
        String id=request.getParameter("id");
        //2.调用Service查询
        UserService service=new UserServiceImpl();
        User user=service.findUserById(id);
        //3.将user存进request
        request.getSession().setAttribute("user",user);
        //设置两个session,一个当前页，一个标识来只能使用一次，没有表示从Parameter来获得currentPage
        HttpSession session = request.getSession();
        session.setAttribute("se_currentPage",request.getParameter("currentPage"));
        session.setAttribute("flag",true);
        //4.重定向到update.jsp
        response.sendRedirect(request.getContextPath()+"/update.jsp");




    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
