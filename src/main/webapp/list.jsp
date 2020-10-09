<%--
  Created by IntelliJ IDEA.
  User: 25377
  Date: 2020/9/21
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        window.onload=function()
        {
            document.getElementById("delSelected").onclick=function()
            {

                if(confirm("您确定要删除吗?"))
                {
                    document.getElementById("form").submit();
                }


            };


            document.getElementById("firstCb").onclick=function()
            {
                var cbs=document.getElementsByName("selectedId");
                for(var i=0;i<cbs.length;i++)
                {
                    cbs[i].checked=this.checked;/*更换状态*/
                }
            }
        };



        function deleteUser(id)
        {
            if(confirm("您确定要删除吗?"))
            {
                location.href="${pageContext.request.contextPath}/delUserServlet?id="+id+"&currentPage=${pb.currentPage}";
            }
        }
    </script>
</head>
<body>


<%--用过滤器解决<c:if test="${sessionScope.isSuccessLogin!=true}">&lt;%&ndash;没半个小时登陆一次&ndash;%&gt;
    <%
        response.sendRedirect(request.getContextPath()+"/loginServlet");
    %>
</c:if>--%>
<%--///////////////////////////顶层操作键--%>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div>
        <div style="float: left">
            <form class="form-inline"   action="${pageContext.request.contextPath}/findUserByPageServlet" method="get">
                <div class="form-group">
                    <label for="exampleInputName2">名字</label>
                    <input type="text" class="form-control" value="${condition.name[0]}" name="name" id="exampleInputName2">
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail2">籍贯</label>
                    <input type="text" class="form-control" value="${condition.address[0]}" name="address" id="exampleInputEmail2">
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail2">Email</label>
                    <input type="text" class="form-control" value="${condition.email[0]}" name="email"  id="exampleInputEmail3">
                </div>
                <button type="submit" class="btn btn-default">查询</button>
            </form>
        </div>
        <div style="float: right ;margin: 8px;"><%--css行内式样式--%>

            <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
            <a class="btn btn-primary"  href="javascript:void(0)" id="delSelected">删除选中</a>
        </div>
    </div>

<%--///////////////////////////////////展示信息--%>
    <%--用来所有删除勾选的信息--%>
    <form  id="form" action="${pageContext.request.contextPath}/delSelectedServlet?currentPage=${pb.currentPage}"  method="post">

    <table border="1" class="table table-bordered table-striped table-hover">
        <tr class="success">
            <th><input type="checkbox" id="firstCb"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>


        <c:forEach items="${requestScope.pb.list}" var="user" varStatus="s">
            <c:if test="${s.count%2==0}">
                <tr class="success">
            </c:if>
            <c:if test="${s.count%2!=0}">
                <tr class="active">
            </c:if>
            <td><input type="checkbox" id="uid" name="selectedId" value="${user.id}"></td>
            <td>${(pb.currentPage-1)*pb.rows+s.count}</td>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
            <td>${user.address}</td>
            <td>${user.QQ}</td>
            <td>${user.email}</td>

            <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}&currentPage=${pb.currentPage}">修改</a>&nbsp;
                <%--将每行User的id与删除按钮绑定在一起--%>
                <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id});">删除</a></td>

           <%-- ${pageContext.request.contextPath}/delUserServlet?id=${user.id}--%>
            </tr>


        </c:forEach>


    </table>

    </form>

<%--    /////////////////////////////////////分页条--%>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage==1}"><%--让正在第一个分页按钮在上一个按钮时有警示标记，但别人还是可以按，按了后页数变0
                                                        在findUserByPageServlet处理--%>
                    <li class="disabled">
                </c:if>
                <c:if test="${pb.currentPage!=1}">
                    <li>
                </c:if>
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage-1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////--%>
                <c:forEach begin="1" end="${pb.totalPage}" var="i" step="1"><%--根据记录数与每一页的数量生成分页按钮--%>

                    <%--                     class="active"  让正在这一页的按钮按不了--%>

                    <c:if test="${pb.currentPage==i}">

                        <li class="active">
                    </c:if>
                    <c:if test="${pb.currentPage!=i}">

                        <li>
                    </c:if>
                    <a  href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                </c:forEach>


<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////--%>

                    <%--让正在第一页按不了上一页的操作--%>
            <c:if test="${pb.currentPage==pb.totalPage}"><%--让正在最后一个分页按钮按有警示标签，并且分情况跳转--%>
                <li class="disabled">
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>


            <c:if test="${pb.currentPage!=pb.totalPage}">
               <li>
                   <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage+1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                       <span aria-hidden="true">&raquo;</span>
                   </a>
               </li>
            </c:if>

                <span style="font-size: 20px;margin-left: 15px">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                 </span>
            </ul>
        </nav>


    </div>
</div>
</body>
</html>
