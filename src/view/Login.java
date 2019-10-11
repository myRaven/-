package view;

import javax.swing.*;


import function.Login_controll;

import method.MyStyle;
import model.Student;
import model.Teacher;
import server.Client;
import server.Server;

import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener{
	private JButton jb_login,jb_delete;
	private JRadioButton jr_stu ,jr_adm;
	JTextField jt_id;
	JPasswordField pass_pw;
	public Login(){
		
		init();
	}
	public void init(){
		
	    MyStyle style = new MyStyle();
	    
		this.setTitle("登录");
		this.setSize(700,463);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false); //设置不能改变窗口大小
		this.setIconImage(new ImageIcon("images/窗口栏标签.png").getImage()); //设置窗口图片
		//面板
		JPanel jp = new JPanel();
		jp.setLayout(null);
		jp.setBounds(0,0,700,463);
		
		//背景图片标签
		ImageIcon img = new ImageIcon("images/Login_bg.png");
		JLabel jl_img = new JLabel(img);
		jl_img.setBounds(0,0,700,463);
		
		//标题
		JLabel jl_title = new JLabel("在线抢课系统");
		jl_title.setFont(new Font("幼圆",Font.BOLD,30));
		jl_title.setBounds(220,10,200,40);
		style.setColor(jl_title,Color.white,null);
		jl_title.setHorizontalAlignment(SwingConstants.CENTER);
		jp.add(jl_title);
		
		//账号标签文本框
		JLabel jl_id = new JLabel("用户名:");
		jl_id.setBounds(290,110,100,30);
		jl_id.setFont(new Font("幼圆",Font.BOLD,20));
		style.setColor(jl_id,Color.white,null);
		jp.add(jl_id);
		
		jt_id = new JTextField();
		jt_id.setBounds(380,110,200,30);
		jt_id.setFont(new Font("幼圆",Font.BOLD,20));
		jp.add(jt_id);
		
		
		//密码标签密码框
		JLabel jl_pw = new JLabel("密  码:");
		jl_pw.setBounds(290,160,100,30);
		jl_pw.setFont(new Font("幼圆",Font.BOLD,20));
		style.setColor(jl_pw,Color.white,null);
		jp.add(jl_pw);
		
		pass_pw = new JPasswordField();
		pass_pw.setBounds(380,160,200,30);
		pass_pw.setFont(new Font("幼圆",Font.BOLD,15));
		jp.add(pass_pw);
		
		
		//单选框
		jr_stu = new JRadioButton("学生");
		jr_stu.setBounds(350,230,100,30);
		jr_stu.setFont(new Font("幼圆",Font.BOLD,17));
		style.setColor(jr_stu,Color.white,null);
		jr_stu.setOpaque(false);
		jp.add(jr_stu);
		
		jr_adm = new JRadioButton("管理员");
		jr_adm.setBounds(440,230,100,30);
		jr_adm.setFont(new Font("幼圆",Font.BOLD,17));
		style.setColor(jr_adm,Color.white,null);
		jr_adm.setOpaque(false);
		jp.add(jr_adm);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(jr_adm);
		bg.add(jr_stu);
		
		
		//登录按钮 
		jb_login  = new JButton("登 录");
		jb_login.setBounds(300,290,120,30);
		jb_login.setFont(new Font("幼圆",Font.BOLD,20));
		style.setColor(jb_login,new Color(0,185,253),new Color(244,188,3));
		jp.add(jb_login);
		
		
		//添加事件
		jb_login.addActionListener(this);
		
		//清除按钮 
		jb_delete= new JButton("置 空");
		jb_delete.setBounds(460,290,120,30);
		jb_delete.setFont(new Font("幼圆",Font.BOLD,20));
		style.setColor(jb_delete,new Color(0,185,253),new Color(244,188,3));
		jp.add(jb_delete);
		
		//添加事件
		jb_delete.addActionListener(this);
		
		
		this.add(jp);
		jp.add(jl_img);
		this.setVisible(true);
	}
	
	public static void main(String[] args){
   	 try
	    {
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	        //TODO exception
	    }
   	 new Login();
    }
	
	public static Student student;
	public static Teacher teacher;
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		//学生登录
		String name=jt_id.getText();
		String pw=pass_pw.getText();
		if(e.getActionCommand().equals("取消")){
			this.jt_id.setText("");
			this.pass_pw.setText("");
			//bg.clearSelection();
		}
		if(jr_stu.isSelected()){
			if(e.getSource()==jb_login){
				//Student student;
				try{
					Client c = new Client();
					student=c.slogin(name,pw);

					if(student!=null){
						//JOptionPane.showMessageDialog(this,"欢迎学生："+this.jt_id.getText()+"登录");
						new Stu_Main(student);
						this.hide();
					}else
						JOptionPane.showMessageDialog(this,"用户名或密码错误");
				}catch (Exception e1){
					JOptionPane.showMessageDialog(this,e1.getMessage());
				}
            }
			
		}
		
		//管理员
	  if(jr_adm.isSelected()){
			if(e.getSource()==jb_login){
				//Teacher student;
				try{
					Client c = new Client();
					teacher=c.tlogin(name,pw);
//					student =ModelFactory.tlogin(Integer.parseInt(name),pw);
					if(teacher!=null){
						//JOptionPane.showMessageDialog(this,"欢迎老师："+this.jt_id.getText()+"登录");
						new Adm_Main(teacher);
						this.hide();
					}else
						JOptionPane.showMessageDialog(this,"用户名或密码错误");
				}catch (Exception e1){
					JOptionPane.showMessageDialog(this,e1.getMessage());
				}
		}
		}
	
	  
		//清 空
		if(e.getSource()==jb_delete){
			jt_id.setText("");
			pass_pw.setText("");
		}
		
	}
}
