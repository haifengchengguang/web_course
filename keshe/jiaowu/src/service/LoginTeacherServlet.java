package service;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dao.TeacherDao;
import model.Teacher;
@WebServlet("/LoginTeacherServlet")
public class LoginTeacherServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("user");
		String password = request.getParameter("passwd");
		Teacher teacher=TeacherDao.teacherlogin(username,password);
		if(teacher!=null) {
			request.getSession().setAttribute("teacher",teacher);
			request.getRequestDispatcher("teacher.jsp").forward(request,response);	
		}
		else {
			request.setAttribute("info", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
			request.getRequestDispatcher("message.jsp").forward(request,response);
		}
	}
}