package function;

import java.util.ArrayList;

import java.sql.*;

import model.*;

public class StudentClass_controll {

	private PreparedStatement state;
	//查找学生已选的课程信息和课程分数状态
	public ArrayList<Stu_Courses> searchStuCourses(Student stu){
		ArrayList<Stu_Courses> stu_courses = new ArrayList<Stu_Courses>();
		String sql = "select course.cid,cname,teacher,coursetype,time,credit,score,status from course,score where course.cid=score.cid and score.sid=?";
		try {
			state = DataCon.getCon().prepareStatement(sql);
			//state = function.DataCon.getStat().executeQuery(sql);
			state.setString(1, stu.getSid());
			ResultSet rs = state.executeQuery();
			while(rs.next()){
				stu_courses.add(new Stu_Courses(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu_courses;
	}
}
