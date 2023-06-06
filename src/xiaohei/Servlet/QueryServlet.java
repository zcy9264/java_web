package xiaohei.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import xiaohei.tools.DBManager;

import java.io.IOException;
import java.io.Serial;
import java.sql.ResultSet;

@WebServlet(name = "QueryServlet", value = "/QueryServlet")
public class QueryServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    public QueryServlet() {
        // TODO Auto-generated method stub
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void  doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        // TODO Auto-generated method stub
        DBManager db = new DBManager();
        ResultSet rs= db.executeQuery("select * from student");
        request.setAttribute("rs", rs);
        RequestDispatcher rd = request.getRequestDispatcher("student/Query/query.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
