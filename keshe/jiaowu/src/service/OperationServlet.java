package service;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dao.*;
import model.*;
@WebServlet("/OperationServlet")
public class OperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String action;//瀛樺偍鎿嶄綔鎻忚堪
	//鎺ユ敹璇锋眰
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		action = request.getParameter("action");
		//鍒ゆ柇鎵�鎵ц鎿嶄綔
		switch (action) {
			case "query_student":query_student(request, response);break;
			case"query_all_course":query_all_course(request,response);break;
			case"change_student":change_student(request,response);break;
			case"query_student_course":query_student_course(request,response);break;
			case"query_student_score":query_student_score(request,response);break;
			case"query_student_achievement":query_student_achievement(request,response);break;
			case"insert_course":insert_course(request,response);break;
			case"delete_course":delete_course(request,response);break;
			default:break;
		}
		
		//鐢ㄦ埛鎿嶄綔
	}
	//鏌ヨ鎵�鏈夊鐢�
	protected void query_student(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			String id = request.getParameter("id");
			StuInformation result = StuDao.query_student(id);
			PrintWriter out = response.getWriter();
			//杈撳嚭缁撴灉
			if(result != null){
				out.write("<div class='all'>");
				out.write("<div><span class='self'>学号</span><span class=self>"+result.getNum()+"</span></div>");
				
					out.write("<div>");
					out.write("<span class='self'>姓名</span>");
					out.write("<span class='self'>"+result.getName()+"</span>");
					out.write("</div>");
					out.write("<div>");
					out.write("<span class='self'>校园卡号</span>");
					out.write("<span class='self'>"+result.getCard()+"</span>");
					out.write("</div>");
					out.write("<div>");
					out.write("<span class='self'>性别</span>");
					out.write("<span class='self'>"+result.getSex()+"</span>");
					out.write("</div>");
					out.write("<div>");
					out.write("<span class='self'>生日</span>");
					out.write("<span class='self'>"+result.getBirth()+"</span>");
					out.write("</div>");
					out.write("<div>");
					out.write("<span class='self'>年龄</span>");
					out.write("<span class='self'>"+result.getAge()+"</span>");
					out.write("</div>");
					out.write("<div>");
					out.write("<span class='self'>民族</span>");
					out.write("<span class='self'>"+result.getMinZu()+"</span>");
					out.write("</div>");
					out.write("<div>");
					out.write("<span class='self'>班级</span>");
					out.write("<span class='self'>"+result.getOfClass()+"</span>");
					out.write("</div>");
					out.write("<div>");
					out.write("<span class='self'>院系</span>");
					out.write("<span class='self'>"+result.getYuanXi()+"</span>");
					out.write("</div>");
			}
			
			out.flush();
			out.close();
	}
	protected void query_all_course(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		ArrayList<StudentCourse> result = StuDao.query_all_course();
		PrintWriter out = response.getWriter();
		//杈撳嚭缁撴灉
		if(result != null){
			out.write("<div class='all'>");
			out.write("<div><span>课程号</span><span>课程名</span><span>教师</span><span>学分</span><span>上课时间</span><span>上课地点</span><span></span></div>");
			for (StudentCourse i : result) {
				out.write("<div>");
				out.write("<span>" + i.getNum() + "</span>");
				out.write("<span>" + i.getName() + "</span>");
				out.write("<span>" + i.getTeacher() + "</span>");
				out.write("<span>" + i.getScore() + "</span>");
				out.write("<span>" + i.getTime() + "</span>");
				out.write("<span>" + i.getPlace() + "</span>");
				out.write("<span><a onclick=\"insert_course('" +i.getNum()+"')\">选课</a></span>");
				out.write("</div>");
			}
			out.write("</div>");
			
		}
		else {
			out.write("<div class='error'>");
			out.write("<div>娌℃湁璇剧▼</div>");
			out.write("</div>");
		}
		
		out.flush();
		out.close();
	}
	protected void change_student(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String usedPassword=request.getParameter("pastpassword");
		String password=request.getParameter("nowpassword");
		boolean b = StuDao.change_Student(id,usedPassword,password);
		PrintWriter out = response.getWriter();
		//杈撳嚭缁撴灉
		String info;
		if (b) {
			info = "修改成功";
		} else {
			info = "密码错误";
		}
		out.write("<div class='error'>");
		out.write("<div>" + info + "</div>");
		out.write("</div>");
		
		out.flush();
		out.close();
	}
	protected void query_student_course(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		ArrayList<StudentCourse> result = StuDao.query_student_course(id);
		PrintWriter out = response.getWriter();
		//杈撳嚭缁撴灉
		if(result != null){
			out.write("<div class='all'>");
			out.write("<div><span>课程号</span><span>课程名</span><span>教师</span><span>学分</span><span>上课时间</span><span>上课地点</span><span></span></div>");
			for (StudentCourse i : result) {
				out.write("<div>");
				out.write("<span>" + i.getNum() + "</span>");
				out.write("<span>" + i.getName() + "</span>");
				out.write("<span>" + i.getTeacher() + "</span>");
				out.write("<span>" + i.getScore() + "</span>");
				out.write("<span>" + i.getTime() + "</span>");
				out.write("<span>" + i.getPlace() + "</span>");
				out.write("<span><a onclick=\"delete_course('" +i.getNum()+"')\">退选</a></span>");
				out.write("</div>");
			}
			out.write("</div>");
			
		}
		else {
			out.write("<div class='error'>");
			out.write("<div>娌℃湁閫夎</div>");
			out.write("</div>");
		}
		
		out.flush();
		out.close();
	}
	protected void query_student_score(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		ArrayList<StudentScore> result = StuDao.query_student_score(id);
		PrintWriter out = response.getWriter();
		//杈撳嚭缁撴灉
		if(result != null){
			out.write("<div class='all'>");
			out.write("<div><span>课程</span><span>成绩</span></div>");
			for (StudentScore i : result) {
				out.write("<div>");
				out.write("<span>" + i.getCourse() + "</span>");
				out.write("<span>" + i.getScore() + "</span>");
				out.write("</div>");
			}
			out.write("</div>");
			
		}
		else {
			out.write("<div class='error'>");
			out.write("<div>娌℃湁鎴愮哗</div>");
			out.write("</div>");
		}
		
		out.flush();
		out.close();
	}
	protected void query_student_achievement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		ArrayList<Achievement> result = StuDao.query_student_achievement(id);
		PrintWriter out = response.getWriter();
		//杈撳嚭缁撴灉
		if(result != null){
			out.write("<div class='all'>");
			out.write("<div><span>社会成果名称</span><span>时间</span><span>详情</span></div>");
			for (Achievement i : result) {
				out.write("<div>");
				out.write("<span>" + i.getName() + "</span>");
				out.write("<span>" + i.getTime() + "</span>");
				out.write("<span>" + i.getDetail() + "</span>");
				out.write("</div>");
			}
			out.write("</div>");
			
		}
		else {
			out.write("<div class='error'>");
			out.write("<div>娌℃湁绀句細鎴愭灉</div>");
			out.write("</div>");
		}
		
		out.flush();
		out.close();
	}
	protected void insert_course(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String courseid=request.getParameter("courseid");
		boolean b = StuDao.insert_course(id,courseid);
		PrintWriter out = response.getWriter();
		//杈撳嚭缁撴灉
		String info;
		if (b) {
			info = "选课成功";
		} else {
			info = "不能重复选一门课";
		}
		out.write("<div class='error'>");
		out.write("<div>" + info + "</div>");
		out.write("</div>");
		
		out.flush();
		out.close();
	}
	protected void delete_course(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String courseid=request.getParameter("courseid");
		boolean b = StuDao.delete_course(id,courseid);
		PrintWriter out = response.getWriter();
		//杈撳嚭缁撴灉
		String info;
		if (b) {
			info = "退选成功";
		} else {
			info = "閿欒";
		}
		out.write("<div class='error'>");
		out.write("<div>" + info + "</div>");
		out.write("</div>");
		out.flush();
		out.close();
	}
	
}
