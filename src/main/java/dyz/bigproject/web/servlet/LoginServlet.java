package dyz.bigproject.web.servlet;

import dyz.bigproject.dao.AdministratorsDao;
import dyz.bigproject.dao.impl.AdministratorsDaoImpl;
import dyz.bigproject.daomain.Administrators;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        封装User对象
        Administrators user = new Administrators();
        String username = request.getParameter("username");
        /*String password = request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);*/
//        用BeanUtils来封装对象，因为参数过多一个一个获取set很麻烦的
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


//        判断验证码是否正确
        HttpSession session = request.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");
        String checkCode = request.getParameter("checkCode");

        //每一次点击登录按钮后 1.失败了重定向后改变验证码  2.成功后按返回，不成功后按返回，验证码是不变的所以要改变它，
        // 所以要删除掉那个session,让它刷新再次提交时再创立验证码的session
        session.removeAttribute("checkCode_session");


//        验证码忽略大小写,！=防止在后退时那个session为空获得字符串为空
        if(checkCode_session!=null&& checkCode_session.equalsIgnoreCase(checkCode))
        {
            //        查找数据库里面是否存在这个用户
            AdministratorsDao loginUser = new AdministratorsDaoImpl();
            Administrators login = loginUser.findIt(user);
            if (login == null) {
//                登录失败，转回之前的网页，这个时候验证码改变了
                request.setAttribute("cc_error","账号或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);

            } else {
//                登录成功应该重定向，重定向两次会话不能用request共享数据，用session共享数据
                request.getSession().setAttribute("username",username);
//                获取虚拟路径，这样好一点
                session.setAttribute("isSuccessLogin",true);
                response.sendRedirect(request.getContextPath()+"/index.jsp");



            }
        }
        else{

            request.setAttribute("cc_error","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);



        }

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
