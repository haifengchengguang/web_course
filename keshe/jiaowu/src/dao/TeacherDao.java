package dao;
import java.sql.*;
import java.util.*;
import model.*;
import utils.DBUtils;

public class TeacherDao {
	public static Teacher teacherlogin(String name,String password){
		Connection conn=DBUtils.getConnection();
		String sql="select * from teacher where id = ? and password = ?";
		Teacher teacher=null;
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			teacher=new Teacher(rs.getString("name"),rs.getString("password"));

			}
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return teacher;
	}
	public static ArrayList<StuInformation> query_all_student(){
		Connection conn=DBUtils.getConnection();
		String sql="select * from studentinf";
		ArrayList<StuInformation> student=new ArrayList<StuInformation>();
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			StuInformation stu=new StuInformation();
			stu.setName(rs.getString("name"));
			stu.setAge(rs.getString("age"));
			stu.setSex(rs.getString("sex"));
			stu.setBirth(rs.getString("birth"));
			stu.setNum(rs.getString("num"));
			stu.setMinZu(rs.getString("minzu"));
			stu.setOfClass(rs.getString("class"));
			stu.setYuanXi(rs.getString("yuanxi"));
			stu.setCard(rs.getString("card"));
			student.add(stu);
			while(rs.next()) {
				stu=new StuInformation();
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getString("age"));
				stu.setSex(rs.getString("sex"));
				stu.setBirth(rs.getString("birth"));
				stu.setNum(rs.getString("num"));
				stu.setMinZu(rs.getString("minzu"));
				stu.setOfClass(rs.getString("class"));
				stu.setYuanXi(rs.getString("yuanxi"));
				stu.setCard(rs.getString("card"));
				student.add(stu);
			}
			}
			else {
				return null;
			}
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return student;
	}
	public static boolean insert_student(String id,String name,String password,String card,String sex,String birth,String age,String minzu,String ofClass,String yuanxi){
		Connection conn=DBUtils.getConnection();
		String sql="select * from student where id = ?";

		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return false;
			}
			else {
				
			}
			sql="insert into student values(?,?,?)";
			ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2, password);
			ps.setString(3,name);
			ps.execute();
			sql="insert into studentinf values(?,?,?,?,?,?,?,?,?)";
			ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, card);
			ps.setString(4, sex);
			ps.setString(5, birth);
			ps.setString(6,age);
			ps.setString(7,minzu );
			ps.setString(8,ofClass);
			ps.setString(9,yuanxi);
			ps.execute();
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return true;
	}
	public static boolean delete_student(String id,String name){
		Connection conn=DBUtils.getConnection();
		String sql="select * from student where id = ? and name=?";
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,name);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				sql="delete from student where id=? and name=?";
				ps=(PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, name);
				ps.execute();
				sql="delete from studentinf where num=? and name=?";
				ps=(PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1,id);
				ps.setString(2, name);
				ps.execute();
			}
			else {
				return false;
			}
			
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return true;
	}
	public static boolean change_student(String usedid,String id,String name,String password,String card,String sex,String birth,String age,String minzu,String ofClass,String yuanxi){
		Connection conn=DBUtils.getConnection();
		String sql="select * from student where id = ?";
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,usedid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				sql="update student set id=?, password=?, name=? where id=?";
				ps=(PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, password);
				ps.setString(3, name);
				ps.setString(4,usedid);
				ps.execute();
				sql="update studentinf set num=?, name=?, card=?, sex=?, birth=?, age=?, minzu=?, class=?, yuanxi=? where num=?";
				ps=(PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setString(3,card);
				ps.setString(4, sex);
				ps.setString(5, birth);
				ps.setString(6,age );
				ps.setString(7, minzu);
				ps.setString(8, ofClass);
				ps.setString(9, yuanxi);
				ps.setString(10,usedid);
				ps.execute();
			}
			else {
				return false;
			}
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return true;
	}
	
	public static ArrayList<StudentCourse> query_all_course(){
		Connection conn=DBUtils.getConnection();
		String sql="select * from course";
		ArrayList<StudentCourse> course=new ArrayList<StudentCourse>();
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				StudentCourse s=new StudentCourse(rs.getString("id"),rs.getString("name"),rs.getString("teacher"),rs.getString("score"),rs.getString("time"),rs.getString("place"));
				course.add(s);
				while(rs.next()) {
					s=new StudentCourse(rs.getString("id"),rs.getString("name"),rs.getString("teacher"),rs.getString("score"),rs.getString("time"),rs.getString("place"));
					course.add(s);
				}
			}
			else {
				return null;
			}
			
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return course;
	}
	public static boolean insert_course(String id,String name,String teacher,String score,String time,String place){
		Connection conn=DBUtils.getConnection();
		String sql="select * from course where id = ?";

		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return false;
			}
			else {
				
			}
			sql="insert into course values(?,?,?,?,?,?)";
			ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, teacher);
			ps.setString(4, score);
			ps.setString(5, time);
			ps.setString(6,place);
			ps.execute();
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return true;
	}
	public static boolean delete_course(String id,String name,String teacher){
		Connection conn=DBUtils.getConnection();
		String sql="select * from course where id = ? and name=? and teacher=?";
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setString(3,teacher);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				sql="delete from course where id=? and name=? and teacher=?";
				ps=(PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setString(3, teacher);
				ps.execute();
				sql="delete from choose where courseid=?";
				ps=(PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1,id);
				ps.execute();
			}
			else {
				return false;
			}
			
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return true;
	}
	public static boolean change_course(String usedid,String id,String name,String teacher,String score,String time,String place){
		Connection conn=DBUtils.getConnection();
		String sql="select * from course where id = ?";
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,usedid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				sql="update choose set courseid=? where courseid=?";
				ps=(PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, usedid);
				ps.execute();
				sql="update course set id=?, name=?, teacher=?, score=?, time=?, place=? where id=?";
				ps=(PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setString(3,teacher);
				ps.setString(4, score);
				ps.setString(5, time);
				ps.setString(6,place );
				ps.setString(7, usedid);
				ps.execute();
			}
			else {
				return false;
			}
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return true;
	}
	public static ArrayList<StudentScore> query_all_score(){
		Connection conn=DBUtils.getConnection();
		String sql="select * from score order by course,id";
		ArrayList<StudentScore> score=new ArrayList<StudentScore>();
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				StudentScore s=new StudentScore(rs.getString("id"),rs.getString("name"),rs.getString("course"),rs.getString("score"));
				score.add(s);
				while(rs.next()) {
					s=new StudentScore(rs.getString("id"),rs.getString("name"),rs.getString("course"),rs.getString("score"));
					score.add(s);
				}
			}
			else {
				return null;
			}
			
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return score;
	}
	public static boolean insert_score(String id,String name,String course,String score){
		Connection conn=DBUtils.getConnection();
		String sql="select * from score where id = ? and course=?";

		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,course);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return false;
			}
			else {
				
			}
			sql="insert into score values(?,?,?,?)";
			ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, course);
			ps.setString(4, score);
			ps.execute();
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return true;
	}
	public static boolean delete_score(String id,String name,String course){
		Connection conn=DBUtils.getConnection();
		String sql="select * from score where id = ? and name=? and course=?";
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setString(3,course);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				sql="delete from score where id=? and name=? and course=?";
				ps=(PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setString(3, course);
				ps.execute();
			}
			else {
				return false;
			}
			
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return true;
	}
	public static boolean change_score(String id,String course,String score){
		Connection conn=DBUtils.getConnection();
		String sql="select * from score where id = ? and course=?";
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2, course);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				sql="update score set score=? where id=? and course=?";
				ps=(PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1, score);
				ps.setString(2,course );
				ps.setString(3,course);
				ps.execute();
			}
			else {
				return false;
			}
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return true;
	}
	public static ArrayList<Achievement> query_all_achievement(){
		Connection conn=DBUtils.getConnection();
		String sql="select * from achievement order by id";
		ArrayList<Achievement> achievement=new ArrayList<Achievement>();
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Achievement a=new Achievement(rs.getString("id"),rs.getString("name"),rs.getString("time"),rs.getString("detail"));
				achievement.add(a);
				while(rs.next()) {
					a=new Achievement(rs.getString("id"),rs.getString("name"),rs.getString("time"),rs.getString("detail"));
					achievement.add(a);
				}
			}
			else {
				return null;
			}
			
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return achievement;
	}
	public static boolean insert_achievement(String id,String name,String time,String detail){
		Connection conn=DBUtils.getConnection();
		String sql="select * from achievement where id = ? and name=? and time=? and detail=?";
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setString(3, time);
			ps.setString(4, detail);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return false;
			}
			else {
				
			}
			sql="insert into achievement values(?,?,?,?)";
			ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, time);
			ps.setString(4, detail);
			ps.execute();
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return true;
	}
	public static boolean delete_achievement(String id,String name,String time,String detail){
		Connection conn=DBUtils.getConnection();
		String sql="select * from achievement where id = ? and name=? and time=? and detail=?";
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setString(3,time);
			ps.setString(4, detail);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				sql="delete from achievement where id=? and name=? and time=? and detail=?";
				ps=(PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setString(3, time);
				ps.setString(4, detail);
				ps.execute();
			}
			else {
				return false;
			}
			
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return true;
	}
	public static boolean change_achievement(String id,String name,String usedtime,String useddetail,String time,String detail){
		Connection conn=DBUtils.getConnection();
		String sql="select * from achievement where id = ? and name=? and time=? and detail=?";
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setString(3,usedtime);
			ps.setString(4, useddetail);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				sql="update achievement set id = ?, name=?, time=?, detail=? where time=? and detail=?";
				ps=(PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2,name );
				ps.setString(3,time);
				ps.setString(4,detail);
				ps.setString(5,usedtime);
				ps.setString(6,useddetail);
				ps.execute();
			}
			else {
				return false;
			}
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return true;
	}
	public static ArrayList<Student> query_studentofcourse(String courseid){
		Connection conn=DBUtils.getConnection();
		String sql="select * from choose where courseid=?";
		ArrayList<Student> student=new ArrayList<Student>();
		ArrayList<String> s=new ArrayList<String>();
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,courseid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			String temp=rs.getString("id");
			s.add(temp);
			while(rs.next()) {
				temp=rs.getString("id");
				s.add(temp);
				}
			}
			else {
				return null;
				
			}
			sql="select * from student where id=?";
			ps=(PreparedStatement)conn.prepareStatement(sql);
			for(String i : s) {
				ps.setString(1, i);
				rs=ps.executeQuery();
				rs.next();
				Student stu=new Student(rs.getString("id"),rs.getString("name"));
				student.add(stu);
			}
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return student;
	}
	

}