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
    <%String path = request.getContextPath(); %>
    <style>
        @import url(<%=path%>/student/css/Login.css);
    </style>
</head>
<body>

<div class="login_div_1">
    <div class="login_div_2">
        <div class="login_div_3">
            <h1>Sign in to Student</h1>
        </div>

        <div class="login_div_4">
            <form>
                <label>
                    Username or email address
                </label>
                <input type="text" class="login_form_1"/>

                <div class="login_div_5">
                    <label>
                        Password
                    </label>
                    <input type="password" class="login_form_1"/>

                    <input type="submit" value="Sign in" class="login_form_2"/>

                    <a class="login_a_1" tabindex="0" href="#">Forgot password?</a>
                </div>
            </form>
        </div>
        <p class="login_p_1">
            创建新账号？
            <a href="#">Create</a>
        </p>
    </div>
</div>
</body>
</html>
