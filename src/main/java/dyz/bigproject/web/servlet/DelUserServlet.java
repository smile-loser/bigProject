package dyz.bigproject.web.servlet;

import dyz.bigproject.service.UserService;
import dyz.bigproject.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取要删除的User的id
        String id = request.getParameter("id");
        int userId=Integer.parseInt(id);
        //2.调用service删除
        UserService service=new UserServiceImpl();
        service.delUser(userId);
        //设置两个session,一个当前页，一个标识来只能使用一次，没有表示从Parameter来获得currentPage
        HttpSession session = request.getSession();
        session.setAttribute("se_currentPage",request.getParameter("currentPage"));
        session.setAttribute("flag",true);
        //3.删除完后重定向回列表查看画面
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
