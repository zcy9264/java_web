package xiaohei.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import xiaohei.Dao.StudentDAO;
import xiaohei.model.StudentModel;

import java.io.IOException;
import java.util.ArrayList;

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

    @SuppressWarnings("rawtypes")
    protected void doQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentDAO studentDAO = new StudentDAO();
        ArrayList ArrayStudent = studentDAO.QueryStudent();
        request.setAttribute("ArrayStudent", ArrayStudent);
        RequestDispatcher rd = request.getRequestDispatcher("student/Query/query.jsp");
        rd.forward(request, response);
    }

    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String jspScore = request.getParameter("jspScore");

        StudentModel studentModel = new StudentModel();
        studentModel.SetId(id);
        studentModel.SetName(name);
        studentModel.SetAge(age);
        studentModel.SetJspScore(jspScore);

        StudentDAO studentDAO = new StudentDAO();
        boolean flag = studentDAO.AddStudent(studentModel);

        if (flag) {
            response.sendRedirect("student/index.jsp");
        } else {
            System.out.println("���ʧ��");
        }
    }

    protected void doChange(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String jspScore = request.getParameter("jspScore");

        StudentDAO studentDAO = new StudentDAO();
        StudentModel studentModel = new StudentModel();

        studentModel.SetId(id);
        studentModel.SetName(name);
        studentModel.SetAge(age);
        studentModel.SetJspScore(jspScore);

        boolean flag = studentDAO.ChangeStudent(studentModel);
        //��ת
        if (flag) {
            response.sendRedirect("student/index.jsp");
        } else {
            System.out.println("����ʧ��");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        StudentDAO studentDAO = new StudentDAO();
        StudentModel studentModel = new StudentModel();

        studentModel.SetId(id);

        boolean flag = studentDAO.DeleteStudent(studentModel);
        //��ת
        if (flag) {
            response.sendRedirect("student/index.jsp");
        } else {
            System.out.println("ɾ��ʧ��");
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
            System.out.println("ɾ��ʧ��");
        }
    }
}
