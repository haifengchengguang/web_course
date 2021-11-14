package dao;
import java.sql.*;
import java.util.*;
import model.*;
import utils.DBUtils;

public class StuDao {
	public static Stu stulogin(String id,String name,String password){
		Connection conn=DBUtils.getConnection();
		String sql="select * from student where id = ? and password = ? and name=?";
		Stu stu=null;
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2,password);
			ps.setString(3,name);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			stu=new Stu(rs.getString("id"),rs.getString("name"),rs.getString("password"));

			}
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return stu;
	}
	public static StuInformation query_student(String id){
		Connection conn=DBUtils.getConnection();
		String sql="select * from studentinf where num=?";
		StuInformation stu=null;
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
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
			}
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return stu;
	}
	public static boolean change_Student(String id,String usedpassword,String password){
			Connection conn=DBUtils.getConnection();
			String sql="select * from student where id=? and password=?";
			try {
				PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1,id);
				ps.setString(2, usedpassword);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					
				}
				else {
					return false;
				}
				sql="update student set id=?, password=? where id=?";
				ps=(PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1,id);
				ps.setString(2, password);
				ps.setString(3, id);
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
	public static ArrayList<StudentCourse> query_student_course(String id) {
		Connection conn=DBUtils.getConnection();
		String sql="select * from choose where id=?";
		ArrayList<StudentCourse> course=new ArrayList<StudentCourse>();
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			ArrayList<String> a=new ArrayList<String>();
			if(rs.next()) {
				a.add(rs.getString("courseid"));
				while(rs.next()) {
					a.add(rs.getString("courseid"));
				}
			}
			else {
				return null;
			}
			
			sql="select * from course where id=?";
			ps=(PreparedStatement)conn.prepareStatement(sql);
			for(String i : a) {
				ps.setString(1, i);
				rs=ps.executeQuery();
				rs.next();
				StudentCourse s=new StudentCourse(rs.getString("id"),rs.getString("name"),rs.getString("teacher"),rs.getString("score"),rs.getString("time"),rs.getString("place"));
				course.add(s);
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
	public static ArrayList<StudentScore>query_student_score(String id){
		Connection conn=DBUtils.getConnection();
		String sql="select * from score where id=?";
		ArrayList<StudentScore> score=new ArrayList<StudentScore>();
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				StudentScore s=new StudentScore(rs.getString("id"),rs.getString("name"),rs.getString("course"),rs.getString("score"));
				score.add(s);
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
	public static ArrayList<Achievement> query_student_achievement(String id){
		Connection conn=DBUtils.getConnection();
		String sql="select * from achievement where id=?";
		ArrayList<Achievement> achievement=new ArrayList<Achievement>();
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
		
			while(rs.next()) {
				Achievement s=new Achievement(rs.getString("id"),rs.getString("name"),rs.getString("time"),rs.getString("detail"));
				achievement.add(s);
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
	public static ArrayList<StudentCourse> query_all_course(){
		Connection conn=DBUtils.getConnection();
		String sql="select * from course";
		ArrayList<StudentCourse> course=new ArrayList<StudentCourse>();
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				StudentCourse s=new StudentCourse(rs.getString("id"),rs.getString("name"),rs.getString("teacher"),rs.getString("score"),rs.getString("time"),rs.getString("place"));
				course.add(s);
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
	public static boolean insert_course(String id,String courseid) {
		Connection conn=DBUtils.getConnection();
		String sql="select * from choose where id=? and courseid=?";
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2, courseid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return false;
			}
			else {				
			}
			sql="insert into choose values(?,?)";
			 	ps=(PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2,courseid );
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
	public static boolean delete_course(String id,String courseid) {
		Connection conn=DBUtils.getConnection();
		String sql="delete from choose where id=? and courseid=?";
		try {
			PreparedStatement ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2, courseid);
			ps.execute();
			ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
	}finally {
		DBUtils.closeConnection(conn);
	}
		return true;
	}
	
}
