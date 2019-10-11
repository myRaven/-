package view;


import javax.swing.*;
import javax.swing.plaf.synth.SynthStyle;
import javax.swing.table.*;

import method.MyStyle;
import model.Course;
import model.Student;
import view.StudentClass;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectClass extends JFrame implements ActionListener{
	JButton jb_return,jb_Select,jb_Del,jb_seeClass,jb_search;
	JTextField jt_search;
	Object[]tableTitle = {
			"课程编号",
			"课程名称",
			"课程性质",
			"学分",
			"授课老师",
			"授课时间",
			"开放对象",
			"总量",
			"余量",
			"选否"
	};
	DefaultTableModel T_model;
	private JTable jtab ;
	private Student student;
	ArrayList<Course> courses;
	
	//int sc=new view.StudentClass(student).getChoose();
	//Course cousre1;
	
	//String judge[] = null;
	//ArrayList<Course> courses= new controller.Stu_MainControll().getCourse();
	//String selectCourses = new controller.Stu_MainControll().getSelectCourses(student);
	//Object [][] details = new Object[courses.size()][10];
	
	public SelectClass(Student student){
		this.student = student;
		init();
	}
	public void init(){
		this.setTitle("学生抢课");
		this.setSize(1200,750);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("images/窗口图标.png").getImage()); //设置窗口图片
		
		MyStyle style = new MyStyle();
		
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		this.add(jp);
		
		//标题
		JLabel jl_title = new JLabel("学 生 抢 课");
		jl_title.setHorizontalAlignment(SwingConstants.CENTER);
		jl_title.setFont(new Font("幼圆",Font.BOLD,30));
		style.setColor(jl_title,new Color(0,185,253),new Color(244,188,3));
		
		jp.add(jl_title,BorderLayout.PAGE_START);
		
		//创建表格
		
		try {
			courses = new function.Stu_MainControll().getCourse();
			String selectCourses = new function.Stu_MainControll().getSelectCourses(student);
			Object [][] details = new Object[courses.size()][10];
			//String judge[] = null;
				for(int i=0;i<courses.size();i++){
				details[i][0] = courses.get(i).getCid();
				details[i][1] = courses.get(i).getCname();
				details[i][2] = courses.get(i).getCoursetype();
				details[i][3] = courses.get(i).getCredit();
				details[i][4] = courses.get(i).getTeacher();
				details[i][5] = courses.get(i).getTime();
				details[i][6] = courses.get(i).getObject();
				details[i][7] = courses.get(i).getNum();
				details[i][8] = courses.get(i).getAllowance();
				if((selectCourses.indexOf(courses.get(i).getCid()))!=-1){
					details[i][9] = "已选";
				}
				else{
					details[i][9] = "未选";
				}
				 
			}
				//for(int i=0;i<courses.size();i++){	
				//judge[i]=(details[i][9]).toString();	
			//System.out.println((details[i][9]).toString());
				//}
			
			T_model = new DefaultTableModel(details,tableTitle);
			jtab = new JTable(T_model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel jp_Center = new JPanel();
		
		//查找课程面板
		JPanel jp_Center_north = new JPanel();
		jp_Center_north.setLayout(null);
		jp_Center_north.setPreferredSize(new Dimension(1200,30));
		jp_Center.add(jp_Center_north,BorderLayout.PAGE_START);
		
		JLabel jl_search = new JLabel("输入课程名:");
		jl_search.setFont(new Font("幼圆",Font.BOLD,20));
		style.setColor(jl_search,new Color(0,185,253),new Color(244,188,3));
		
		jl_search.setBounds(100,0,300,30);
		jp_Center_north.add(jl_search);
		
		jt_search = new JTextField();
		jt_search.setBounds(230,0,150,30);
		jt_search.setFont(new Font("幼圆",Font.BOLD,15));
		jp_Center_north.add(jt_search);
		
		jb_search = new JButton("查 找");
		jb_search.setFont(new Font("幼圆",Font.BOLD,15));
		style.setColor(jb_search,new Color(0,185,253),new Color(244,188,3));
		jb_search.setBounds(390,0,80,30);
		jp_Center_north.add(jb_search);
		
		//滚动面板
		JScrollPane jsp =  new JScrollPane(jtab);
		jsp.setPreferredSize(new Dimension(1100,460));
		jp_Center.add(jsp,BorderLayout.CENTER);
		jp.add(jp_Center,BorderLayout.CENTER);
		
		//放选课操作按钮的面板
		JPanel jp_Center_South = new JPanel();
		//jp_Center_South.setBackground(Color.yellow);
		jp_Center_South.setLayout(new FlowLayout());
		jp_Center.add(jp_Center_South,BorderLayout.PAGE_END);
		
		//按钮
		jb_Select = new JButton("快速选课");
		jb_Del = new JButton("取消选课");
		jb_seeClass = new JButton("已选课程");
		
		jb_Select.setSize(80,40);
		jb_Select.setFont(new Font("幼圆",Font.BOLD,20));
		style.setColor(jb_Select,new Color(0,185,253),new Color(244,188,3));
		jb_Del.setSize(80,40);
		jb_Del.setFont(new Font("幼圆",Font.BOLD,20));
		style.setColor(jb_Del,new Color(0,185,253),new Color(244,188,3));
		jb_seeClass.setSize(80,40);
		jb_seeClass.setFont(new Font("幼圆",Font.BOLD,20));
		style.setColor(jb_seeClass,new Color(0,185,253),new Color(244,188,3));
	
		
		jp_Center_South.add(jb_Select);
		jp_Center_South.add(jb_Del);
		jp_Center_South.add(jb_seeClass);
		
		//设置表格不可编辑
		//jt.setEnabled(false);
		
		//选择行的方式为只能选中一行
		jtab.setSelectionMode(0);
		
		
		jb_return = new JButton("返 回");
		jb_return.setSize(100,30);
		jb_return.setFont(new Font("幼圆",Font.BOLD,26));
		style.setColor(jb_return,new Color(0,185,253),new Color(244,188,3));
		
		jp.add(jb_return,BorderLayout.PAGE_END);
	
		//添加事件
		jb_return.addActionListener(this);
		jb_Select.addActionListener(this);
		jb_Del.addActionListener(this);
		jb_seeClass.addActionListener(this);
		jb_search.addActionListener(this);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//返回
		if(e.getSource()==jb_return){
			new Stu_Main(view.Login.student);
			this.setVisible(false);
		}
		
		//选择课程
		if(e.getSource()==jb_Select){
			int row = jtab.getSelectedRow();
			if(row!=-1){
				try {
					int s = JOptionPane.showConfirmDialog(this, "确定要选择该课程吗？");
					if(s==0){
						Course course = new function.SelectClassControll().getCourse(jtab.getValueAt(row,0).toString());//从数据库中得到课程信息
						if(new function.SelectClassControll().selectClass(course, student, jtab.getValueAt(row,9).toString())){ //满足条件
							jtab.setValueAt("已选", row, 9);
							//余量减一
							T_model.setValueAt(new function.SelectClassControll().getAllowance(course),row,8); 
						}
						
					/*	
					if(s==0){
						
						//已选课程不显示(可以消失  但会空一行,取消选课也弄不了)
						//System.out.println(jtab.getValueAt(row,9).toString());
						Object [][] details1 = new Object[courses.size()][10];
						for(int i=0;i<courses.size();i++){
							String a=(details[i][9]).toString();
							System.out.println(a);
							if(a!= "已选"){
								System.out.println(i);
								details1[i][0] = courses.get(i).getCid();
								details1[i][1] = courses.get(i).getCname();
								details1[i][2] = courses.get(i).getCoursetype();
								details1[i][3] = courses.get(i).getCredit();
								details1[i][4] = courses.get(i).getTeacher();
								details1[i][5] = courses.get(i).getTime();
								details1[i][6] = courses.get(i).getObject();
								details1[i][7] = courses.get(i).getNum();
								details1[i][8] = courses.get(i).getAllowance();
								details1[i][9] = "未选";
								for(int j=0;j<10;j++){
								System.out.println(details1[i][j]);
								}
								System.out.println("***********************************");
							}
						}
						
						T_model = new DefaultTableModel(details1,tableTitle);
						
					}
					*/
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else{
				
			}
		}
		
		//退选课程
		if(e.getSource()==jb_Del){
			int row = jtab.getSelectedRow();
		
			Course course;
			if(row!=-1){	
				int s = JOptionPane.showConfirmDialog(this, "确定要退择该课程吗？");
				try {
					course = new function.SelectClassControll().getCourse(jtab.getValueAt(row,0).toString());
					
					if(s==0){
						if(new function.SelectClassControll().dropClass(course, student, jtab.getValueAt(row, 9).toString())){
							jtab.setValueAt("未选", row,9);
							T_model.setValueAt(new function.SelectClassControll().getAllowance(course),row,8);
						}
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
		
		/*
		 //退选课程2
		 if(sc==0){
			if(cousre1 ==new view.StudentClass(student).getCourse()){
				jtab.setValueAt("未选", row,9);
				//T_model.setValueAt(new controller.SelectClassControll().getAllowance(course),row,8);
			}
		}*/
		
		//查课已选课程
		if(e.getSource()==jb_seeClass){
				new StudentClass(student);
		}
		
		//查找课程
		if(e.getSource()==jb_search){
			try {
				courses = new function.SelectClassControll().searchCourse(jt_search.getText());
				String selectCourses = new function.Stu_MainControll().getSelectCourses(student);
				Object [][] details = new Object[courses.size()][10];
				for(int i=0;i<courses.size();i++){
					details[i][0] = courses.get(i).getCid();
					details[i][1] = courses.get(i).getCname();
					details[i][2] = courses.get(i).getCoursetype();
					details[i][3] = courses.get(i).getCredit();
					details[i][4] = courses.get(i).getTeacher();
					details[i][5] = courses.get(i).getTime();
					details[i][6] = courses.get(i).getObject();
					details[i][7] = courses.get(i).getNum();
					details[i][8] = courses.get(i).getAllowance();
					if((selectCourses.indexOf(courses.get(i).getCid()))!=-1){
						details[i][9] = "已选";
					}
					else{
						details[i][9] = "未选";
					}
				}
				System.out.println(courses.size());
				T_model = new DefaultTableModel(details,tableTitle);
				jtab.setModel(T_model);
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
