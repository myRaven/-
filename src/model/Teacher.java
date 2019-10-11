package model;

import java.io.Serializable;

public class Teacher implements Serializable{
	private String tid;
	private String tname;
	private String password;
	public Teacher(String tid, String tname, String password) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.password = password;
	}
	public Teacher(String tid,String password) {
		super();
		this.tid = tid;
		this.password = password;
	}
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
