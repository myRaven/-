package view;

import javax.swing.*;
import javax.swing.table.*;

import method.MyStyle;
import model.Course;
import model.Student;
import model.Teacher;

import java.awt.*;
import java.awt.event.*; 
import java.sql.SQLException;
import java.util.ArrayList;

public class Adm_Main extends JFrame implements MouseListener,ActionListener {
	//课程信息管理
		private JTextField jt_college_num,jt_college_name,jt_college_type,jt_college_score,jt_college_teacher,jt_college_sum,
		jt_college_surplus,jt_college_time,jt_college_day,jt_college_session,jt_college_object;
		
		//退出
		private JButton jb_secede;
		
		//查找课程
		private JTextField jt_college_search;
		private JButton jb_college_search;
		private JButton jb_college_clear,jb_college_change,jb_college_add,jb_college_del;	
		private Object[]tableTitle_college = {
				"课程编号",
				"课程名称",
				"任课老师",
				"课程性质",
				"课程学分",
				"任教时间",
				"星期几",
				"哪几节(逗号隔开)",
				"面像对象",
				"课程总量",
				"课程余量"
				
		};
		private JTable jtab_college;
		private DefaultTableModel T_model_college;
		
		
		//学生信息管理
		
		//基本学生信息
		//文本框
		private JTextField jt_student_id,jt_student_name,jt_student_sex,jt_student_born,jt_student_nation,jt_student_face,
		jt_student_college,jt_student_major,jt_student_class,jt_student_pw,jt_student_search;
		
		//放头像的标签
		private JLabel jl_student_img;
		
		//放图片地址文本框
		private JTextArea jt_student_hidden;
		
		//基本操作按钮
		 private JButton jb_student_clear,jb_student_change,jb_student_add,jb_student_del,jb_student_save,jb_student_img,jb_student_check;
		 Object[]tableTitle_student = {
				"学号",
				"姓名",
				"性别",
				"出生日期",
				"民族",
				"政治面貌",
				"学院",
				"专业",
				"班级",
				"已选课程学分",
				"已通过课程学分",
				"密码",
				"照片路径"
		};
		private JTable jtab_student;
		private DefaultTableModel T_model_student;
		
		private Teacher teacher;
		ArrayList<Course> courses;
		ArrayList<Student> students;
		
		public Adm_Main(Teacher teacher){
			this.teacher = teacher;
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
			this.setTitle("抢课系统管理");
			this.setSize(1200,750);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setIconImage(new ImageIcon("images/窗口图标.png").getImage()); //设置窗口图片
			
			JPanel jp = new JPanel();
			jp.setLayout(new BorderLayout());
			this.add(jp);
			
			MyStyle style = new MyStyle();
			
			//课程信息管理
			JPanel jp_college = new JPanel();
			jp_college.setLayout(new BorderLayout());
			//创建表格
			T_model_college = new DefaultTableModel(init_details_college("all"),tableTitle_college);
			jtab_college= new JTable(T_model_college);
			JScrollPane jsp_college = new JScrollPane(jtab_college);
			jsp_college.setPreferredSize(new Dimension(1200,315));
			jp_college.add(jsp_college,BorderLayout.PAGE_START);
			
			//设置表格列不可移动
			JTableHeader header = jtab_college.getTableHeader();
			header.setReorderingAllowed(false);
			
			//基本信息选项卡
			JTabbedPane jtp_college_mess = new JTabbedPane();
			jtp_college_mess.setBounds(350,0,500,300);
			
			//最底层面板
			JPanel jp_college_M = new JPanel();
			jp_college_M.setLayout(null);
			jp_college_M.add(jtp_college_mess);
			
			//jp_college_mess面板
			JPanel jp_college_mess1 = new JPanel();
			style.setColor(jp_college_mess1,null,new Color(43,187,238));
			jp_college_mess1.setLayout(null);
			
			//jp_college_mess1面板内容
			//课程编号
			JLabel jl_college_num = new JLabel("课程编号:");
			jl_college_num.setBounds(0,20,80,30);
			jl_college_num.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_college_num,Color.white,null);
			jp_college_mess1.add(jl_college_num );
			
			jt_college_num = new JTextField();
			jt_college_num.setBounds(75,20,150,30);
			jt_college_num.setFont(new Font("幼圆",Font.BOLD,15));
			jp_college_mess1.add(jt_college_num);
			
