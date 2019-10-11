package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import method.MyStyle;
import model.Course;
import model.Stu_Courses;
import model.Student;

/*
 * 查看已选课程面板
 * 
 * */
public class StudentClass extends JFrame implements ActionListener {

	Object[]title = {
			"课程编号",
			"课程名称",
			"授课老师",
			"课程性质",
			"授课时间",
			"学分",
			"分数",
			"状态"
	};
	JTable jtab;
	DefaultTableModel t_model;
	ArrayList<Stu_Courses> stu_courses;
	Student stu;
	JButton jb_Del;
	
	//新加的
	public static int choose=-1;
	//Course course;
	
	public StudentClass(Student stu){
		this.stu = stu;
		stu_courses = new function.StudentClass_controll().searchStuCourses(stu);
		init();
	} 
	void init(){
		this.setTitle("已选课程");
		this.setSize(800,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		MyStyle style = new MyStyle();
		
		//底层面板
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		this.add(jp);
		
		//标题
		JLabel jl_title = new JLabel("已选课程");
		jl_title.setHorizontalAlignment(SwingConstants.CENTER);
		jl_title.setFont(new Font("幼圆",Font.BOLD,30));
		style.setColor(jl_title,new Color(0,185,253),new Color(244,188,3));
		jp.add(jl_title,BorderLayout.PAGE_START);
		
		//创建表格
		Object[][]details = new Object[stu_courses.size()][8];
		for(int i=0;i<stu_courses.size();i++){
			details[i][0] = stu_courses.get(i).getCid();
			details[i][1] = stu_courses.get(i).getCname();
			details[i][2] = stu_courses.get(i).getTeacher();
			details[i][3] = stu_courses.get(i).getCoursetype();
			details[i][5] = stu_courses.get(i).getCredit();
			details[i][4] = stu_courses.get(i).getTime();
			details[i][6] = stu_courses.get(i).getScore();
			details[i][7] = stu_courses.get(i).getStatus();
		}
		
		//按钮
		jb_Del = new JButton("取消选课");
		
		
		jb_Del.setSize(80,40);
		jb_Del.setFont(new Font("幼圆",Font.BOLD,20));
		style.setColor(jb_Del,new Color(0,185,253),new Color(244,188,3));
		jb_Del.setBounds(250,370,200,40);
		jp.add(jb_Del);
		
		jb_Del.addActionListener(this);
		
		//选择行的方式为只能选中一行
		//jtab.setSelectionMode(0);
		
		t_model = new DefaultTableModel(details,title);
		jtab = new JTable(t_model);
		JScrollPane js = new JScrollPane(jtab);
		jp.add(js);
		
		
		
		
		this.setVisible(true);
	}
	@Override
	//public void actionPerformed(ActionEvent e) {
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//退选课程
		if(e.getSource()==jb_Del){
			int row = jtab.getSelectedRow();
				
				//Course course;
				//Stu_Courses status;
				if(row!=-1){	
				int s = JOptionPane.showConfirmDialog(this, "确定要退择该课程吗？");
				try {
					    //System.out.println(stu_courses.get(row).getCid());
					    
					   Course course;
					    course = new function.SelectClassControll().getCourse(stu_courses.get(row).getCid().toString());
				        //course = new controller.SelectClassControll().getCourse(jtab.getValueAt(row,0).toString());  //两种都是课程号
				        
				        //status = new controller.SelectClassControll().getStatus(jtab.getValueAt(row,0).toString());
						if(s==0){
							if(new function.SelectClassControll().dropClass(course, stu, stu_courses.get(row).getCid().toString())){
								//刷新表格（成功不了，还得再改）
								Object[][]details = new Object[stu_courses.size()][8];
								for(int i=0;i<stu_courses.size();i++){
									details[i][0] = stu_courses.get(i).getCid();
									details[i][1] = stu_courses.get(i).getCname();
									details[i][2] = stu_courses.get(i).getTeacher();
									details[i][3] = stu_courses.get(i).getCoursetype();
									details[i][5] = stu_courses.get(i).getCredit();
									details[i][4] = stu_courses.get(i).getTime();
									details[i][6] = stu_courses.get(i).getScore();
									details[i][7] = stu_courses.get(i).getStatus();
								}
								
								Student student;
								//student = new controller.Adm_Main_controll().getStudent(t_model.jtab.getValueAt(row,0).toString());
								t_model = new DefaultTableModel(details,title);
								jtab.setModel(t_model);
								jtab.setRowSelectionInterval(t_model.getRowCount()-1,t_model.getRowCount()-1);        
								
								}
							choose=0;
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							
						}
					}
				}
		
	}
	public static int getChoose() {
		return choose;
	}
	public static void setChoose(int choose) {
		StudentClass.choose = choose;
	}
	/*
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}*/
	
	
}
