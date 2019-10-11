package function;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Course;
import model.Student;

public class Adm_Main_controll {
private PreparedStatement state;
	
	
	//得到选择行的课程
	public Course getCourse(String cid) throws SQLException, ClassNotFoundException{
		return new function.SelectClassControll().getCourse(cid);
	}
	
	/*
	 * 修改数据库课程数据
	 * 修改表格课程数据（重新读取）
	 * 修改选择行位置
	 */
	public void updateCollege(Course course,String[]message) throws SQLException, ClassNotFoundException{
		String sql = "update course set cid=?,cname=?,teacher=?,coursetype=?,credit=?,time=?,day=?,section=?,object=?,num=?,allowance=? where cid=?";
		state = DataCon.getCon().prepareStatement(sql);
		//model.DataCon.getCon().setAutoCommit(false);  //设置自动上传,否

		for(int i=0;i<message.length;i++){
			if(i==4||i==6||i==9||i==10){
				state.setInt(i+1,Integer.parseInt(message[i]));
			}
			else{
				state.setString(i+1,message[i]);
			}
		}
		state.setString(12,course.getCid());
		//state.addBatch();
		//state.executeBatch();
		//model.DataCon.getCon().commit();
		state.executeUpdate();
	//	model.DataCon.getCon().setAutoCommit(true);
	}
	
	
	/*增加课程
	 * 增加数据库的课程
	 * 判断数据库是否存在该课程编号
	 * 修改表格的数据（重新读取）
	 * 修改选中行
	 * */
	public void addCourse(String[]message) throws SQLException, ClassNotFoundException{
		String sql = "insert into course values(?,?,?,?,?,?,?,?,?,?,?)";
		state = DataCon.getCon().prepareStatement(sql);
		for(int i=0;i<message.length;i++){
			if(i==4||i==6||i==9||i==10){
				state.setInt(i+1,Integer.parseInt(message[i]));
			}
			else{
				state.setString(i+1,message[i]);
			}
		}
		state.execute();
		
		
	}
	
	//判断课程是否存在
	public boolean isCidExist(String cid) throws SQLException, ClassNotFoundException{
		String sql = "select cid from course where cid=?"; 
		state = DataCon.getCon().prepareStatement(sql);
		state.setString(1,cid);
		ResultSet rs = state.executeQuery();
		if(rs.next()){
			return true;
		}
		return false;
	}
	
	//得到课程在数据库的位置
	/*public int getCourseLocate(){
		
	}*/
	
	
	
	/*删除课程
	 * 删除数据库的课程
	 * 更新表格数据
	 */
	
	public void delCourse(Course course) throws SQLException, ClassNotFoundException{
		String sql = "delete from course where cid =?;";
		state = DataCon.getCon().prepareStatement(sql);
		state.setString(1,course.getCid());
		state.execute();
	}
	
	
	/*查找课程
	 * 调用selectClass类的方法
	 * 
	 */
	
	public ArrayList<Course> searchCourse(String text) throws SQLException, ClassNotFoundException{
		return new function.SelectClassControll().searchCourse(text);
	}
	
	
	
	/*
	 * 学生信息管理
	 * 
	 */
	
	
	//读取所有学生
	public ArrayList<Student> getStudents() throws SQLException, ClassNotFoundException{
		ArrayList<Student> students = new ArrayList<Student>();
		String sql = "select * from student";
		state = DataCon.getCon().prepareStatement(sql);
		ResultSet rs = state.executeQuery();
		while(rs.next()){
			students.add(new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
					rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getString(13)));
		}
		
		return students;
	}
	
	//得到选择行的学生
	public Student getStudent(String sid) throws SQLException, ClassNotFoundException{
		Student student = null ;
		String sql = "select * from student where sid=?;";
		state = DataCon.getCon().prepareStatement(sql);
		state.setString(1, sid);
		ResultSet rs = state.executeQuery();
		while(rs.next()){
			student =new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
					rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getString(13));
		}
		return student;
	}
	
	//修改学生信息
	public void updateStudent(Student student,String[]message) throws SQLException, ClassNotFoundException{
		String sql = "update student set sid=?,sname=?,sex=?,borndate=?,nation=?,face=?,college=?,major=?,sclass=?,password=?,img_path=? where sid=?;";
		state = DataCon.getCon().prepareStatement(sql);
		for(int i=0;i<message.length;i++){
			state.setString(i+1, message[i]);
		}
		state.setString(12,student.getSid());
		state.addBatch();
		state.executeBatch();
	}
	
	/*增加学生
	 *判断学生id是否存在
	 *增加
	 */
	public void addStudent(String message[]) throws SQLException, ClassNotFoundException{
		String sql = "insert into student(sid,sname,sex,borndate,nation,face,college,major,sclass,password,img_path) values(?,?,?,?,?,?,?,?,?,?,?)";
		state = DataCon.getCon().prepareStatement(sql);
		for(int i=0;i<message.length;i++){
			state.setString(i+1, message[i]);
		}
		state.execute();
	}
	
	//判断学生id是否在数据库存在
	public boolean isSidExist(String sid) throws SQLException, ClassNotFoundException{
		String sql = "select sid from student where sid=?;";
		state = DataCon.getCon().prepareStatement(sql);
		state.setString(1,sid);
		ResultSet rs = state.executeQuery();
		if(rs.next()){
			return true;
		}
		return false;
	}
	
	
	/*
	 * 删除学生
	 */
	public void delStudent(Student student) throws SQLException, ClassNotFoundException{
		String sql = "delete from student where sid=?;";
		state = DataCon.getCon().prepareStatement(sql);
		state.setString(1,student.getSid());
		state.execute();
	}
	
	
	/*
	 * 查找学生Student student
	 */
	
	public ArrayList<Student> searchStudent(String text) throws SQLException, ClassNotFoundException{
		ArrayList<Student> students = new ArrayList<Student>();
		String sql = "select * from student where sid="+text+";";
		//向数据库传递数据进行查询                                                  值
		//String sql = "from student where sname like '%"+text+"%';";
		state = DataCon.getCon().prepareStatement(sql);
		
		//state.setString(1,student.getSid());
		
		ResultSet rs = state.executeQuery();
		while(rs.next()){
			students.add(new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
					rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getString(13)));
		}
		return students;
	}
	
	
	/*
	 * 更换照片
	 */
	public String getImg_path(){
		JFileChooser jf = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("图像格式(jpg/gif)","jpg","jpeg","gif");
		jf.setFileFilter(filter);
		int n = jf.showOpenDialog(null);
		if(n==JFileChooser.APPROVE_OPTION){
			return jf.getSelectedFile().getPath();
		}
		return "";
	}
}

 class MyException extends Exception{
	 public MyException(){
		 
	 }
	 public MyException(String s){
		 super(s);
	 }
 }
