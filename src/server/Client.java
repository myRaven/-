package server;
import java.io.*;
import java.net.*;
import model.Student;
import model.Teacher;

public class Client implements Protocal{

	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	public Client() throws UnknownHostException, IOException{
		
		String ip ="";
		InetAddress myip= InetAddress.getLocalHost();
		try{
		System.out.println("你的IP地址是："+myip.getHostAddress());
			System.out.println("主机名为："+myip.getHostName()+"。");
			}catch(Exception e){
			e.printStackTrace();
			}
		ip=myip.getHostAddress();
	
		
		int port = 3003;
		Socket s = new Socket(ip,port);
		oos = new ObjectOutputStream(s.getOutputStream());  //获得输出流
		ois = new ObjectInputStream(s.getInputStream());    //获得输入流
	}
	
	public Student slogin(String sid,String spw) throws IOException, ClassNotFoundException{
		
		oos.writeInt(SLOGIN);
		oos.flush();
		oos.writeUTF(sid);
		oos.flush();
		oos.writeUTF(spw);
		oos.flush();
		Student s=(Student) ois.readObject();
		return s;
	}
    public Teacher tlogin(String tid,String tpw) throws IOException, ClassNotFoundException{
		
		oos.writeInt(TLOGIN);
		oos.flush();
		oos.writeUTF(tid);
		oos.flush();
		oos.writeUTF(tpw);
		oos.flush();
		Teacher s=(Teacher) ois.readObject();
		return s;
	}
}