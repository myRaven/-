package function;

import java.sql.*;

import javax.swing.JOptionPane;

import model.Student;


public class Stu_Information_Controll {

private PreparedStatement state;
	
	//修改密码
	public boolean changePassword(String pw,Student student) throws SQLException, ClassNotFoundException{
		String sql = "update student set password=? where sid=?;";
		if(pw.equals("")){
			
		}
		else{
			state = DataCon.getCon().prepareStatement(sql);
			state.setString(1, pw);
			state.setString(2, student.getSid());
			state.execute();
			return true;
		}
		return false;
	}
}
