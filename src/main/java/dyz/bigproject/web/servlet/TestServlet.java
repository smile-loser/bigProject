package dyz.bigproject.web.servlet;

import dyz.bigproject.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        /*String msg = request.getParameter("msg");
        System.out.println(msg);*/
        Map<String, String[]> map = request.getParameterMap();
        Set<String> keys = map.keySet();
        for(String s:keys)
        {
            String[] values = map.get(s);
            System.out.print(s+"   :");
            for(String v:values)
            {
                System.out.print("   "+v+"    ");
            }
            System.out.println();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
