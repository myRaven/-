package server;
import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.Date;

import function.Login_controll;
import model.Student;
import model.Teacher;


public class Server implements Protocal {
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public Server() throws IOException,UnknownHostException,ClassNotFoundException, SQLException{
		int port = 3003;
		ServerSocket ss = new ServerSocket(port);
		System.out.println("服务区创建中~请稍等！");
		int count = 1;
		while(true){
			Socket s = ss.accept();
			System.out.println("第"+count+"用户访问，IP地址为："+s.getInetAddress()+new Date());
			count++;
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
			int command = ois.readInt();
			if(command==SLOGIN){
				slogin();
			}else if(command==TLOGIN){
				tlogin();
			}
				
		}
	}
   public void slogin() throws IOException, ClassNotFoundException, SQLException{
		String sid =ois.readUTF();
		String spw =ois.readUTF();
		Student s = new Login_controll().slogin(sid,spw);
		oos.writeObject(s);
		oos.flush();
			}
    public void tlogin() throws IOException, ClassNotFoundException, SQLException{
    	String tid=ois.readUTF();
		String tpw=ois.readUTF();
		Teacher s=new function.Login_controll().tlogin(tid,tpw);
		oos.writeObject(s);
		oos.flush();
		
	}
    public static void main(String[] args) {
		try {
			new Server();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
