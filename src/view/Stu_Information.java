package view;

	import javax.swing.*;

	import java.awt.event.*;
	import java.awt.*;
import java.sql.SQLException;

import method.MyStyle;
import model.Student;

	public class Stu_Information extends JFrame implements ActionListener{
		
		private JButton jb_return;
		private JTextField jt_id,jt_name,jt_sex,jt_nation,jt_face,jt_college,jt_major,jt_class,jt_born,jt_credit;
		private JButton jb_check;
		private JButton jb_true = new JButton("提交");
		private JTextField jt_true = new JTextField();
		public JLabel jl_tou;
		Student student;
		public Stu_Information(Student student){
			this.student = student;
			init();
		}
		public void init(){
			this.setTitle("我的信息");
			this.setSize(1100,750);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setResizable(false); //设置不能改变窗口大小
			this.setIconImage(new ImageIcon("images/窗口图标.png").getImage()); //设置窗口图片
			
			MyStyle style = new MyStyle();
			
			JPanel jp = new JPanel();
			jp.setLayout(new BorderLayout());
			this.add(jp,BorderLayout.CENTER);
			
			//标题标签
			JLabel jl_title = new JLabel("个 人 信 息");
			jl_title.setHorizontalAlignment(SwingConstants.CENTER);
			jl_title.setFont(new Font("幼圆",Font.BOLD,30));
			style.setColor(jl_title,new Color(0,185,253),new Color(244,188,3));
			jp.add(jl_title,BorderLayout.PAGE_START);
			
				
			
			//文本个人信息
			JPanel jp_left = new JPanel();
			jp_left.setPreferredSize(new Dimension(500,100));
			jp_left.setLayout(new GridLayout(12,2,20,20));
			style.setColor(jp_left,null,new Color(47,183,231));
			
			jp_left.add(new JLabel(" "));
			jp_left.add(new JLabel(" "));
			
			//学号
			JLabel jl_id = new JLabel("学号:");
			style.setColor(jl_id,Color.white,null);
			jl_id.setHorizontalAlignment(SwingConstants.RIGHT);
			jl_id.setFont(new Font("幼圆",Font.BOLD,20));
			jp_left.add(jl_id);	
			
			jt_id = new JTextField();
			jt_id.setFont(new Font("幼圆",Font.BOLD,20));
			style.setColor(jt_id,Color.white,null);
			jt_id.setSize(100,30);
			jt_id.setBorder (null);
			jt_id.setBackground (null);
			jp_left.add(jt_id);
			
			//姓名
			JLabel jl_name = new JLabel("姓名:");
			style.setColor(jl_name,Color.white,null);
			jl_name.setHorizontalAlignment(SwingConstants.RIGHT);
			jl_name.setFont(new Font("幼圆",Font.BOLD,20));
			jp_left.add(jl_name);	
			
			jt_name = new JTextField();
			jt_name.setFont(new Font("幼圆",Font.BOLD,20));
			style.setColor(jt_name,Color.white,null);
			jt_name.setSize(100,30);
			jt_name.setBorder (null);
			jt_name.setBackground (null);
			jp_left.add(jt_name);
			
			//性别
			JLabel jl_sex = new JLabel("性别:");
			style.setColor(jl_sex,Color.white,null);
			jl_sex.setHorizontalAlignment(SwingConstants.RIGHT);
			jl_sex.setFont(new Font("幼圆",Font.BOLD,20));
			jp_left.add(jl_sex);
			
			jt_sex = new JTextField();
			jt_sex.setFont(new Font("幼圆",Font.BOLD,20));
			style.setColor(jt_sex,Color.white,null);
			jt_sex.setSize(100,30);
			jt_sex.setBorder (null);
			jt_sex.setBackground (null);
			jp_left.add(jt_sex);
			
			//出生日期
			JLabel jl_born = new JLabel("出生日期:");
			style.setColor(jl_born,Color.white,null);
			jl_born.setHorizontalAlignment(SwingConstants.RIGHT);
			jl_born.setFont(new Font("幼圆",Font.BOLD,20));
			jp_left.add(jl_born);	
			
			jt_born = new JTextField();
			jt_born.setFont(new Font("幼圆",Font.BOLD,20));
			style.setColor(jt_born,Color.white,null);
			jt_born.setSize(100,30);
			jt_born.setBorder (null);
			jt_born.setBackground (null);
			jp_left.add(jt_born);
			
			//民族
			JLabel jl_nation = new JLabel("民族:");
			style.setColor(jl_nation,Color.white,null);
			jl_nation.setHorizontalAlignment(SwingConstants.RIGHT);
			jl_nation.setFont(new Font("幼圆",Font.BOLD,20));
			jp_left.add(jl_nation);	
			
			jt_nation = new JTextField();
			jt_nation.setFont(new Font("幼圆",Font.BOLD,20));
			style.setColor(jt_nation,Color.white,null);
			jt_nation.setSize(100,30);
			jt_nation.setBorder (null);
			jt_nation.setBackground (null);
			jp_left.add(jt_nation);
			
			//政治面貌
			JLabel jl_face = new JLabel("政治面貌:");
			jl_face.setHorizontalAlignment(SwingConstants.RIGHT);
			style.setColor(jl_face,Color.white,null);
			jl_face.setFont(new Font("幼圆",Font.BOLD,20));
			jp_left.add(jl_face);	
			
			jt_face = new JTextField();
			jt_face.setFont(new Font("幼圆",Font.BOLD,20));
			style.setColor(jt_face,Color.white,null);
			jt_face.setSize(100,30);
			jt_face.setBorder (null);
			jt_face.setBackground (null);	
			jp_left.add(jt_face);
			
			//学院
			JLabel jl_college = new JLabel("学院:");
			jl_college.setHorizontalAlignment(SwingConstants.RIGHT);
			style.setColor(jl_college,Color.white,null);
			jl_college.setFont(new Font("幼圆",Font.BOLD,20));
			jp_left.add(jl_college);	
			
			jt_college = new JTextField();
			jt_college.setFont(new Font("幼圆",Font.BOLD,17));
			style.setColor(jt_college,Color.white,null);
			jt_college.setSize(100,30);
			jt_college.setBorder (null);
			jt_college.setBackground (null);	
			jp_left.add(jt_college);
			
			//专业
			JLabel jl_major = new JLabel("专业:");
			jl_major.setHorizontalAlignment(SwingConstants.RIGHT);
			style.setColor(jl_major,Color.white,null);
			jl_major.setFont(new Font("幼圆",Font.BOLD,20));
			jp_left.add(jl_major);	
			
			jt_major = new JTextField();
			jt_major.setFont(new Font("幼圆",Font.BOLD,17));
			style.setColor(jt_major,Color.white,null);
			jt_major.setSize(100,30);
			jt_major.setBorder (null);
			jt_major.setBackground (null);
			jp_left.add(jt_major);
			
			
			//班级
			JLabel jl_class = new JLabel("班级:");
			jl_class.setHorizontalAlignment(SwingConstants.RIGHT);
			jl_class.setFont(new Font("幼圆",Font.BOLD,20));
			style.setColor(jl_class,Color.white,null);
			jp_left.add(jl_class);	
			
			jt_class = new JTextField();
			jt_class.setFont(new Font("幼圆",Font.BOLD,20));
			style.setColor(jt_class,Color.white,null);
			jt_class.setSize(100,30);
			jt_class.setBorder (null);
			jt_class.setBackground (null);
			jp_left.add(jt_class);
			jp.add(jp_left,BorderLayout.WEST);
			
			//已通过课程总学分
			JLabel jl_crdit = new JLabel("已通过课程学分:");
			jl_crdit.setHorizontalAlignment(SwingConstants.RIGHT);
			jl_crdit.setFont(new Font("幼圆",Font.BOLD,20));
			style.setColor(jl_crdit,Color.white,null);
			jp_left.add(jl_crdit);	
			
			jt_credit = new JTextField();
			jt_credit.setFont(new Font("幼圆",Font.BOLD,20));
			style.setColor(jt_credit,Color.white,null);
			jt_credit.setSize(100,30);
			jt_credit.setBorder (null);
			jt_credit.setBackground (null);
			jp_left.add(jt_credit);
			jp.add(jp_left,BorderLayout.WEST);
			
			//设置文本框不能编辑
			jt_id.setEditable(false);
			jt_name.setEditable(false);
			jt_sex.setEditable(false);
			jt_born.setEditable(false);
			jt_face.setEditable(false);
			jt_nation.setEditable(false);
			jt_college.setEditable(false);
			jt_class.setEditable(false);
			jt_credit.setEditable(false);
			jt_major.setEditable(false);
			
			//右边面板
			JPanel jp_right = new JPanel();
			jp_right.setLayout(null);
			jp_right.setPreferredSize(new Dimension(500,100));
			style.setColor(jp_right,null,new Color(47,183,231));
			
			
			//头像标签
			ImageIcon img_tou = new ImageIcon("images/头  像.jpg");
			jl_tou = new JLabel(img_tou);
			jl_tou.setBounds(100,100,144,172);
			jp_right.add(jl_tou);
			jp.add(jp_right,BorderLayout.LINE_END);
			
			//头像大小tips标签
			JLabel jl_tip = new JLabel("照片像素（宽×高）为：144×172");
			jl_tip.setBounds(80,280,250,30);
			jl_tip.setFont(new Font("幼圆",Font.BOLD,13));
			style.setColor(jl_tip,Color.white,null);
			//style.setColor(jl_tip,Color.red,null);
			jp_right.add(jl_tip);
			
			//背景
			ImageIcon img1 = new ImageIcon("images/Information_bg.png");
			JLabel jl_img1 = new JLabel(img1);
			jl_img1.setBounds(300,0,200,200);
			
			ImageIcon img2 = new ImageIcon("images/Information_bg2.png");
			JLabel jl_img2 = new JLabel(img2);
			jl_img2.setBounds(300,400,200,200);
			
			ImageIcon img3 = new ImageIcon("images/Information_bg3.png");
			JLabel jl_img3 = new JLabel(img3);
			jl_img3.setBounds(-80,325,300,300);
			
			ImageIcon img4 = new ImageIcon("images/Information_bg4.png");
			JLabel jl_img4 = new JLabel(img4);
			jl_img4.setBounds(0,0,200,200);
			jp_right.add(jl_img1);
			jp_right.add(jl_img2);
			jp_right.add(jl_img3);
			jp_right.add(jl_img4);
			
			
			//背景图片标签(后来)
			//ImageIcon img_bg = new ImageIcon("images/Main_Interface_bg.png");
			//JLabel jl_img_bg = new JLabel(img_bg);
			//jl_img_bg.setBounds(0,0,800,533);
			//jp.add(jl_img_bg);
			
			
			//更改密码按钮
			jb_check = new JButton("修改密码");
			jb_check.setFont(new Font("幼圆",Font.BOLD,20));
			style.setColor(jb_check,new Color(0,185,253),new Color(244,188,3));
			jb_check.setBounds(115,330,130,30);
			jp_right.add(jb_check);
			
			
			//更改密码文本框和按钮		
			jb_true.setBounds(214,330,80,30);
			jb_true.setFont(new Font("幼圆",Font.BOLD,20));
			jb_true.hide();
			jp_right.add(jb_true);
			
			jt_true.setBounds(60,330,150,30);
			jt_true.setFont(new Font("幼圆",Font.BOLD,15));
			jt_true.hide();
			jp_right.add(jt_true);
			
			
			//中间的面板
			JPanel jp_center = new JPanel();
			style.setColor(jp_center,null,new Color(47,183,231));
			jp.add(jp_center);
			
			//返回按钮
			jb_return = new JButton("返 回");
			jb_return.setSize(100,30);
			jb_return.setFont(new Font("幼圆",Font.BOLD,26));
			style.setColor(jb_return,new Color(0,185,253),new Color(244,188,3));
			jp.add(jb_return,BorderLayout.PAGE_END);
			
			//添加监听器
			jb_return.addActionListener(this);
			jb_check.addActionListener(this);
			jb_true.addActionListener(this);
			
			
			//初始化值
			jt_id.setText(student.getSid());
			jt_name.setText(student.getSname());
			jt_sex.setText(student.getSex());
			jt_born.setText(student.getBorndate());
			jt_face.setText(student.getFace());
			jt_nation.setText(student.getNation());
			jt_college.setText(student.getCollege());
			jt_class.setText(student.getSclass());
			jt_credit.setText(student.getSumcredit()+"");
			jt_major.setText(student.getMajor());
			jl_tou.setIcon(new ImageIcon(student.getImg_path()));
			
			
			this.setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jb_return){
				new Stu_Main(view.Login.student);
				this.setVisible(false);
			}
			if(e.getSource()==jb_check){
				jb_true.show();
				jt_true.show();
				jb_check.hide();
			}
			if(e.getSource()==jb_true){
				int isChange = JOptionPane.showConfirmDialog(this, "是否确定修改？");
				if(isChange==0){
					try {
						if(new function.Stu_Information_Controll().changePassword(jt_true.getText(), student)){
							JOptionPane.showMessageDialog(this, "修改成功！");
						}
						else JOptionPane.showMessageDialog(this, "请填写密码!");
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else if(isChange==1){
					JOptionPane.showMessageDialog(this, "修改失败！");
				}
				
				jb_check.show();
				jt_true.hide();
				jb_true.hide();
			}
			
		}
}
