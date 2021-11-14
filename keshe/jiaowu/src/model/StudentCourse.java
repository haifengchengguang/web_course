package model;

public class StudentCourse {
	private String name;
	private String teacher;
	private String time;
	private String place;
	private String score;
	private String num;
	public StudentCourse(String num,String name,String teacher,String score,String time,String place){
		this.name=name;
		this.place=place;
		this.teacher=teacher;
		this.num=num;
		this.time=time;
		this.score=score;
	}
	public String getName() {
		return name;
	}
	public String getTeacher() {
		return teacher;
	}
	public String getPlace() {
		return place;
	}
	public String getTime() {
		return time;
	}
	public String getNum() {
		return num;
	}
	public String getScore() {
		return score;
	}
}
