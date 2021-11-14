package model;

public class StudentScore {
	private String name;
	private String course;
	private String num;
	private String score;
	
	public StudentScore(String num,String name,String course,String  score ) {
		this.name=name;
		this.score=score;
		this.course=course;
		this.num=num;
	}
	public String getName() {
		return name;
	}
	public String getScore() {
		return score;
	}
	public String getNum() {
		return num;
	}
	public String getCourse() {
		return course;
	}
}
