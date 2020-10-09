<%--
  Created by IntelliJ IDEA.
  User: 25377
  Date: 2020/9/20
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 1. 导入CSS的全局样式 -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<!-- 2. jQuery导入，建议使用1.9以上的版本 -->
<script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
<!-- 3. 导入bootstrap的js文件 -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>


<html>
<head>
    <title>注册页面</title>
    <style>
        * {
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
        }

        body {
            background: url("img/register_bg.png") no-repeat center;

            padding-top: 25px;
        }

        .rg_layout {
            width: 900px;
            height: 500px;
            border: 8px solid #EEEEEE;
            background-color: white;
            /*让div水平居中*/
            margin: auto;
        }

        .rg_left {
            /*border: 1px solid red;*/
            float: left;
            margin: 15px;
        }

        .rg_left > p:first-child {
            color: #FFD026;
            font-size: 20px;
        }

        .rg_left > p:last-child {
            color: #A6A6A6;
            font-size: 20px;

        }

        .rg_center {
            float: left;
            /* border: 1px solid red;*/

        }

        .rg_right {
            /*border: 1px solid red;*/
            float: right;
            margin: 15px;
        }

        .rg_right > p:first-child {
            font-size: 15px;

        }

        .rg_right p a {
            color: pink;
        }

        rg_form{
            text-align: center;
        }

        .td_left {
            width: 100px;
            text-align: right;
            height: 45px;
        }

        .td_right {
            padding-left: 50px;
        }

        #username, #password, #checkCode,#email, #name, #tel, #birthday {
            width: 251px;
            height: 32px;
            border: 1px solid #A6A6A6;
            /*设置边框圆角*/
            border-radius: 5px;
            padding-left: 10px;
        }

        #checkCode {
            width:  140px;;
            height: 34px;
            border: 1px solid #A6A6A6;
            /*设置边框圆角*/
            border-radius: 5px;
            padding-left: 10px;
            margin-right: 30px ;

        }

        #cc_error{
            color: red;
            font-size: 16px;
         }
        #img_check {
            height: 36px;
            weighit:56px;
            vertical-align: middle;
        }

        #btn_sub {
            width: 150px;
            height: 40px;
            background-color: #FFD026;
            border: 1px solid #FFD026;
        }

        #td_sub{
            margin-top: 30px;
            padding-left: 150px;
        }

        .error{
            color:red;
            vertical-align: middle;
        }
    </style>
    <script>
        window.onload = function(){


            var img=document.getElementById("img_check");
            img.onclick=function()
            {
                var date=new Date().getTime();
                /*因为date是秒数，不会重复*/
                img.src="${pageContext.request.contextPath}/checkCodeServlet?"+date;
            }



            document.getElementById("form").onsubmit = function(){
                //验证用户名
                //验证密码
                //...
                //都成功则返回true
                //
                return checkUsername() && checkPassword()&&checkCheckCode();
            }

            document.getElementById("username").onblur = checkUsername;
            document.getElementById("password").onblur = checkPassword;
            document.getElementById("checkCode").onblur = checkCheckCode;
        }

        function checkUsername(){
            var username = document.getElementById("username").value;
            var reg_username = /^\w{6,12}$/;
            var flag = reg_username.test(username);
            var s_username = document.getElementById("s_username");
            if(flag){
                s_username.innerHTML = "<img height='25' width='35' src='img/gou.png'>"
            }else{
                s_username.innerHTML = "用户名格式有误";
            }
            return flag;
        }

        function checkCheckCode(){
            var checkCode = document.getElementById("checkCode").value;
            var reg_checkCode = /^\w{4}$/;
            var flag = reg_checkCode.test(checkCode);
            var s_checkCode = document.getElementById("s_checkCode");
            if(flag){
                s_checkCode.innerHTML = "<img height='25' width='35' src='img/gou.png'>"
            }else{
                s_checkCode.innerHTML = "验证码格式有误";
            }
            return flag;
        }

        function checkPassword(){
            var password = document.getElementById("password").value;
            var reg_password = /^\w{6,12}$/;
            var flag = reg_password.test(password);
            var s_password = document.getElementById("s_password");
            if(flag){
                s_password.innerHTML = "<img height='25' width='35' src='img/gou.png'>"
            }else{
                s_password.innerHTML = "密码格式有误";
            }
            return flag;
        }

    </script>
</head>
<body>



<div class="rg_layout">
    <div class="rg_left">
        <p>管理员登录</p>
        <p>USER   LOGIN</p>

    </div>

    <div class="rg_center">
        <div class="rg_form">
            <!--定义表单 form-->
            <form action="${pageContext.request.contextPath}/loginServlet" id="form" method="get">
                <table>
                    <tr>
                        <td class="td_left"><label for="username">用户名</label></td>
                        <td class="td_right">
                            <input type="text" name="username" id="username" placeholder="请输入管理员账号">
                            <span id="s_username" class="error"></span><!--用来写提示信息-->
                        </td>

                    </tr>

                    <tr>
                        <td class="td_left"><label for="password">密码</label></td>
                        <td class="td_right">
                            <input type="password" name="password" id="password" placeholder="请输入密码">
                            <span id="s_password" class="error"></span>
                        </td>
                    </tr>



                    <tr>
                        <td class="td_left"><label for="checkCode">验证码</label></td>
                        <td class="td_right">
                            <input type="text" name="checkCode" id="checkCode" placeholder="请输入验证码">
                            <img id="img_check" src="${pageContext.request.contextPath}/checkCodeServlet" />
                            <span id="s_checkCode" class="error"></span>
                        </td>
                    </tr>








                    <tr>
                        <td colspan="2"  id="td_sub"><input type="submit" id="btn_sub" value="注册"></td>
                    </tr>
                </table>


            </form>


<%--            验证码，用户名，密码输入错误时的提示信息--%>
            <c:if test="${ not empty requestScope.cc_error}">

            <div  style="width: 231px;margin-top: 20px;margin-left: 120px;"  class="alert alert-warning alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" >
                    <span>&times;</span></button>
                <strong>${requestScope.cc_error}</strong>
            </div>
            </c:if>


        </div>

    </div>




</div>

</body>
</html>
