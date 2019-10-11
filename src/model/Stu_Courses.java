package model;

public class Stu_Courses {
	private String cid;
	private String cname;
	private String teacher;
	private String coursetype;
	private String time;
	private int credit;
	private int score;
	private String status;
	public Stu_Courses(String cid, String cname, String teacher,
			String coursetype, String time, int credit, int score, String status) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.teacher = teacher;
		this.coursetype = coursetype;
		this.time = time;
		this.credit = credit;
		this.score = score;
		this.status = status;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
