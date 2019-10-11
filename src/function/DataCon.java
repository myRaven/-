package function;

import java.sql.*;

public class DataCon {
	public static Connection conn = null;
	
	public DataCon(){
		getCon();
	}
	public static Connection getCon()  {
		if(conn==null){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("找到Mysql数据库驱动程序");
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				System.out.println("在类路径上找不到Mysql驱动程序，" + "请检查类路径上是否加载mysql的jar包!");
			}
			try {
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentmanager" +			//127.0.0.1
						"?useUnicode=true&characterEncoding=UTF8", "root", "1234");
				System.out.println("建立数据库连接成功");

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("创建数据库连接失败！");
			}
		}
		return conn;
	}
}

  