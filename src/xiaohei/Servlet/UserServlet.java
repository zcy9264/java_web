package xiaohei.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import xiaohei.tools.DBManager;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operate = request.getParameter(("operate"));
        if (operate.equals("doQuery")){
            this.doQuery(request, response);
        }
        if(operate.equals("doAdd")){
            this.doAdd(request, response);
        }
        if(operate.equals("doChange")){
            this.doChange(request, response);
        }
        if(operate.equals("doDelete")){
            this.doDelete(request, response);
        }
        if(operate.equals("doAllDelete")){
            this.doAllDelete(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String jspScore = request.getParameter("jspScore");
        //连数据库修改
        String sql = "insert into student values('" + id + "','" + name + "','" + age + "','" + jspScore + "')";
        DBManager db = new DBManager();
        int count = db.executeUpdate(sql);
        //跳转
        if (count > 0) {
            response.sendRedirect("student/index.jsp");
        } else {
            response.sendRedirect("student/index.jsp");
        }
        db.releaseResource();
    }
    protected void doQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager db = new DBManager();
        ResultSet rs= db.executeQuery("SELECT id,name,age,jspScore FROM student ORDER BY student.id;");
        request.setAttribute("rs", rs);
        RequestDispatcher rd = request.getRequestDispatcher("student/Query/query.jsp");
        rd.forward(request, response);
    }
    protected void doChange(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String jspScore = request.getParameter("jspScore");
        //连数据库修改
        String sql = "UPDATE student SET name = '"+name+"',age = '"+age+"', jspScore = '"+jspScore+"' where id = '"+id+"';";
        DBManager db = new DBManager();
        int count = db.executeUpdate(sql);
        //跳转
        if (count > 0) {
            response.sendRedirect("student/index.jsp");
        } else {
            response.sendRedirect("student/index.jsp");
        }
        db.releaseResource();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String sql = "DELETE student where id = '"+id+"';";
        DBManager db = new DBManager();
        int count = db.executeUpdate(sql);
        //跳转
        if (count > 0) {
            response.sendRedirect("student/index.jsp");
        } else {
            response.sendRedirect("student/index.jsp");
        }
        db.releaseResource();
    }

    protected void doAllDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] ids = request.getParameterValues("stuIds");

        for (String id : ids) {
            String sql = "DELETE student where id = '" + id + "'";
            DBManager db = new DBManager();
            db.executeUpdate(sql);
            db.releaseResource();
        }
        response.sendRedirect("student/index.jsp");
    }

}
