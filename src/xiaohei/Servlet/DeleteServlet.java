package xiaohei.Servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import xiaohei.tools.DBManager;

import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        //连数据库修改
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
