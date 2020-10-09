package dyz.bigproject.web.Filter;
/**
 * 登录验证的过滤器
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0.强制转换，ServletRequest req不是HttpServletRequest,里面方法不全，所以得强制转换回去
        HttpServletRequest request=(HttpServletRequest)req;

        //1.获取支援请求路径，即从哪个网站来到这个过滤器
        String uri=request.getRequestURI();
        //2.判断是不是从登录页面过来的，或者登录Servlet过来的，不拦截
        //注意，去img加载图片资源，加载验证码也会被过滤器过滤所以要uri.contains("checkCodeServlet")||uri.contains("img")
        if(uri.contains("/login.jsp")||uri.contains("/loginServlet")||uri.contains("checkCodeServlet")||uri.contains("img"))
        {
            chain.doFilter(req,resp);/*放行*/
        }
        else{
            if(request.getSession().getAttribute("isSuccessLogin")!=null)/*有成功登录的session*/
            {
                chain.doFilter(req,resp);/*放行*/
            }
            else{
                request.setAttribute("cc_error","您尚未登录，请先登录");
                request.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
