<%@ page import="xiaohei.tools.DBManager" %>
  Created by IntelliJ IDEA.
  User: 12632
  Date: 2023/6/4
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%String path = request.getContextPath(); %>
    <title>删除</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    String sql = "DELETE student where id = '" + id + "'";
    DBManager db = new DBManager();
    int count = db.executeUpdate(sql);

    if (count > 0) {
        response.sendRedirect(path+"/student/Query/query.jsp");
    } else {
        response.sendRedirect(path+"/student/Query/query.jsp");
    }
    db.releaseResource();
%>
</body>
</html>
