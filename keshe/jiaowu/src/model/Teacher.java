package model;

public class Teacher {
	private String name;
	private String password;
	public Teacher(String name,String password){
		this.name=name;
		this.password=password;
	}
	 public String getName() {
		return name;
	}
	 public String getPassword() {
		 return password;
	 }
}