package service;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dao.*;
import model.*;
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String action;//存储操作描述
	//接收请求
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//判断所执行操作
		action = request.getParameter("action");
		switch (action) {
		
			case"query_all_student":query_all_student(request,response);break;
			case"insert_student":insert_student(request,response);break;
			case"delete_student":delete_student(request,response);break;
			case"change_student":change_student(request,response);break;
			case"query_all_course":query_all_course(request,response);break;
			case"insert_course":insert_course(request,response);break;
			case"delete_course":delete_course(request,response);break;
			case"change_course":change_course(request,response);break;
			case"query_all_score":query_all_score(request,response);break;
			case"insert_score":insert_score(request,response);break;
			case"delete_score":delete_score(request,response);break;
			case"change_score":change_score(request,response);break;
			case"query_all_achievement":query_all_achievement(request,response);break;
			case"insert_achievement":insert_achievement(request,response);break;
			case"delete_achievement":delete_achievement(request,response);break;
			case"change_achievement":change_achievement(request,response);break;
			case"query_studentofcourse":query_studentofcourse(request,response);break;
			default:break;
		}
		
		//用户操作
	}
	//查询所有学生
	protected void query_all_student(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			
			ArrayList<StuInformation> results = TeacherDao.query_all_student();
			PrintWriter out = response.getWriter();
			//输出结果
			if(results != null){
				out.write("<div class='all'>");
				out.write("<div><span class='narrow'>学号</span><span class='narrow'>姓名</span><span class='wide'>身份证</span><span class='narrow'>性别</span><span class='narrow'>出生日期</span><span class='narrow'>年龄</span><span class='narrow'>民族</span><span class='narrow'>班级</span><span  class='narrow'>院系</span></div>");
				for(StuInformation i: results){
					out.write("<div>");
					out.write("<span class='narrow'>"+i.getNum()+"</span>");
					out.write("<span class='narrow'>"+i.getName()+"</span>");
					out.write("<span class='wide'>"+i.getCard()+"</span>");
					out.write("<span class='narrow'>"+i.getSex()+"</span>");
					out.write("<span class='narrow'>"+i.getBirth()+"</span>");
					out.write("<span class='narrow'>"+i.getAge()+"</span>");
					out.write("<span class='narrow'>"+i.getMinZu()+"</span>");
					out.write("<span class='narrow'>"+i.getOfClass()+"</span>");
					out.write("<span class='narrow'>"+i.getYuanXi()+"</span>");
					out.write("</div>");
				}
				out.write("</div>");
			}
			else {
				out.write("<div class='error'>");
				out.write("<div>没有学生信息</div>");
				out.write("</div>");
				
			}
			
			out.flush();
			out.close();
	}
	protected void insert_student(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String card = request.getParameter("card");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String age = request.getParameter("age");
		String minzu = request.getParameter("minzu");
		String ofClass = request.getParameter("ofClass");
		String yuanxi = request.getParameter("yuanxi");
		
		boolean b = TeacherDao.insert_student(id,name,password,card,sex,birth,age,minzu,ofClass,yuanxi);
		PrintWriter out = response.getWriter();
		//输出结果
		String info;
		if (b) {
			info = "插入学生信息成功！";
		} else {
			info = "错误：学生已存在！";
		}
		out.write("<div class='error'>");
		out.write("<div>" + info + "</div>");
		out.write("</div>");
		
		out.flush();
		out.close();
}
	protected void delete_student(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String name=request.getParameter("name");
		boolean b = TeacherDao.delete_student(id,name);
		PrintWriter out = response.getWriter();
		//输出结果
		String info;
		if (b) {
			info = "删除学生成功！";
		} else {
			info = "错误：学生不存在！";
		}
		out.write("<div class='error'>");
		out.write("<div>" + info + "</div>");
		out.write("</div>");
		
		out.flush();
		out.close();
}
	protected void change_student(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String usedid=request.getParameter("usedid");
		String id = request.getParameter("id");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String card = request.getParameter("card");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String age = request.getParameter("age");
		String minzu = request.getParameter("minzu");
		String ofClass = request.getParameter("ofClass");
		String yuanxi = request.getParameter("yuanxi");
		boolean b = TeacherDao.change_student(usedid,id,name,password,card,sex,birth,age,minzu,ofClass,yuanxi);
		PrintWriter out = response.getWriter();
		//输出结果
		
		String info;
		if (b) {
			info = "修改学生信息成功！";
		} else {
			info = "错误：学生不存在！";
		}
		out.write("<div class='error'>");
		out.write("<div>" + info + "</div>");
		out.write("</div>");
		
		out.flush();
		out.close();
}
	
	protected void query_all_course(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		ArrayList<StudentCourse> results = TeacherDao.query_all_course();
		PrintWriter out = response.getWriter();
		//输出结果
		if(results != null){
			out.write("<div class='all'>");
			out.write("<div><span>课程号</span><span>课程名</span><span>老师</span><span>学分</span><span>时间</span><span>地点</span><span></span></div>");
			for(StudentCourse i: results){
				out.write("<div>");
				out.write("<span>"+i.getNum()+"</span>");
				out.write("<span>"+i.getName()+"</span>");
				out.write("<span>"+i.getTeacher()+"</span>");
				out.write("<span>"+i.getScore()+"</span>");
				out.write("<span>"+i.getTime()+"</span>");
				out.write("<span>"+i.getPlace()+"</span>");
				out.write("<span><a onclick=\"query_studentofcourse('" +i.getNum()+"')\">查看选课学生</a></span>");
				out.write("</div>");
			}
			out.write("</div>");
		}
		else {
			out.write("<div class='error'>");
			out.write("<div>没有课程信息</div>");
			out.write("</div>");
			
		}
		
		out.flush();
		out.close();
}
	protected void insert_course(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
			String num=request.getParameter("num");
			String name=request.getParameter("name");
			String teacher=request.getParameter("teacher");
			String score=request.getParameter("score");
			String time=request.getParameter("time");
			String place=request.getParameter("place");
			
		
		boolean b = TeacherDao.insert_course(num,name,teacher,score,time,place);
		PrintWriter out = response.getWriter();
		//输出结果
		String info;
		if (b) {
			info = "插入课程信息成功！";
		} else {
			info = "错误：课程已存在！";
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
		String name=request.getParameter("name");
		String teacher=request.getParameter("teacher");
		boolean b = TeacherDao.delete_course(id,name,teacher);
		PrintWriter out = response.getWriter();
		//输出结果
		String info;
		if (b) {
			info = "删除课程成功！";
		} else {
			info = "错误：课程不存在！";
		}
		out.write("<div class='error'>");
		out.write("<div>" + info + "</div>");
		out.write("</div>");
		
		out.flush();
		out.close();
}
	protected void change_course(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String usedid=request.getParameter("usedid");
		String id = request.getParameter("id");
		String name=request.getParameter("name");
		String teacher=request.getParameter("teacher");
		String score = request.getParameter("score");
		String time = request.getParameter("time");
		String place = request.getParameter("place");
		boolean b = TeacherDao.change_course(usedid,id,name,teacher,score,time,place);
		PrintWriter out = response.getWriter();
		//输出结果
		
		String info;
		if (b) {
			info = "修改课程信息成功！";
		} else {
			info = "错误：课程不存在！";
		}
		out.write("<div class='error'>");
		out.write("<div>" + info + "</div>");
		out.write("</div>");
		
		out.flush();
		out.close();
}
	protected void query_all_score(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		ArrayList<StudentScore> results = TeacherDao.query_all_score();
		PrintWriter out = response.getWriter();
		//输出结果
		if(results != null){
			out.write("<div class='all'>");
			out.write("<div><span>学号</span><span>姓名</span><span>课程</span><span>分数</span></div>");
			for(StudentScore i: results){
				out.write("<div>");
				out.write("<span>"+i.getNum()+"</span>");
				out.write("<span>"+i.getName()+"</span>");
				out.write("<span>"+i.getCourse()+"</span>");
				out.write("<span>"+i.getScore()+"</span>");
				out.write("</div>");
			}
			out.write("</div>");
		}
		else {
			out.write("<div class='error'>");
			out.write("<div>没有成绩信息</div>");
			out.write("</div>");
			
		}
		
		out.flush();
		out.close();
}
	protected void insert_score(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String num=request.getParameter("num");
		String name=request.getParameter("name");
		String course=request.getParameter("course");
		String score=request.getParameter("score");

	boolean b = TeacherDao.insert_score(num,name,course,score);
	PrintWriter out = response.getWriter();
	//输出结果
	String info;
	if (b) {
		info = "插入成绩信息成功！";
	} else {
		info = "错误：成绩已存在！";
	}
	out.write("<div class='error'>");
	out.write("<div>" + info + "</div>");
	out.write("</div>");
	
	out.flush();
	out.close();
}
	protected void delete_score(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String name=request.getParameter("name");
		String course=request.getParameter("course");
		boolean b = TeacherDao.delete_score(id,name,course);
		PrintWriter out = response.getWriter();
		//输出结果
		
		String info;
		if (b) {
			info = "删除成绩信息成功！";
		} else {
			info = "错误：成绩不存在！";
		}
		out.write("<div class='error'>");
		out.write("<div>" + info + "</div>");
		out.write("</div>");
		
		out.flush();
		out.close();
}
	protected void change_score(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String score = request.getParameter("score");
		String course = request.getParameter("course");
		boolean b = TeacherDao.change_score(id,course,score);
		PrintWriter out = response.getWriter();
		//输出结果
		String info;
		if (b) {
			info = "修改成绩信息成功！";
		} else {
			info = "错误：成绩不存在！";
		}
		out.write("<div class='error'>");
		out.write("<div>" + info + "</div>");
		out.write("</div>");
		
		out.flush();
		out.close();
}
	protected void query_all_achievement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");

		ArrayList<Achievement> results = TeacherDao.query_all_achievement();
		PrintWriter out = response.getWriter();
		//输出结果
		if(results != null){
			out.write("<div class='all'>");
			out.write("<div><span>学号</span><span>姓名</span><span>时间</span><span>社会成果</span></div>");
			for(Achievement i: results){
				out.write("<div>");
				out.write("<span>"+i.getNum()+"</span>");
				out.write("<span>"+i.getName()+"</span>");
				out.write("<span>"+i.getTime()+"</span>");
				out.write("<span>"+i.getDetail()+"</span>");
				out.write("</div>");
			}
			out.write("</div>");
		}
		else {
			out.write("<div class='error'>");
			out.write("<div>没有社会成果信息</div>");
			out.write("</div>");
	
		}

		out.flush();
		out.close();
}
	protected void insert_achievement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String time=request.getParameter("time");
		String detail=request.getParameter("detail");

		boolean b = TeacherDao.insert_achievement(id,name,time,detail);
		PrintWriter out = response.getWriter();
		//输出结果
		String info;
		if (b) {
			info = "插入社会成果信息成功！";
		} else {
			info = "错误：社会成果已存在！";
		}
		out.write("<div class='error'>");
		out.write("<div>" + info + "</div>");
		out.write("</div>");
		
		out.flush();
		out.close();
	}
	protected void delete_achievement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String time=request.getParameter("time");
		String detail=request.getParameter("detail");
		boolean b = TeacherDao.delete_achievement(id,name,time,detail);
		PrintWriter out = response.getWriter();
		//输出结果
		
		String info;
		if (b) {
			info = "删除社会成果信息成功！";
		} else {
			info = "错误：社会成果不存在！";
		}
		out.write("<div class='error'>");
		out.write("<div>" + info + "</div>");
		out.write("</div>");
		
		out.flush();
		out.close();
	}
	protected void change_achievement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String usedtime = request.getParameter("usedtime");
		String useddetail = request.getParameter("useddetail");
		String time = request.getParameter("time");
		String detail = request.getParameter("detail");
		boolean b = TeacherDao.change_achievement(id,name,usedtime,useddetail,time,detail);
		PrintWriter out = response.getWriter();
		//输出结果
		
		String info;
		if (b) {
			info = "修改社会成果信息成功！";
		} else {
			info = "错误：社会成果不存在！";
		}
		out.write("<div class='error'>");
		out.write("<div>" + info + "</div>");
		out.write("</div>");
		
		out.flush();
		out.close();
	}
	protected void query_studentofcourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String courseid=request.getParameter("courseid");
		ArrayList<Student> results = TeacherDao.query_studentofcourse(courseid);
		PrintWriter out = response.getWriter();
		//输出结果
		if(results != null){
			out.write("<div class='all'>");
			out.write("<div><span>学号</span><span>姓名</span></div>");
			for(Student i: results){
				out.write("<div>");
				out.write("<span>"+i.getId()+"</span>");
				out.write("<span>"+i.getName()+"</span>");
				out.write("</div>");
			}
			out.write("</div>");
		}
		else {
			out.write("<div class='error'>");
			out.write("<div>无选课学生</div>");
			out.write("</div>");
		}
		
		out.flush();
		out.close();
	}
	
}
