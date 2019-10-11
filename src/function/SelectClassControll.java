package function;

import model.Course;
import model.Student;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class SelectClassControll {
	/*选课
	 * 1.判断是否已选
	 * 2.判断课程开放对象
	 * 3.判断课程余量是否为0
	 * 4.判断学分是否上限，上限25学分
	 * 5.判断上课时间是否冲突
	 * 6.抢课成功，创建课程 score,修改课程余量,修改学分
	 * 7.更新表格数据
	 * */
	
	private PreparedStatement state;
	
	public boolean selectClass(Course course,Student student,String isSelectd) throws SQLException, ClassNotFoundException{
		
		
		if(this.isNotSelectd(isSelectd)){
				
			if(this.isObject(student, course)){
				if(this.isNotZero(course)){
					if(this.isCreditFull(course, student)){
						JOptionPane.showMessageDialog(null,"选课失败，课程学分上限！");
					}
					else{
						if(this.isSameTime(course, student)){
							JOptionPane.showMessageDialog(null,"选课失败，上课时间冲突！");
						}
						else{
							this.createScore(student, course);
							this.changeAllowance(course,"-");
							this.changeSelectCredit(student, course,"+");
							JOptionPane.showMessageDialog(null,"选课成功！");
							return true;
						}
					}
					
				}
				else{
					JOptionPane.showMessageDialog(null,"选课失败，该课程人数上限！");
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"选课失败，该课程未对该专业开放！");
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "选课失败，该课程已选！");
		}
		return false;
	}
	
	
	//获取表格选中行的课程
	
	public Course getCourse(String cid) throws SQLException, ClassNotFoundException{
		Course course = null;
		String sql = "select * from course where cid=?;";
		state = DataCon.getCon().prepareStatement(sql);
		state.setString(1, cid);
		ResultSet rs = state.executeQuery();
		if(rs.next()){
			course = new Course(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getInt(5),
					rs.getString(6),rs.getInt(7), rs.getString(8),rs.getString(9), rs.getInt(10),rs.getInt(11));
		};
		return course;
	}
	
	//判断该学生是否是该课程的开放对象
	public boolean isObject(Student student,Course course){
		if(course.getObject().indexOf(student.getMajor())!=-1){
			return true;
		}
		return false;
	}
	
	//判断学生是否已选该课程
	public boolean isNotSelectd(String isSelectd){
		if(isSelectd.equals("未选")){
			return true;
		}
		return false;
	}
	
	//判断课程是否可更改
		public boolean isNotSatuts(String isStatus){
			if(isStatus.equals("进行中")){
				return true;
			}
			return false;
		}
	
	
	//判断课程余量是否不为0
	public boolean isNotZero(Course course){
		if(course.getAllowance()>0){
			return true;
		}
		return false;
	}
	
	//判断上课时间是否冲突
	public boolean isSameTime(Course course,Student student) throws SQLException, ClassNotFoundException{
		ArrayList<Course> courses = this.getSelectCourses(student);
		for(int i=0;i<courses.size();i++){
			if((course.getDay()==courses.get(i).getDay())||(course.getSection().equals(courses.get(i).getSection()))){
				return true;
			}
		}
		return false;
	}
	
	//判断学分是否上限
	public boolean isCreditFull(Course course,Student student) throws SQLException, ClassNotFoundException{
		int credit = this.getSelectCredit(student);
		if((credit+course.getCredit())>25){
			return true;
		}
		return false;
	}
	
	
	//得到学生的已选课程学分
	public int getSelectCredit(Student student) throws SQLException, ClassNotFoundException{
		ArrayList<Course> courses = this.getSelectCourses(student);
		int credit = 0;
		for(int i=0;i<courses.size();i++){
			credit = courses.get(i).getCredit()+credit;
		}
		return credit;
	}
	//创建学生选择的课程的分数
	public void createScore(Student student,Course course) throws SQLException, ClassNotFoundException{
		String sql = "insert into score(sid,cid) values(?,?)";
		state = DataCon.getCon().prepareStatement(sql);
		state.setString(1,student.getSid());
		state.setString(2,course.getCid());
		state.executeUpdate();
	}
	
	//读取课程余量
	public int getAllowance(Course course) throws SQLException, ClassNotFoundException{
		int allowance = 0;
		String sql1 = "select allowance from course where cid=?;";
		state = DataCon.getCon().prepareStatement(sql1);
		state.setString(1, course.getCid());
		ResultSet rs = state.executeQuery();
		if(rs.next()){
			allowance = rs.getInt(1);
		}
		return allowance;
	}
	
	//修改课程余量
	public void changeAllowance(Course course,String aod) throws SQLException, ClassNotFoundException{
		int allowance = this.getAllowance(course);
		String sql2 = null;
		if(aod.equals("-")){	
			sql2 = "update course set allowance=? where cid='"+course.getCid()+"';";
			state = DataCon.getCon().prepareStatement(sql2);
			state.setInt(1, allowance-1);
		}
		if(aod.equals("+")){
			sql2 = "update course set allowance=? where cid='"+course.getCid()+"';";
			state = DataCon.getCon().prepareStatement(sql2);
			state.setInt(1, allowance+1);
		}
		state.execute();
	}
	
	//修改学生已选课程学分
	public void changeSelectCredit(Student student,Course course,String aod) throws SQLException, ClassNotFoundException{
		int credit = this.getSelectCredit(student);		
		String sql = "update student set selectcredit=? where sid=?;";
		state = DataCon.getCon().prepareStatement(sql);
		state.setInt(1, credit);
		state.setString(2, student.getSid());
		state.execute();
	}
	
	
	
	/*退选课程
	 * 1.课程是否已选，是否进行中
	 * 2.删除score表中的数据
	 * 3.修改课程余量，修改学分
	 * 4.退选成功
	 * 5.修改表格数据
	 * */
	public boolean dropClass(Course course,Student student,String isSelectd/*,String status*/) throws SQLException, ClassNotFoundException{
		if(this.isNotSelectd(isSelectd)){
			JOptionPane.showMessageDialog(null, "退选失败，该课程还未选择！");
		}
		/*else if(this.isNotStatus(isStatus)){
			JOptionPane.showMessageDialog(null, "退选失败，该课程已结不允许更改！");
		}*/
		else{
			this.delScore(course,student);
			this.changeAllowance(course, "+");
			this.changeSelectCredit(student, course, "-");
			JOptionPane.showMessageDialog(null, "退选成功！");
			return true;
		}
		return false;
	}
	
	private boolean isNotStatus(String isSelectd) {
		// TODO Auto-generated method stub
		return false;
	}


	//删除score表中的数据
	public void delScore(Course course,Student student) throws SQLException, ClassNotFoundException{
		String sql = "delete from score where sid=? and cid=?";
		state = DataCon.getCon().prepareStatement(sql);
		state.setString(1,student.getSid());
		state.setString(2,course.getCid());
		state.execute();
	}
	
	
	/*已选课程
	 *读取学生已选课程的课程号
	 *根据课程号读取课程保存在集合
	 * 
	 * */
	
	//获取学生已选的所有课程
	public ArrayList<Course> getSelectCourses(Student student) throws SQLException, ClassNotFoundException{
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<String> courseId = new ArrayList<String>();
		
		//获取所有该学生选择的课程号
		String sql1 = "select cid from score where sid=?;";
		state = DataCon.getCon().prepareStatement(sql1);
		state.setString(1,student.getSid());
		ResultSet rs = state.executeQuery();
		while(rs.next()){
			courseId.add(rs.getString(1));
		}
		
		//将课程添加到集合
		for(int i=0;i<courseId.size();i++){
			String sql2 = "select * from course where cid=?;";
			state = DataCon.getCon().prepareStatement(sql2);
			state.setString(1, courseId.get(i));
			rs = state.executeQuery();
			if(rs.next()){
				courses.add(new Course(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)
						,rs.getInt(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11)));
			}
		}
		return courses;
	}
	
	
	/*查找课程
	 * 数据库找出带有学生输入关键字的课程
	 * 返回课程集合
	 * 修改表格显示的内容
	 * */
	public  ArrayList<Course> searchCourse(String text) throws SQLException, ClassNotFoundException{
		ArrayList<Course> courses = new ArrayList<Course>();
		String sql = "select * from course where cname like '%"+text+"%'";
		state = DataCon.getCon().prepareStatement(sql);
		ResultSet rs = state.executeQuery();
		while(rs.next()){
			courses.add(new Course(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)
						,rs.getInt(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11)));
		}
		return courses;
	}
	
	
}

