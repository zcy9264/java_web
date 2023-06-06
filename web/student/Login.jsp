<%--
  Created by IntelliJ IDEA.
  User: 12632
  Date: 2023/6/6
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="../UserServlet" >
    <label>
        userName:
        <input type="text" name="userName"/>
    </label>
    <label>
        password:
        <input type="password" name="password"/>
    </label>
    <input type="submit" value="login"/>
</form>

</body>
</html>
