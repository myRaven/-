package view;


import javax.swing.*;
import javax.swing.table.*;

import method.MyStyle;
import model.Course;
import model.Student;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Timetable extends JFrame implements ActionListener{

private JButton jb_return;
	
	//表格模型
	Object[]tableTitle = {
			"时间",
			"星期一",
			"星期二",
			"星期三",
			"星期四",
			"星期五",
			"星期六",
			"星期天"
	};
	Object[][]details = {
			{"第1节"},
			{"第2节"},
			{"第3节"},
			{"第4节"},
			{"第5节"},
			{"第6节"},
			{"第7节"},
			{"第8节"},
			{"第9节"},
			{"第10节"},
			{"第11节"},
			{"第12节"},
			{"第13节"},
			{"第14节"},
			{"第15节"}
			
	};
	public DefaultTableModel T_model;
	Student student;
	public Timetable(Student student){
		this.student = student;
		try {
			init();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void init() throws SQLException, ClassNotFoundException{
		this.setTitle("超级课程表");
		this.setSize(1300,750);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("images/窗口图标.png").getImage()); //设置窗口图片
		
		MyStyle style = new MyStyle();
		
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		this.add(jp,BorderLayout.CENTER);
		
		
		T_model = new DefaultTableModel(details,tableTitle);
		ArrayList<Course> courses =new function.SelectClassControll().getSelectCourses(student);
		for(int i=0;i<courses.size();i++){
			String []session = courses.get(i).getSection().split(",");
			for(int j=0;j<session.length;j++){
				T_model.setValueAt(courses.get(i).getCname()+"|"+courses.get(i).getTeacher(),Integer.parseInt(session[j])-1,courses.get(i).getDay());
			}
		}
		
		//创建表格
		JTable jt_syllabus = new JTable(T_model); 
		JScrollPane js_table = new JScrollPane(jt_syllabus);
		jp.add(js_table,BorderLayout.CENTER);
		
		jt_syllabus.setFont(new Font("楷体",Font.PLAIN,11));
		
		//设置表格列高
		jt_syllabus.setRowHeight(36);
		
		//设置表格列不可移动
		JTableHeader header = jt_syllabus.getTableHeader();
		header.setReorderingAllowed(false);
		
		//设置表格自动调整
		jt_syllabus.setAutoResizeMode(4);
		
		//设置表格不可编辑
		jt_syllabus.setEnabled(false);
		
		//设置表格列居中
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		jt_syllabus.getColumn("时间").setCellRenderer(render);
		jt_syllabus.getColumn("星期一").setCellRenderer(render);
		jt_syllabus.getColumn("星期二").setCellRenderer(render);
		jt_syllabus.getColumn("星期三").setCellRenderer(render);
		jt_syllabus.getColumn("星期四").setCellRenderer(render);
		jt_syllabus.getColumn("星期五").setCellRenderer(render);
		jt_syllabus.getColumn("星期六").setCellRenderer(render);
		jt_syllabus.getColumn("星期天").setCellRenderer(render);
		
		//标题
		JLabel jl_title = new JLabel("我的课程表");
		jl_title.setHorizontalAlignment(SwingConstants.CENTER);
		jl_title.setFont(new Font("幼圆",Font.BOLD,30));
		style.setColor(jl_title,new Color(0,185,253),new Color(244,188,3));
		jp.add(jl_title,BorderLayout.PAGE_START);
		
		//返回按钮
		jb_return = new JButton("返回");
		jb_return.setSize(100,30);
		jb_return.setFont(new Font("幼圆",Font.BOLD,26));
		style.setColor(jb_return,new Color(0,185,253),new Color(244,188,3));
		
		jp.add(jb_return,BorderLayout.PAGE_END);
		
		
		//添加事件
		jb_return.addActionListener(this);
		
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb_return){
			new Stu_Main(view.Login.student);
			this.setVisible(false);
		}
	}

}

