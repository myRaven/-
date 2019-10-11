package model;

import java.io.Serializable;

public class Student implements Serializable{
	private String sid;
	private String sname;
	private String sex;
	private String borndate;
	private String nation;
	private String face;
	private String college;
	private String major;
	private String sclass;
	private int selectcredit;
	private int sumcredit;
	private String password;
	private String img_path;


	public Student(String sid, String sname, String sex, String borndate,
			String nation, String face, String college, String major,
			String sclass, int selectcredit, int sumcredit, String password,
			String imgPath) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.borndate = borndate;
		this.nation = nation;
		this.face = face;
		this.college = college;
		this.major = major;
		this.sclass = sclass;
		this.selectcredit = selectcredit;
		this.sumcredit = sumcredit;
		this.password = password;
		img_path = imgPath;
	}
	
	public Student(int selectcredit, String password,
			String imgPath) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.borndate = borndate;
		this.nation = nation;
		this.face = face;
		this.college = college;
		this.major = major;
		this.sclass = sclass;
		this.selectcredit = selectcredit;
		this.sumcredit = sumcredit;
		this.password = password;
		img_path = imgPath;
	}
	
	public Student(String sid,  String spw) {
		super();
		this.sid = sid;
		this.password = spw;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBorndate() {
		return borndate;
	}

	public void setBorndate(String borndate) {
		this.borndate = borndate;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public int getSumcredit() {
		return sumcredit;
	}

	public void setSumcredit(int sumcredit) {
		this.sumcredit = sumcredit;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSelectcredit() {
		return selectcredit;
	}

	public void setSelectcredit(int selectcredit) {
		this.selectcredit = selectcredit;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String imgPath) {
		img_path = imgPath;
	}
	
	
}
