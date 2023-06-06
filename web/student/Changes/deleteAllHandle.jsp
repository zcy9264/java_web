<%@ page import="xiaohei.tools.DBManager" %><%--
  Created by IntelliJ IDEA.
  User: 12632
  Date: 2023/6/4
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>批量删除操作</title>
</head>
<body>
<%
    //批量删
    String[] ids = request.getParameterValues("stuIds");

    for (String id : ids) {
        String sql = "DELETE student where id = '" + id + "'";
        DBManager db = new DBManager();
        db.executeUpdate(sql);
        db.releaseResource();
    }
    response.sendRedirect("../Query/query.jsp");
%>
</body>
</html>
