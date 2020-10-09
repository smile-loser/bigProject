
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<html >
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <script>
            window.onload=function()
            {
                document.getElementById("getBack").onclick=function()
                {
                    location.href=" ${pageContext.request.contextPath}/findUserByPageServlet";
                }
            }
        </script>

    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改联系人</h3>
        <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">

            <%--设置隐藏的id在提交的时候能提交id--%>
            <input type="hidden" name="id" value="${sessionScope.user.id}"/>

          <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" value="${sessionScope.user.name}"  readonly="readonly" placeholder="请输入姓名" />
          </div>

          <div class="form-group">
<%--              这里可能遇到性别填空的，这些都要在填表提交前限制它们--%>
<%--              redio加上checked就是被选上--%>

            <label>性别：</label>
            <c:if test="${sessionScope.user.gender=='男'}">
                <input type="radio" name="gender" value="男" checked />男
                <input type="radio" name="gender" value="女"  />女

            </c:if>
<%--            test="${sessionScope.user.gender}!='男'是错的--%>
            <c:if test="${sessionScope.user.gender!='男'}">
                <input type="radio" name="gender" value="男"  />男
                <input type="radio" name="gender" value="女" checked />女
            </c:if>

          </div>

          <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" value="${sessionScope.user.age}" id="age"  name="age" placeholder="请输入年龄" />
          </div>

          <div class="form-group">
            <label for="address">籍贯：</label>
              <%--              这里可能遇到籍贯填空的，这些都要在填表提交前限制它们--%>
              <%--              select加上selected就是被选上--%>

             <select name="address" id="address" class="form-control" >
                 <c:if test="${sessionScope.user.address=='广东'}">
                     <option value="广东" selected>广东</option>
                     <option value="广西">广西</option>
                     <option value="湖南">湖南</option>
                 </c:if>
                 <c:if test="${sessionScope.user.address=='广西'}">
                     <option value="广东">广东</option>
                     <option value="广西"  selected>广西</option>
                     <option value="湖南">湖南</option>
                 </c:if>
                 <c:if test="${sessionScope.user.address=='湖南'}">
                     <option value="广东" >广东</option>
                     <option value="广西">广西</option>
                     <option value="湖南" selected>湖南</option>
                 </c:if>
            </select>
          </div>

          <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" value="${sessionScope.user.QQ}" id="qq" name="QQ" placeholder="请输入QQ号码"/>
          </div>

          <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" value="${sessionScope.user.email}" name="email" placeholder="请输入邮箱地址"/>
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit"   value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn-default"  type="button"id="getBack"  value="返回"/>
             </div>
        </form>
        </div>
    </body>
</html>