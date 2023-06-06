package xiaohei.Servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import xiaohei.tools.DBManager;

import java.io.IOException;
import java.io.Serial;

@WebServlet(name = "ChangeServlet", value = "/ChangeServlet")
public class ChangeServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    public ChangeServlet() {
        super();
        //TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String jspScore = request.getParameter("jspScore");
        //连数据库修改
        String sql = "UPDATE student SET name = '"+name+"',age = '"+age+"', jspScore = '"+jspScore+"' where id = '"+id+"';";
        System.out.println(sql);
        DBManager db = new DBManager();
        int count = db.executeUpdate(sql);
        //跳转
        if (count > 0) {
            response.sendRedirect("student/Query/query.jsp");
        } else {
            response.sendRedirect("student/Query/query.jsp");
        }
        db.releaseResource();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
