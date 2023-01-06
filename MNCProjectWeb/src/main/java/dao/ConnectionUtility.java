package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;

public class ConnectionUtility {
	
static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}

private static ThreadLocal<Connection> clockroom=new ThreadLocal<Connection>();

public static Connection getConnection() {
	try {
		Connection con=clockroom.get();
		if(con==null) {
			con=DriverManager.getConnection("jdbc:mysql://localhost/mncpro","root","Innamul@mysql");
			con.setAutoCommit(false);
			clockroom.set(con);
			return con;
			
		
		}else {
			return con;
		}
	}catch(Exception e) {
		e.printStackTrace();
		return null;
	}
}

public static void closeConnection(Exception e, Savepoint sp) {
	try {
		Connection con=clockroom.get();
		if(con!=null) {
			if(e==null) {
				con.commit();
			}
			else{
			if(sp==null) {
				con.rollback();
		}
			else {
				con.rollback(sp);
				con.commit();
			}
		}
	}
	con.close();
	clockroom.remove();
	}catch(Exception ex) {
		ex.printStackTrace();
		
	}
	
}
}
