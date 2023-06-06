package xiaohei.Servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import xiaohei.tools.DBManager;

import java.io.IOException;

@WebServlet(name = "DeleteAllServlet", value = "/DeleteAllServlet")
public class DeleteAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //ÅúÁ¿É¾
        String[] ids = request.getParameterValues("stuIds");

        for (String id : ids) {
            String sql = "DELETE student where id = '" + id + "'";
            DBManager db = new DBManager();
            db.executeUpdate(sql);
            db.releaseResource();
        }
        response.sendRedirect("student/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