			//课程名称
			JLabel jl_college_name = new JLabel("课程名称:");
			jl_college_name.setBounds(0,65,80,30);
			jl_college_name.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_college_name,Color.white,null);
			jp_college_mess1.add(jl_college_name);
			
			jt_college_name = new JTextField();
			jt_college_name.setBounds(75,65,150,30);
			jt_college_name.setFont(new Font("幼圆",Font.BOLD,15));
			jp_college_mess1.add(jt_college_name);
			
			//课程性质
			JLabel jl_college_type = new JLabel("课程性质:");
			jl_college_type.setBounds(0,110,80,30);
			jl_college_type.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_college_type,Color.white,null);
			jp_college_mess1.add(jl_college_type);
			
			jt_college_type = new JTextField();
			jt_college_type.setBounds(75,110,150,30);
			jt_college_type.setFont(new Font("幼圆",Font.BOLD,15));
			jp_college_mess1.add(jt_college_type);
			
			//学分
			JLabel jl_college_score = new JLabel("课程学分:");
			jl_college_score.setBounds(0,155,80,30);
			jl_college_score.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_college_score,Color.white,null);
			jp_college_mess1.add(jl_college_score);
			
			jt_college_score = new JTextField();
			jt_college_score.setBounds(75,155,150,30);
			jt_college_score.setFont(new Font("幼圆",Font.BOLD,15));
			jp_college_mess1.add(jt_college_score);
			
			//任课老师
			JLabel jl_college_teacher = new JLabel("任课老师:");
			jl_college_teacher.setBounds(270,20,80,30);
			jl_college_teacher.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_college_teacher,Color.white,null);
			jp_college_mess1.add(jl_college_teacher);
			
			jt_college_teacher = new JTextField();
			jt_college_teacher.setBounds(345,20,150,30);
			jt_college_teacher.setFont(new Font("幼圆",Font.BOLD,15));
			jp_college_mess1.add(jt_college_teacher);
			
			//课程总量
			JLabel jl_college_sum = new JLabel("课程总量:");
			jl_college_sum.setBounds(270,65,80,30);
			jl_college_sum.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_college_sum,Color.white,null);
			jp_college_mess1.add(jl_college_sum);
			
			jt_college_sum = new JTextField();
			jt_college_sum.setBounds(345,65,150,30);
			jt_college_sum.setFont(new Font("幼圆",Font.BOLD,15));
			jp_college_mess1.add(jt_college_sum);
			
			//剩余数量
			JLabel jl_college_surplus = new JLabel("课程余量:");
			jl_college_surplus.setBounds(270,110,80,30);
			jl_college_surplus.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_college_surplus,Color.white,null);
			jp_college_mess1.add(jl_college_surplus);
			
			jt_college_surplus = new JTextField();
			jt_college_surplus.setBounds(345,110,150,30);
			jt_college_surplus.setFont(new Font("幼圆",Font.BOLD,15));
			jp_college_mess1.add(jt_college_surplus);
			
			//上课时间
			JLabel jl_college_time = new JLabel("任教时间:");
			jl_college_time.setBounds(270,155,80,30);
			jl_college_time.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_college_time,Color.white,null);
			jp_college_mess1.add(jl_college_time);
			
			jt_college_time = new JTextField();
			jt_college_time.setBounds(345,155,150,30);
			jt_college_time.setFont(new Font("幼圆",Font.BOLD,15));
			jp_college_mess1.add(jt_college_time);
			
			
			
			//放基本的信息面板2
			JPanel jp_college_mess2 = new JPanel();
			jp_college_mess2.setLayout(null);
			JLabel jl_college_day;
			JLabel jl_college_session;
			JLabel jl_college_object;
			
			//星期几
			jl_college_day = new JLabel("周几:");
			jl_college_day.setBounds(20,35,80,30);
			jl_college_day.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_college_day,Color.white,null);
			jp_college_mess2.add(jl_college_day);
			
			jt_college_day = new JTextField();
			jt_college_day.setBounds(95,35,150,30);
			jt_college_day.setFont(new Font("幼圆",Font.BOLD,15));
			jp_college_mess2.add(jt_college_day);
			
			//第几节
			jl_college_session = new JLabel("哪几节课:");
			jl_college_session.setBounds(20,80,80,30);
			jl_college_session.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_college_session,Color.white,null);
			jp_college_mess2.add(jl_college_session);
			
			jt_college_session = new JTextField();
			jt_college_session.setBounds(95,80,150,30);
			jt_college_session.setFont(new Font("幼圆",Font.BOLD,15));
			jp_college_mess2.add(jt_college_session);
			
			//面向对象
			jl_college_object = new JLabel("面向对象:");
			jl_college_object.setBounds(20,125,80,30);
			jl_college_object.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_college_object,Color.white,null);
			jp_college_mess2.add(jl_college_object);
			
			jt_college_object = new JTextField();
			jt_college_object.setBounds(95,125,150,30);
			jt_college_object.setFont(new Font("幼圆",Font.BOLD,15));
			jp_college_mess2.add(jt_college_object);
			
			
			
			
			
			
			
			//查找课程面板
			JPanel jp_college_check = new JPanel();
			jp_college_check .setLayout(null);
			
			//面板内容
			JLabel jl_college_check = new JLabel("请输入课程名称:");
			jl_college_check.setFont(new Font("幼圆",Font.BOLD,15));
			jl_college_check.setBounds(100,50,200,30);
			style.setColor(jl_college_check,Color.white,null);
			jp_college_check.add(jl_college_check);
			
			jt_college_search = new JTextField();
			jt_college_search.setBounds(100,100,200,30);
			jp_college_check.add(jt_college_search);
			
			jb_college_search = new JButton("查 找");
			jb_college_search.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jb_college_search,new Color(0,185,253),new Color(244,188,3));
			jb_college_search.setBounds(310,100,80,30);
			jp_college_check.add(jb_college_search);
			
			//将jp_college_mess面板添加到基本信息选项卡
			jtp_college_mess.addTab("课程基本信息",jp_college_mess1);
			jtp_college_mess.addTab("课程基本信息", jp_college_mess2);
			jtp_college_mess.addTab("查找课程",jp_college_check);
			jp_college.add(jp_college_M,BorderLayout.CENTER);
			
			
			
			//放基本信息操作按钮的面板
			JPanel jp_college_operate = new JPanel();
			jp_college_operate.setPreferredSize(new Dimension(1200,50));
			//style.setColor(jp_college_operate,null,Color.yellow);
			jp_college_operate.setLayout(new FlowLayout());
			jp_college.add( jp_college_operate,BorderLayout.PAGE_END);
			
			//清除内容
			jb_college_clear = new JButton("清除内容");
			jb_college_clear.setSize(50,30);
			jb_college_clear.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jb_college_clear,new Color(0,185,253),new Color(244,188,3));
			jp_college_operate.add(jb_college_clear);
			
			//修改课程
			jb_college_change = new JButton("修改课程");
			jb_college_change.setSize(50,30);
			jb_college_change.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jb_college_change,new Color(0,185,253),new Color(244,188,3));
			jp_college_operate.add(jb_college_change);
			
			//增加课程
			jb_college_add = new JButton("增加课程");
			jb_college_add.setSize(50,30);
			jb_college_add.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jb_college_add,new Color(0,185,253),new Color(244,188,3));
			jp_college_operate.add(jb_college_add);
			
			//删除课程
			jb_college_del = new JButton("删除课程");
			jb_college_del.setSize(50,30);
			jb_college_del.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jb_college_del,new Color(0,185,253),new Color(244,188,3));
			jp_college_operate.add(jb_college_del);
			
			//退出按钮 
			jb_secede= new JButton("退出登录");
			jb_secede.setSize(50,30);
			jb_secede.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jb_secede,new Color(0,185,253),new Color(244,188,3));
			jp_college_operate.add(jb_secede);
					
			//添加事件
			jb_secede.addActionListener((ActionListener) this);
			
			
			
			//添加图片
			ImageIcon mess_bg1 = new ImageIcon("images/mess_bg3.png");
			ImageIcon mess_bg2 = new ImageIcon("images/mess_bg.png");
			ImageIcon mess_bg = new ImageIcon("images/mess_bg2.png");
			JLabel jl_mess_bg1 = new JLabel(mess_bg1);
			JLabel jl_mess_bg2 = new JLabel(mess_bg2);
			JLabel jl_mess_bg = new JLabel(mess_bg);
			jl_mess_bg1.setBounds(0,0,500,310);
			jl_mess_bg2.setBounds(0,0,500,310);
			jl_mess_bg.setBounds(0,0,500,310);
			jp_college_mess1.add(jl_mess_bg1);
			jp_college_mess2.add(jl_mess_bg);
			jp_college_check.add(jl_mess_bg2);
			
			
			
			//添加事件
			jtab_college.addMouseListener(this);
			jb_college_clear.addActionListener(this);
			jb_college_change.addActionListener(this);
			jb_college_add.addActionListener(this);
			jb_college_del.addActionListener(this);
			jb_college_search.addActionListener(this);
			
			
			
			
			
			
			/*
			 *
			 * 学生信息管理
			 * 
			 * */
			JPanel jp_student = new JPanel();
			jp_student.setLayout(new BorderLayout());
			
			//创建表格
			T_model_student = new DefaultTableModel(this.init_details_student("all"),tableTitle_student);
			jtab_student = new JTable(T_model_student);
			JScrollPane jsp_student = new JScrollPane(jtab_student);
			jsp_student.setPreferredSize(new Dimension(1200,315));
			jp_student.add(jsp_student,BorderLayout.PAGE_START);
			
			//设置表格列不可移动
			JTableHeader header1 = jtab_student.getTableHeader();
			header1.setReorderingAllowed(false);
			
			//将照片路径表格列隐藏
			DefaultTableColumnModel dcm = (DefaultTableColumnModel)jtab_student .getColumnModel();//获取列模型  
			 dcm.getColumn(12).setMinWidth(0);  //将第一列的最小宽度、最大宽度都设置为0，就看不到了
			 dcm.getColumn(12).setMaxWidth(0);
			
			//基本信息选项卡
			JTabbedPane jtp_student_mess = new JTabbedPane();
			jtp_student_mess.setBounds(350,0,500,300);
			
			//jp_student_mess面板
			JPanel jp_student_mess1 = new JPanel();
			style.setColor(jp_student_mess1,null,new Color(43,187,238));
			jp_student_mess1.setLayout(null);
			
			//最底层面板
			JPanel jp_student_M = new JPanel();
			jp_student_M.setLayout(null);
			jp_student_M.add(jtp_student_mess);
			
			//jp_student_mess面板内容
			//学号
			JLabel jl_student_id = new JLabel("  学 号:");
			jl_student_id.setBounds(0,20,80,30);
			jl_student_id.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_student_id ,Color.white,null);
			jp_student_mess1.add(jl_student_id );
			
			jt_student_id = new JTextField();
			jt_student_id.setBounds(75,20,150,30);
			jt_student_id.setFont(new Font("幼圆",Font.BOLD,15));
			jp_student_mess1.add(jt_student_id);
			
			//姓名
			JLabel jl_student_name = new JLabel("  姓 名:");
			jl_student_name.setBounds(0,65,80,30);
			jl_student_name.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_student_name,Color.white,null);
			jp_student_mess1.add(jl_student_name);
			
			jt_student_name = new JTextField();
			jt_student_name.setBounds(75,65,150,30);
			jt_student_name.setFont(new Font("幼圆",Font.BOLD,15));
			jp_student_mess1.add(jt_student_name);
			
			//性别
			JLabel jl_student_sex = new JLabel("  性 别:");
			jl_student_sex.setBounds(0,110,80,30);
			jl_student_sex.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_student_sex,Color.white,null);
			jp_student_mess1.add(jl_student_sex);
			
			jt_student_sex = new JTextField();
			jt_student_sex.setBounds(75,110,150,30);
			jt_student_sex.setFont(new Font("幼圆",Font.BOLD,15));
			jp_student_mess1.add(jt_student_sex);
			
			//出生日期
			JLabel jl_student_born = new JLabel("出生日期:");
			jl_student_born.setBounds(0,155,80,30);
			jl_student_born.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_student_born,Color.white,null);
			jp_student_mess1.add(jl_student_born);
			
			jt_student_born = new JTextField();
			jt_student_born.setBounds(75,155,150,30);
			jt_student_born.setFont(new Font("幼圆",Font.BOLD,15));
			jp_student_mess1.add(jt_student_born);
			
			//民族
			JLabel jl_student_nation = new JLabel(" 民  族:");
			jl_student_nation.setBounds(270,20,80,30);
			jl_student_nation.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_student_nation,Color.white,null);
			jp_student_mess1.add(jl_student_nation);
			
			jt_student_nation = new JTextField();
			jt_student_nation.setBounds(345,20,150,30);
			jt_student_nation.setFont(new Font("幼圆",Font.BOLD,15));
			jp_student_mess1.add(jt_student_nation);
			
			//政治面貌
			JLabel jl_student_face = new JLabel("政治面貌:");
			jl_student_face.setBounds(270,65,80,30);
			jl_student_face.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_student_face,Color.white,null);
			jp_student_mess1.add(jl_student_face);
			
			jt_student_face = new JTextField();
			jt_student_face.setBounds(345,65,150,30);
			jt_student_face.setFont(new Font("幼圆",Font.BOLD,15));
			jp_student_mess1.add(jt_student_face);
			
			//学院
			JLabel jl_student_college = new JLabel("  学 院:");
			jl_student_college.setBounds(270,110,80,30);
			jl_student_college.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_student_college,Color.white,null);
			jp_student_mess1.add(jl_student_college);
			
			jt_student_college = new JTextField();
			jt_student_college.setBounds(345,110,150,30);
			jt_student_college.setFont(new Font("幼圆",Font.BOLD,15));
			jp_student_mess1.add(jt_student_college);
			
			//专业
			JLabel jl_student_major = new JLabel("  专 业:");
			jl_student_major.setBounds(270,155,80,30);
			jl_student_major.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_student_major,Color.white,null);
			jp_student_mess1.add(jl_student_major);
			
			jt_student_major = new JTextField();
			jt_student_major.setBounds(345,155,150,30);
			jt_student_major.setFont(new Font("幼圆",Font.BOLD,15));
			jp_student_mess1.add(jt_student_major);
			
			JPanel jp_student_mess2 = new JPanel();
			style.setColor(jp_student_mess2,null,new Color(43,187,238));
			jp_student_mess2.setLayout(null);
			
			//班级
			JLabel jl_student_class = new JLabel("  班 级:");
			jl_student_class.setBounds(20,50,80,30);
			jl_student_class.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_student_class ,Color.white,null);
			jp_student_mess2.add(jl_student_class);
			
			jt_student_class = new JTextField();
			jt_student_class.setBounds(95,50,150,30);
			jt_student_class.setFont(new Font("幼圆",Font.BOLD,15));
			jp_student_mess2.add(jt_student_class);
			
			//密码
			JLabel jl_student_pw = new JLabel("  密 码:");
			jl_student_pw.setBounds(20,115,80,30);
			jl_student_pw.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jl_student_pw,Color.white,null);
			jp_student_mess2.add(jl_student_pw);
			
			jt_student_pw = new JTextField();
			jt_student_pw.setBounds(95,115,150,30);
			jt_student_pw.setFont(new Font("幼圆",Font.BOLD,15));
			jp_student_mess2.add(jt_student_pw);
			
		
			
			
			
			/*
			 * 放修改图片的面板
			 * */
			JPanel jp_student_img = new JPanel();
			jp_student_img.setLayout(null);
			style.setColor(jp_student_img,null,new Color(43,187,238));
			
			//放路径的文本框
			jt_student_hidden = new JTextArea();
			jt_student_hidden.setBounds(0,0,100,30);
			jp_student_img.add(jt_student_hidden);
			jt_student_hidden.hide();
			
			//显示图片标签
			jl_student_img = new JLabel();
			jl_student_img.setBounds(130,10,144,172);
			jp_student_img.add(jl_student_img);
			
			//更换图片提示
			JLabel jl_student_tip = new JLabel("（像素大小144×172）");
			jl_student_tip.setBounds(100,160,200,30);
			style.setColor(jl_student_tip,Color.white,null);
			jl_student_tip.setFont(new Font("幼圆",Font.BOLD,13));
			jp_student_img.add(jl_student_tip);
			
			//更换图片按钮
			jb_student_img = new JButton("更换图片");
			jb_student_img.setBounds(260,150,100,30);
			//style.setColor(jb_student_img,Color.orange,null);
			jb_student_img.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jb_student_img,new Color(0,185,253),new Color(244,188,3));
			jp_student_img.add(jb_student_img);
			
			//查找课程面板
			JPanel jp_student_check = new JPanel();
			jp_student_check .setLayout(null);
			
			//面板内容
			JLabel jl_student_search = new JLabel("请输入学生编号:");
			jl_student_search.setFont(new Font("幼圆",Font.BOLD,15));
			jl_student_search.setBounds(100,50,200,30);
			style.setColor(jl_student_search,Color.white,null);
			jp_student_check.add(jl_student_search);
			
			jt_student_search= new JTextField();
			jt_student_search.setBounds(100,100,200,30);
			jp_student_check.add(jt_student_search);
			
			jb_student_check = new JButton("查 找");
			jb_student_check.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jb_student_check,new Color(0,185,253),new Color(244,188,3));
			jb_student_check.setBounds(310,100,80,30);
			jp_student_check.add(jb_student_check);
			
			//将jp_student_mess面板添加到基本信息选项卡
			jtp_student_mess.addTab("操作学生",jp_student_mess1);
			jtp_student_mess.addTab("操作学生",jp_student_mess2);
			jtp_student_mess.addTab("更换照片",jp_student_img);
			jtp_student_mess.addTab("查找学生",jp_student_check);
			jp_student.add(jp_student_M,BorderLayout.CENTER);
			
			
			/*
			 * 放操作按钮的面板
			 * */
			JPanel jp_student_operate = new JPanel();
			jp_student_operate.setPreferredSize(new Dimension(1200,50));
			
			//style.setColor(jp_student_operate,null,Color.gray);
			//style.setColor(jp_student_operate,new Color(244,188,3),new Color(0,185,253));
			
			jp_student_operate.setLayout(new FlowLayout());
			jp_student.add( jp_student_operate,BorderLayout.PAGE_END);
			
			//清除内容
			jb_student_clear = new JButton("清除内容");
			jb_student_clear.setSize(50,30);
			jb_student_clear.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jb_student_clear,new Color(0,185,253),new Color(244,188,3));
			jp_student_operate.add(jb_student_clear);
			
			
			//修改学生信息
			jb_student_change = new JButton("修改信息");
			jb_student_change.setSize(50,30);
			jb_student_change.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jb_student_change,new Color(0,185,253),new Color(244,188,3));
			jp_student_operate.add(jb_student_change);
			
			//增加课程
			jb_student_add = new JButton("增加学生");
			jb_student_add.setSize(50,30);
			jb_student_add.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jb_student_add,new Color(0,185,253),new Color(244,188,3));
			jp_student_operate.add(jb_student_add);
			
			//删除课程
			jb_student_del = new JButton("删除学生");
			jb_student_del.setSize(50,30);
			jb_student_del.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jb_student_del,new Color(0,185,253),new Color(244,188,3));
			jp_student_operate.add(jb_student_del);
			
			//保存设置
			jb_student_save = new JButton("保存设置");
			jb_student_save.setSize(50,30);
			jb_student_save.setFont(new Font("幼圆",Font.BOLD,15));
			style.setColor(jb_student_save,new Color(0,185,253),new Color(244,188,3));
			jp_student_operate.add(jb_student_save);
			
			jp_student.add(jp_student_operate,BorderLayout.PAGE_END);
			
		
			//添加事件
			jtab_student.addMouseListener(this);
			jb_student_clear.addActionListener(this);
			jb_student_change.addActionListener(this);
			jb_student_add.addActionListener(this);
			jb_student_del.addActionListener(this);
			jb_student_check.addActionListener(this);
			jb_student_img.addActionListener(this);
			
			//添加图片
			ImageIcon mess_bg3 = new ImageIcon("images/mess_bg3.png");
			ImageIcon mess_bg4 = new ImageIcon("images/mess_bg4.png");
			ImageIcon mess_bg5 = new ImageIcon("images/mess_bg.png");
			ImageIcon mess_bg6 = new ImageIcon("images/mess_bg2.png");
			JLabel jl_mess_bg3 = new JLabel(mess_bg3);
			JLabel jl_mess_bg4 = new JLabel(mess_bg4);
			JLabel jl_mess_bg5 = new JLabel(mess_bg5);
			JLabel jl_mess_bg6 = new JLabel(mess_bg6);
			jl_mess_bg3.setBounds(0,0,500,310);
			jl_mess_bg4.setBounds(0,0,500,310);
			jl_mess_bg5.setBounds(0,0,500,310);
			jl_mess_bg6.setBounds(0,0,500,310);
			jp_student_mess1.add(jl_mess_bg3);
			jp_student_img.add(jl_mess_bg4);
			jp_student_check.add(jl_mess_bg5);
			jp_student_mess2.add(jl_mess_bg6);
			
			
			//创建选项卡面板
			ImageIcon img_tabbed1 = new ImageIcon("images/JTabbed_2.png");
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbedPane.setPreferredSize(new Dimension(400,250));
			tabbedPane.addTab("课程信息管理",img_tabbed1,jp_college);
			jp.add(tabbedPane,BorderLayout.CENTER);
			
			ImageIcon img_tabbed2 = new ImageIcon("images/JTabbed_1.png");
			tabbedPane.addTab("学生信息管理",img_tabbed2,jp_student);
			
			this.setVisible(true);
		}
	   
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==jtab_college){
				int selectdRow = jtab_college.getSelectedRow();
				try {
					Course course = new function.Adm_Main_controll().getCourse(T_model_college.getValueAt(selectdRow,0).toString());
					jt_college_num.setText(course.getCid());
					jt_college_name.setText(course.getCname());
					jt_college_type.setText(course.getCoursetype());
					jt_college_score.setText(course.getCredit()+"");
					jt_college_teacher.setText(course.getTeacher());
					jt_college_sum.setText(course.getNum()+"");
					jt_college_surplus.setText(course.getAllowance()+"");
					jt_college_time.setText(course.getTime());
					jt_college_day.setText(course.getDay()+"");
					jt_college_session.setText(course.getSection());
					jt_college_object.setText(course.getObject());
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//将课程信息显示在文本框
				
			}
		
			if(e.getSource()==jtab_student){
				int selectdRow = jtab_student.getSelectedRow();
				try {
					Student student = new function.Adm_Main_controll().getStudent(T_model_student.getValueAt(selectdRow,0).toString());
					jt_student_id.setText(student.getSid());
					jt_student_name.setText(student.getSname());
					jt_student_sex.setText(student.getSex());
					jt_student_born.setText(student.getBorndate());
					jt_student_nation.setText(student.getNation());
					jt_student_face.setText(student.getFace());
					jt_student_college.setText(student.getCollege());
					jt_student_major.setText(student.getMajor());
					jt_student_class.setText(student.getSclass());
					jt_student_pw.setText(student.getPassword());
					jt_student_hidden.setText(student.getImg_path());
					jl_student_img.setIcon(new ImageIcon(student.getImg_path()+""));
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			//退出登录(退出后关闭当前页面没实现)
			if(e.getSource()==jb_secede){
					new  Login();
					this.setVisible(false);
			}
			
			
			if(e.getSource()==jb_college_clear){
				jt_college_num.setText("");
				jt_college_name.setText("");
				jt_college_type.setText("");
				jt_college_score.setText("");
				jt_college_teacher.setText("");
				jt_college_sum.setText("");
				jt_college_surplus.setText("");
				jt_college_time.setText("");
				jt_college_day.setText("");
				jt_college_session.setText("");
				jt_college_object.setText("");
			}
			
			if(e.getSource()==jb_college_change){
				String message[] = this.getMessage_college(); //得到文本框的信息
				int selectdRow =  jtab_college.getSelectedRow();
				if(selectdRow==-1){
					
				}
				else{
					try {
						Course course = new function.Adm_Main_controll().getCourse(T_model_college.getValueAt(selectdRow,0).toString());
						new function.Adm_Main_controll().updateCollege(course, message);
						JOptionPane.showMessageDialog(this, "修改成功!");
						//更新表格数据
						T_model_college = new DefaultTableModel(init_details_college("all"),tableTitle_college);
						jtab_college.setModel(T_model_college);
						jtab_college.setRowSelectionInterval(selectdRow , selectdRow );
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this,"修改失败！");
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this,"修改失败！");
						e1.printStackTrace();
					}
				}
				
				
			}
			
			if(e.getSource()==jb_college_add){
				String []message = this.getMessage_college();
				try {
					if(new function.Adm_Main_controll().isCidExist(message[0])){
						JOptionPane.showMessageDialog(this,"增加课程失败，该课程已存在！");
					}
					else{
						new function.Adm_Main_controll().addCourse(message);
						JOptionPane.showMessageDialog(this, "增加课程成功！");
						T_model_college = new DefaultTableModel(init_details_college("all"),tableTitle_college);
						jtab_college.setModel(T_model_college);
						jtab_college.setRowSelectionInterval(T_model_college.getRowCount()-1,T_model_college.getRowCount()-1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
			if(e.getSource()==jb_college_del){
				int selectdRow = jtab_college.getSelectedRow();
				if(selectdRow==-1){
					
				}
				else{
					Course course;
					try {
						course = new function.Adm_Main_controll().getCourse(T_model_college.getValueAt(selectdRow,0).toString());
						new function.Adm_Main_controll().delCourse(course);
						JOptionPane.showMessageDialog(this,"删除成功！");
						T_model_college = new DefaultTableModel(init_details_college("all"),tableTitle_college);
						jtab_college.setModel(T_model_college);
						jtab_college.setRowSelectionInterval(T_model_college.getRowCount()-1,T_model_college.getRowCount()-1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
			
			if(e.getSource()==jb_college_search){
				try {
					ArrayList<Course> courses = new function.Adm_Main_controll().searchCourse(jt_college_search.getText());
					T_model_college = new DefaultTableModel(init_details_college("search"),tableTitle_college);
					jtab_college.setModel(T_model_college);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
			
			
			//学生管理
			if(e.getSource()==jb_student_clear){
				jt_student_id.setText("");
				jt_student_name.setText("");
				jt_student_sex.setText("");
				jt_student_born.setText("");
				jt_student_nation.setText("");
				jt_student_face.setText("");
				jt_student_college.setText("");
				jt_student_major.setText("");
				jt_student_class.setText("");
				jt_student_pw.setText("");
				jt_student_hidden.setText("");
				jl_student_img.setIcon(null);
			}
			if(e.getSource()==jb_student_change){
				String message[] = this.getMessage_student(); //得到文本框的信息
				int selectdRow =  jtab_student.getSelectedRow();
				if(selectdRow==-1){
					
				}
				else{
					try {
						Student student = new function.Adm_Main_controll().getStudent(T_model_student.getValueAt(selectdRow,0).toString());
						new function.Adm_Main_controll().updateStudent(student, message);
						JOptionPane.showMessageDialog(this, "修改成功!");
						//更新表格数据
						T_model_student.setDataVector(init_details_student("all"),tableTitle_student);
						jtab_student.setModel(T_model_student);
						jtab_student.setRowSelectionInterval(selectdRow , selectdRow );
						//将照片路径表格列隐藏
						DefaultTableColumnModel dcm = (DefaultTableColumnModel)jtab_student .getColumnModel();//获取列模型  
						 dcm.getColumn(12).setMinWidth(0);  //将第一列的最小宽度、最大宽度都设置为0，就看不到了
						 dcm.getColumn(12).setMaxWidth(0);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, "修改失败!");
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, "修改失败!");
						e1.printStackTrace();
					}
				}
			}
			
			if(e.getSource()==jb_student_add){
				String []message = this.getMessage_student();
				try {
					if(new function.Adm_Main_controll().isSidExist(message[0])){
						JOptionPane.showMessageDialog(this,"增加失败，该学生已存在！");
					}
					else{
						new function.Adm_Main_controll().addStudent(message);
						JOptionPane.showMessageDialog(this, "增加成功！");
						T_model_student = new DefaultTableModel(init_details_student("all"),tableTitle_student);
						jtab_student.setModel(T_model_student);
						//将照片路径表格列隐藏
						DefaultTableColumnModel dcm = (DefaultTableColumnModel)jtab_student .getColumnModel();//获取列模型  
						 dcm.getColumn(12).setMinWidth(0);  //将第一列的最小宽度、最大宽度都设置为0，就看不到了
						 dcm.getColumn(12).setMaxWidth(0);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			//删除学生
			if(e.getSource()==jb_student_del){
				int selectdRow = jtab_student.getSelectedRow();
				if(selectdRow==-1){
					
				}
				else{
					Student student;
					try {
						student = new function.Adm_Main_controll().getStudent(T_model_student.getValueAt(selectdRow,0).toString());
						
						System.out.println(T_model_student.getValueAt(selectdRow,0).toString());
						new function.Adm_Main_controll().delStudent(student);
						JOptionPane.showMessageDialog(this,"删除成功！");
						T_model_student = new DefaultTableModel(init_details_student("all"),tableTitle_student);
						jtab_student.setModel(T_model_student);
						jtab_student.setRowSelectionInterval(T_model_student.getRowCount()-1,T_model_student.getRowCount()-1);
						//将照片路径表格列隐藏
						DefaultTableColumnModel dcm = (DefaultTableColumnModel)jtab_student .getColumnModel();//获取列模型  
						 dcm.getColumn(12).setMinWidth(0);  //将第一列的最小宽度、最大宽度都设置为0，就看不到了
						 dcm.getColumn(12).setMaxWidth(0);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this,"删除失败！");
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this,"删除失败！");
						e1.printStackTrace();
					}
					
				}
			}
			
			//查找学生
			if(e.getSource()==jb_student_check){
				try {
					ArrayList<Student> student = new function.Adm_Main_controll().searchStudent(jt_student_search.getText());
					T_model_student = new DefaultTableModel(init_details_student("search"),tableTitle_student);
					jtab_student.setModel(T_model_student);
					//将照片路径表格列隐藏
					DefaultTableColumnModel dcm = (DefaultTableColumnModel)jtab_student .getColumnModel();//获取列模型  
					 dcm.getColumn(12).setMinWidth(0);  //将第一列的最小宽度、最大宽度都设置为0，就看不到了
					 dcm.getColumn(12).setMaxWidth(0);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			//更换图片
			if(e.getSource()==jb_student_img){
				int selectRow = jtab_student.getSelectedRow();
				String img_path = new function.Adm_Main_controll().getImg_path();
				jt_student_hidden.setText(img_path);
				jl_student_img.setIcon(new ImageIcon(img_path));
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		//得到课程文本框的课程信息
		public String[] getMessage_college(){
			String message[] = {
					jt_college_num.getText(),
					jt_college_name.getText(),
					jt_college_teacher.getText(),
					jt_college_type.getText(),
					jt_college_score.getText(),
					jt_college_time.getText(),
					jt_college_day.getText(),
					jt_college_session.getText(),
					jt_college_object.getText(),
					jt_college_sum.getText(),
					jt_college_surplus.getText()	
			};
			return message;
		}
		
		
		
		//初始化details ,课程
		public Object[][] init_details_college(String s) throws SQLException, ClassNotFoundException{
			if(s.equals("all")){
				courses = new function.Stu_MainControll().getCourse(); //得到所有课程，保存在集合
			}
			if(s.equals("search")){
				courses =new function.Adm_Main_controll().searchCourse(jt_college_search.getText()); //得到所有查找到的课程
			}
			
			Object [][]college_details = new Object[courses.size()][11];
			for(int i=0;i<courses.size();i++){
				college_details[i][0] = courses.get(i).getCid();
				college_details[i][1] = courses.get(i).getCname();
				college_details[i][2] = courses.get(i).getTeacher();
				college_details[i][3] = courses.get(i).getCoursetype();
				college_details[i][4] = courses.get(i).getCredit();
				college_details[i][5] = courses.get(i).getTime();
				college_details[i][6] = courses.get(i).getDay();
				college_details[i][7] = courses.get(i).getSection();
				college_details[i][8] = courses.get(i).getObject();
				college_details[i][9] = courses.get(i).getNum();
				college_details[i][10] = courses.get(i).getAllowance();
			}
			return college_details;
		}
		
		//初始化学生表格
		
		public Object[][] init_details_student(String s) throws SQLException, ClassNotFoundException{
			if(s.equals("all")){
				students = new function.Adm_Main_controll().getStudents();
			}
			if(s.equals("search")){
				students = new function.Adm_Main_controll().searchStudent(jt_student_search.getText());
				//students = new controller.Adm_Main_controll().searchStudent(jt_student_search.getText().toString());
			}
			Object[][] message = new Object[students.size()][13];
			for(int i=0;i<students.size();i++){
				message[i][0] = students.get(i).getSid();
				message[i][1] = students.get(i).getSname();
				message[i][2] = students.get(i).getSex();
				message[i][3] = students.get(i).getBorndate();
				message[i][4] = students.get(i).getNation();
				message[i][5] = students.get(i).getFace();
				message[i][6] = students.get(i).getCollege();
				message[i][7] = students.get(i).getMajor();
				message[i][8] = students.get(i).getSclass();
				message[i][9] = students.get(i).getSelectcredit();
				message[i][10] = students.get(i).getSumcredit();
				message[i][11] = students.get(i).getPassword();
				message[i][12] = students.get(i).getImg_path();
			}
			
			return message;
		}
		public String[] getMessage_student(){
			String message[] = {
					jt_student_id.getText(),
					jt_student_name.getText(),
					jt_student_sex.getText(),
					jt_student_born.getText(),
					jt_student_nation.getText(),
					jt_student_face.getText(),
					jt_student_college.getText(),
					jt_student_major.getText(),
					jt_student_class.getText(),
					jt_student_pw.getText(),
					jt_student_hidden.getText().replaceAll("\\\\","//")
					
			};
			return message;
		}
		
		
}

