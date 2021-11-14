package model;

public class Stu {
	private String name;
	private String password;
	private String num;
	public Stu(String num,String name,String password){
		this.num=num;
		this.name=name;
		this.password=password;
	}
	 public String getName() {
		return name;
	}
	 public String getPassword() {
		 return password;
	 }
	 public String getId() {
		 return num;
	 }
}
