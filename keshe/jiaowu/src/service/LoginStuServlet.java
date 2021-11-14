package service;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dao.StuDao;
import model.Stu;
@WebServlet("/LoginStuServlet")
public class LoginStuServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("user");
		String password = request.getParameter("passwd");
		String id=request.getParameter("num");
		
	
			
		
		
		Stu stu=StuDao.stulogin(id,username,password);
		if(stu!=null) {
			request.getSession().setAttribute("stu",stu);
			request.getRequestDispatcher("student.jsp").forward(request,response);	
		}
		else {
			request.setAttribute("info", "账号或密码错误");
			request.getRequestDispatcher("message.jsp").forward(request,response);
		}
	}
}
