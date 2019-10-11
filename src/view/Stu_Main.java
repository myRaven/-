package view;

import javax.swing.*;

import method.MyStyle;
import model.Student;

import java.awt.event.*;
import java.awt.*;

public class Stu_Main extends JFrame implements MouseListener,ActionListener{
	private Student student;
	private JLabel jl_one;
	private JLabel jl_two;
	private JLabel jl_three;
	private JLabel jl_img1;
	private JLabel jl_img2;
	private JLabel jl_img3;
	private JButton jb_secede;
	MyStyle style = new MyStyle();
public Stu_Main(Student student){
	this.student = student;
	init();
}

public void init(){
	
	this.setTitle("欢迎你");
	this.setSize(800,533);
	this.setLocationRelativeTo(null);
	this.setLayout(null);
	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	this.setResizable(false); //设置不能改变窗口大小
	this.setIconImage(new ImageIcon("images/窗口图标.png").getImage()); //设置窗口图片
	
	JPanel jp = new JPanel();
	jp.setLayout(null);
	jp.setBounds(0,0,800,533);
	
	
	
	//标题标签
	JLabel jl_title = new JLabel("欢迎你,"+student.getSname());
	jl_title.setBounds(300,10,300,30);
	jl_title.setFont(new Font("幼圆",Font.BOLD,28));
	style.setColor(jl_title,Color.white,null);
	jp.add(jl_title);
	
	
	//图片标签
	ImageIcon img1 = new ImageIcon("images/Main_one.png");
	jl_img1 = new JLabel(img1);
	jl_img1.setBounds(100,100,200,200);
	jl_img1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //设置鼠标成手型
	jp.add(jl_img1);
	
	
	ImageIcon img2 = new ImageIcon("images/Main_two.png");
	jl_img2 = new JLabel(img2);
	jl_img2.setBounds(300,100,200,200);
	jl_img2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //设置鼠标成手型
	jp.add(jl_img2);
	
	ImageIcon img3 = new ImageIcon("images/Main_three.png");
	jl_img3 = new JLabel(img3);
	jl_img3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //设置鼠标成手型
	jl_img3.setBounds(500,100,200,200);
	jp.add(jl_img3);
	
	//文字标签
	jl_one = new JLabel("学生抢课");
	jl_one.setBounds(160,280,100,30);
	jl_one.setFont(new Font("幼圆",Font.BOLD,20));
	style.setColor(jl_one,Color.white,null);
	jl_one.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //设置鼠标成手型
	jp.add(jl_one);
	
	jl_two = new JLabel("个人课表");
	jl_two.setBounds(360,280,100,30);
	jl_two.setFont(new Font("幼圆",Font.BOLD,20));
	style.setColor(jl_two,Color.white,null);
	jl_two.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //设置鼠标成手型
	jp.add(jl_two);
	
	jl_three = new JLabel("个人信息");
	jl_three.setBounds(560,280,100,30);
	jl_three.setFont(new Font("幼圆",Font.BOLD,20));
	style.setColor(jl_three,Color.white,null);
	jl_three.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //设置鼠标成手型
	jp.add(jl_three);
	
	//添加监听器
	jl_img1.addMouseListener(this);
	jl_img2.addMouseListener(this);
	jl_img3.addMouseListener(this);
	jl_one.addMouseListener(this);
	jl_two.addMouseListener(this);
	jl_three.addMouseListener(this);
	
	//退出按钮 
	jb_secede= new JButton("退 出");
	jb_secede.setBounds(300,370,200,30);
	jb_secede.setFont(new Font("幼圆",Font.BOLD,20));
	style.setColor(jb_secede,new Color(0,185,253),new Color(244,188,3));
	jp.add(jb_secede);
			
	//添加事件
	jb_secede.addActionListener((ActionListener) this);
	
	
	//背景图片标签
	ImageIcon img_bg = new ImageIcon("images/Main_Interface_bg.png");
	JLabel jl_img_bg = new JLabel(img_bg);
	jl_img_bg.setBounds(0,0,800,533);
	jp.add(jl_img_bg);
	
	this.add(jp);
	this.setVisible(true);
}

@Override
public void mouseClicked(MouseEvent e) {
	if(e.getSource()==jl_one||e.getSource()==jl_img1){
		new SelectClass(student);
		this.setVisible(false);
	}
		
	if(e.getSource()==jl_two||e.getSource()==jl_img2){
		new Timetable(student);
		this.setVisible(false);
	}
	if(e.getSource()==jl_three||e.getSource()==jl_img3){
		new Stu_Information(student);
		this.setVisible(false);
	}
	
}

@Override
public void mouseEntered(MouseEvent e) {
	//美化
	if(e.getSource()==jl_one||e.getSource()==jl_img1)
		style.setColor(jl_one,new Color(244,188,3),null);
	if(e.getSource()==jl_two||e.getSource()==jl_img2)
		style.setColor(jl_two,new Color(244,188,3),null);
	if(e.getSource()==jl_three||e.getSource()==jl_img3)
		style.setColor(jl_three,new Color(244,188,3),null);
}

@Override
public void mouseExited(MouseEvent e) {
	//美化
	if(e.getSource()==jl_one||e.getSource()==jl_img1)
		style.setColor(jl_one,Color.white,null);
	if(e.getSource()==jl_two||e.getSource()==jl_img2)
		style.setColor(jl_two,Color.white,null);
	if(e.getSource()==jl_three||e.getSource()==jl_img3)
		style.setColor(jl_three,Color.white,null);
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

public void actionPerformed(ActionEvent e) {
	//退出登录
	if(e.getSource()==jb_secede){
		new  Login();
		this.setVisible(false);
		//this.dispose();
	}
}

}