package dyz.bigproject.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        验证码图片高/宽
        int width=100;
        int height=50;
//        创建验证码对象
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);/*BufferedImage.TYPE_INT_RGB对象三色*/

//        保存验证码让登录页面提交时能够让服务器识别
        StringBuilder sd=new StringBuilder();
//        美化图片
        //填充粉色背景色
        Graphics g=image.getGraphics();
        g.setColor(Color.pink);
        g.fillRect(0,0,width,height);/*填充*/
        //画框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);
        //随机写四个字母
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random ran=new Random();
        for(int i=0;i<4;i++)//打印字母
        {
            int index=ran.nextInt(str.length());//0-n不包括n
            char ch=str.charAt(index);
            sd.append(ch);
            g.drawString(ch+"",width/5+width/5*i,height/2-3+i*5);
        }

//        sd转化字符串设置成session让服务器识别
        String s = sd.toString();
        HttpSession session = request.getSession();
        session.setAttribute("checkCode_session",s);

        for(int i=0;i<4;i++)
        {
            int x1=ran.nextInt(width);
            int x2=ran.nextInt(width);
            int y1=ran.nextInt(width);
            int y2=ran.nextInt(width);
            g.drawLine(x1,y1,x2,y2);
        }


//        输出图片到页面
        ImageIO.write(image,"jpg",response.getOutputStream());/*jpg是输出这个图片格式*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
