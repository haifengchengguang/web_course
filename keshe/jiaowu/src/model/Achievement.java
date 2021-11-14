package model;

public class Achievement {
	private String num;
	private String name;
	private String time;
	private String detail;
	public Achievement(String num,String name,String time,String detail) {
		this.num=num;
		this.name=name;
		this.time=time;
		this.detail=detail;
	}
	public String getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	public String getTime() {
		return time;
	}
	public String getDetail() {
		return detail;
	}
}
