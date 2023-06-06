package xiaohei.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import xiaohei.Dao.StudentDAO;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operate = request.getParameter(("operate"));
        if (operate.equals("doQuery")) {
            this.doQuery(request, response);
        }
        if (operate.equals("doAdd")) {
            this.doAdd(request, response);
        }
        if (operate.equals("doChange")) {
            this.doChange(request, response);
        }
        if (operate.equals("doDelete")) {
            this.doDelete(request, response);
        }
        if (operate.equals("doAllDelete")) {
            this.doAllDelete(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentDAO studentDAO = new StudentDAO();
        ResultSet rs = studentDAO.QueryStudent();
        request.setAttribute("rs", rs);

        RequestDispatcher rd = request.getRequestDispatcher("student/Query/query.jsp");
        rd.forward(request, response);
    }

    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String jspScore = request.getParameter("jspScore");

        StudentDAO studentDAO = new StudentDAO();
        boolean flag = studentDAO.AddStudent(id, name, age, jspScore);

        if (flag) {
            response.sendRedirect("student/index.jsp");
        } else {
            System.out.println("Ìí¼ÓÊ§°Ü");
        }
    }

    protected void doChange(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String jspScore = request.getParameter("jspScore");

        StudentDAO studentDAO = new StudentDAO();
        boolean flag = studentDAO.ChangeStudent(id, name, age, jspScore);
        //Ìø×ª
        if (flag) {
            response.sendRedirect("student/index.jsp");
        } else {
            System.out.println("¸ü¸ÄÊ§°Ü");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        StudentDAO studentDAO = new StudentDAO();
        boolean flag = studentDAO.DeleteStudent(id);
        //Ìø×ª
        if (flag) {
            response.sendRedirect("student/index.jsp");
        } else {
            System.out.println("É¾³ýÊ§°Ü");
        }
    }

    protected void doAllDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] ids = request.getParameterValues("stuIds");
        StudentDAO studentDAO = new StudentDAO();
        boolean flag = studentDAO.AllDeleteStudent(ids);
        if (flag) {
            response.sendRedirect("student/index.jsp");
        }
        else {
            System.out.println("É¾³ýÊ§°Ü");
        }
    }
}
