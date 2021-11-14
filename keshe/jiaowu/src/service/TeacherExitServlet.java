package service;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@WebServlet("/TeacherExitServlet")
public class TeacherExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取Session
		HttpSession session = request.getSession();
		session.invalidate();
		//转发到login.html页面
		response.sendRedirect("loginteacher.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}