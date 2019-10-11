package model;

public class Course {
	private String cid;
	private String cname;
	private String teacher;
	private String coursetype;
	private int credit;
	private String time;
	private int day;
	private String section;
	private String object;
	private int num;
	private int allowance;
	public Course(String cid, String cname, String teacher, String coursetype,
			int credit, String time, int day, String section, String object,
			int num, int allowance) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.teacher = teacher;
		this.coursetype = coursetype;
		this.credit = credit;
		this.time = time;
		this.day = day;
		this.section = section;
		this.object = object;
		this.num = num;
		this.allowance = allowance;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getCoursetype() {
		return coursetype;
	}
	public void setCoursetype(String coursetype) {
		this.coursetype = coursetype;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getAllowance() {
		return allowance;
	}
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
	
}
