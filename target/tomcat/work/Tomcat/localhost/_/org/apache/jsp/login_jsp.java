/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-10-05 07:21:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 1. 导入CSS的全局样式 -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<!-- 2. jQuery导入，建议使用1.9以上的版本 -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-2.1.0.min.js\"></script>\r\n");
      out.write("<!-- 3. 导入bootstrap的js文件 -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>注册页面</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        * {\r\n");
      out.write("            margin: 0px;\r\n");
      out.write("            padding: 0px;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        body {\r\n");
      out.write("            background: url(\"img/register_bg.png\") no-repeat center;\r\n");
      out.write("\r\n");
      out.write("            padding-top: 25px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .rg_layout {\r\n");
      out.write("            width: 900px;\r\n");
      out.write("            height: 500px;\r\n");
      out.write("            border: 8px solid #EEEEEE;\r\n");
      out.write("            background-color: white;\r\n");
      out.write("            /*让div水平居中*/\r\n");
      out.write("            margin: auto;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .rg_left {\r\n");
      out.write("            /*border: 1px solid red;*/\r\n");
      out.write("            float: left;\r\n");
      out.write("            margin: 15px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .rg_left > p:first-child {\r\n");
      out.write("            color: #FFD026;\r\n");
      out.write("            font-size: 20px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .rg_left > p:last-child {\r\n");
      out.write("            color: #A6A6A6;\r\n");
      out.write("            font-size: 20px;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .rg_center {\r\n");
      out.write("            float: left;\r\n");
      out.write("            /* border: 1px solid red;*/\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .rg_right {\r\n");
      out.write("            /*border: 1px solid red;*/\r\n");
      out.write("            float: right;\r\n");
      out.write("            margin: 15px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .rg_right > p:first-child {\r\n");
      out.write("            font-size: 15px;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .rg_right p a {\r\n");
      out.write("            color: pink;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        rg_form{\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .td_left {\r\n");
      out.write("            width: 100px;\r\n");
      out.write("            text-align: right;\r\n");
      out.write("            height: 45px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .td_right {\r\n");
      out.write("            padding-left: 50px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #username, #password, #checkCode,#email, #name, #tel, #birthday {\r\n");
      out.write("            width: 251px;\r\n");
      out.write("            height: 32px;\r\n");
      out.write("            border: 1px solid #A6A6A6;\r\n");
      out.write("            /*设置边框圆角*/\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            padding-left: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #checkCode {\r\n");
      out.write("            width:  140px;;\r\n");
      out.write("            height: 34px;\r\n");
      out.write("            border: 1px solid #A6A6A6;\r\n");
      out.write("            /*设置边框圆角*/\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            padding-left: 10px;\r\n");
      out.write("            margin-right: 30px ;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #cc_error{\r\n");
      out.write("            color: red;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("         }\r\n");
      out.write("        #img_check {\r\n");
      out.write("            height: 36px;\r\n");
      out.write("            weighit:56px;\r\n");
      out.write("            vertical-align: middle;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #btn_sub {\r\n");
      out.write("            width: 150px;\r\n");
      out.write("            height: 40px;\r\n");
      out.write("            background-color: #FFD026;\r\n");
      out.write("            border: 1px solid #FFD026;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #td_sub{\r\n");
      out.write("            margin-top: 30px;\r\n");
      out.write("            padding-left: 150px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .error{\r\n");
      out.write("            color:red;\r\n");
      out.write("            vertical-align: middle;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <script>\r\n");
      out.write("        window.onload = function(){\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            var img=document.getElementById(\"img_check\");\r\n");
      out.write("            img.onclick=function()\r\n");
      out.write("            {\r\n");
      out.write("                var date=new Date().getTime();\r\n");
      out.write("                /*因为date是秒数，不会重复*/\r\n");
      out.write("                img.src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/checkCodeServlet?\"+date;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            document.getElementById(\"form\").onsubmit = function(){\r\n");
      out.write("                //验证用户名\r\n");
      out.write("                //验证密码\r\n");
      out.write("                //...\r\n");
      out.write("                //都成功则返回true\r\n");
      out.write("                //\r\n");
      out.write("                return checkUsername() && checkPassword()&&checkCheckCode();\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            document.getElementById(\"username\").onblur = checkUsername;\r\n");
      out.write("            document.getElementById(\"password\").onblur = checkPassword;\r\n");
      out.write("            document.getElementById(\"checkCode\").onblur = checkCheckCode;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function checkUsername(){\r\n");
      out.write("            var username = document.getElementById(\"username\").value;\r\n");
      out.write("            var reg_username = /^\\w{6,12}$/;\r\n");
      out.write("            var flag = reg_username.test(username);\r\n");
      out.write("            var s_username = document.getElementById(\"s_username\");\r\n");
      out.write("            if(flag){\r\n");
      out.write("                s_username.innerHTML = \"<img height='25' width='35' src='img/gou.png'>\"\r\n");
      out.write("            }else{\r\n");
      out.write("                s_username.innerHTML = \"用户名格式有误\";\r\n");
      out.write("            }\r\n");
      out.write("            return flag;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function checkCheckCode(){\r\n");
      out.write("            var checkCode = document.getElementById(\"checkCode\").value;\r\n");
      out.write("            var reg_checkCode = /^\\w{4}$/;\r\n");
      out.write("            var flag = reg_checkCode.test(checkCode);\r\n");
      out.write("            var s_checkCode = document.getElementById(\"s_checkCode\");\r\n");
      out.write("            if(flag){\r\n");
      out.write("                s_checkCode.innerHTML = \"<img height='25' width='35' src='img/gou.png'>\"\r\n");
      out.write("            }else{\r\n");
      out.write("                s_checkCode.innerHTML = \"验证码格式有误\";\r\n");
      out.write("            }\r\n");
      out.write("            return flag;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function checkPassword(){\r\n");
      out.write("            var password = document.getElementById(\"password\").value;\r\n");
      out.write("            var reg_password = /^\\w{6,12}$/;\r\n");
      out.write("            var flag = reg_password.test(password);\r\n");
      out.write("            var s_password = document.getElementById(\"s_password\");\r\n");
      out.write("            if(flag){\r\n");
      out.write("                s_password.innerHTML = \"<img height='25' width='35' src='img/gou.png'>\"\r\n");
      out.write("            }else{\r\n");
      out.write("                s_password.innerHTML = \"密码格式有误\";\r\n");
      out.write("            }\r\n");
      out.write("            return flag;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"rg_layout\">\r\n");
      out.write("    <div class=\"rg_left\">\r\n");
      out.write("        <p>管理员登录</p>\r\n");
      out.write("        <p>USER   LOGIN</p>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"rg_center\">\r\n");
      out.write("        <div class=\"rg_form\">\r\n");
      out.write("            <!--定义表单 form-->\r\n");
      out.write("            <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/loginServlet\" id=\"form\" method=\"get\">\r\n");
      out.write("                <table>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td class=\"td_left\"><label for=\"username\">用户名</label></td>\r\n");
      out.write("                        <td class=\"td_right\">\r\n");
      out.write("                            <input type=\"text\" name=\"username\" id=\"username\" placeholder=\"请输入管理员账号\">\r\n");
      out.write("                            <span id=\"s_username\" class=\"error\"></span><!--用来写提示信息-->\r\n");
      out.write("                        </td>\r\n");
      out.write("\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td class=\"td_left\"><label for=\"password\">密码</label></td>\r\n");
      out.write("                        <td class=\"td_right\">\r\n");
      out.write("                            <input type=\"password\" name=\"password\" id=\"password\" placeholder=\"请输入密码\">\r\n");
      out.write("                            <span id=\"s_password\" class=\"error\"></span>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td class=\"td_left\"><label for=\"checkCode\">验证码</label></td>\r\n");
      out.write("                        <td class=\"td_right\">\r\n");
      out.write("                            <input type=\"text\" name=\"checkCode\" id=\"checkCode\" placeholder=\"请输入验证码\">\r\n");
      out.write("                            <img id=\"img_check\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/checkCodeServlet\" />\r\n");
      out.write("                            <span id=\"s_checkCode\" class=\"error\"></span>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td colspan=\"2\"  id=\"td_sub\"><input type=\"submit\" id=\"btn_sub\" value=\"注册\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /login.jsp(272,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ not empty requestScope.cc_error}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\r\n");
        out.write("            <div  style=\"width: 231px;margin-top: 20px;margin-left: 120px;\"  class=\"alert alert-warning alert-dismissible\" role=\"alert\">\r\n");
        out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" >\r\n");
        out.write("                    <span>&times;</span></button>\r\n");
        out.write("                <strong>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.cc_error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("</strong>\r\n");
        out.write("            </div>\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}