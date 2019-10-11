package function;

import java.util.ArrayList;
import java.sql.*;

import model.Course;
import model.Student;

/*
 * 学生主界面方法
 * 
 * */

public class Stu_MainControll {
	
	PreparedStatement state = null;
	
	//读取课程信息
	public ArrayList<Course> getCourse() throws SQLException, ClassNotFoundException{
		ArrayList<Course> courses = new ArrayList<Course>();
		String sql = "select * from course";
		state = DataCon.getCon().prepareStatement(sql);
		ResultSet rs = state.executeQuery();
		while(rs.next()){
			courses.add(new Course(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)
					,rs.getInt(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11)));
		}
		return courses;
	}
	//读取学生已选的课程编码
	public String getSelectCourses(Student student) throws SQLException, ClassNotFoundException{
		String selectCourses = "";
		String sql = "select cid from score where sid=?";
		state = DataCon.getCon().prepareStatement(sql);
		state.setString(1, student.getSid());
		ResultSet rs = state.executeQuery();
		while(rs.next()){
			selectCourses = selectCourses+","+rs.getString(1);
		}
		return selectCourses;
	}
}
