package function;

import model.Student;
import model.Teacher;
import java.sql.*;



/*
 * 学生登录界面controller
 * 
 * */

public class Login_controll {
	java.sql.Statement state = null;
	//学生登录
	public Student slogin(String sid,String spw) throws SQLException, ClassNotFoundException{
		
		ResultSet rs = null;
		String sql = null;
		Student u = null;
		
		 sql = "SELECT * FROM student WHERE sid = '"+sid
		 	+"'and password = '"+spw+"'";
		try {
			state = DataCon.getCon().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rs = state.executeQuery(sql);
			
			while(rs.next()){
				u = new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getString(13));
				System.out.println(u);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("登陆失败");
		}
		
		return u;
	}
	
	//老师登录
	public Teacher tlogin(String tid,String tpw) throws SQLException, ClassNotFoundException{
		
		ResultSet rs = null;
		String sql = null;
		Teacher teacher = null;
		
		sql = "select * from teacher where tid= '"+ tid
			 	+"'and password = '"+tpw+"'";
		
		try {
			state = DataCon.getCon().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rs = state.executeQuery(sql);
			
			while(rs.next()){
				teacher = new Teacher(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("登陆失败");
		}
		
	
		
		
		
		return teacher;
	}
}
