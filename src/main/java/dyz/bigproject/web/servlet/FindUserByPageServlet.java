package dyz.bigproject.web.servlet;

import dyz.bigproject.daomain.PageBean;
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
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("contentType", "text/html; charset=utf-8");

        //从原本将所有信息分页查询，到现在将查询条件加上了表单里面的名字，地址，email，
        // 当然那些如果为空就就不拼接在查询语句where 1=1后面
/////////////////////////////////////////////////////////////////////////////////////////////
        HttpSession session = request.getSession();
        String currentPage=null;
        if(session.getAttribute("flag")!=null)/*用来在那些操作后返回之前的页数*/
        {
            if( (boolean) (session.getAttribute("flag")) )
            {
                currentPage = (String)session.getAttribute("se_currentPage");
                session.setAttribute("flag",false);
            }
            else{
                currentPage = request.getParameter(("currentPage"));
            }
            System.out.println("-----------------------------------++++++++++++++++++++++++++++++");
        }
       else{
            currentPage = request.getParameter(("currentPage"));

        }

        //1.获取参数,当空参时，将currentPage为1,rows=5
        String rows = request.getParameter("rows");

        System.out.println("currentPage:      "+currentPage+"    row:      "+rows);
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();/*里面有currentPage,rows如何是通过查询按钮还有值可能为空的name, address,email */
        if(currentPage==null||"".equals(currentPage))
        {
            currentPage="1";
        }
        if(currentPage.equals("0"))/*是在第一页点上一页时，导致current=0,把它再变成0*/
        {
            currentPage="1";
        }
        if(rows==null||"".equals(rows))
        {
            rows="5";
        }
     /*   System.out.println(condition.keySet());*/
        //2.调用service查询
        UserService service=new UserServiceImpl();
        PageBean<User> pb=service.findUsersByPage(currentPage,rows,condition,request);
        //3.将PageBean存入request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        //4.转发到list,jsp
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
