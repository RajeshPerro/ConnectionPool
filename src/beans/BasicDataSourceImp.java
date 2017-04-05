package beans;

import java.sql.DriverManager;
import java.util.Date;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class BasicDataSourceImp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/DATABASE_NAME?autoReconnect=true&useSSL=false");
		bds.setUsername("USERNAME");
		bds.setPassword("PASSWORD");
		bds.setMaxActive(10);
		bds.setMaxIdle(5);
		bds.setMaxWait(1000*5);
		
//		Here we are checking the database connection from our connection pool
		
		Date d1 = new Date();
		
		for(int i=0 ; i< 200000 ; i++)
		{
				try {
					java.sql.Connection con =  bds.getConnection();
					System.out.println("Connection : "+i);
					con.close();
					} 
				catch (Exception e) 
				{
				e.printStackTrace();
				}

		}
		Date d2 = new Date();
		
		

//		Now lets connect with Database directly and we will see the difference.
		Date d3 = new Date();
		
		for(int i=0 ; i< 200000 ; i++)
		{
				try {
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DATABASE_NAME?autoReconnect=true&useSSL=false","USERNAME","PASSWORD");
					System.out.println("Connection : "+i);
					con.close();
					} 
				catch (Exception e) 
				{
				e.printStackTrace();
				}

		}
		Date d4 = new Date();
		System.out.println("<<<<----Time for conenction through pool---->>>>>");
		System.out.println("Start Time : "+d1);
		System.out.println("End time : "+d2);
		System.out.println("<<<<<-----Time for direct conenction----->>>>>>");
		System.out.println("Start Time : "+d3);
		System.out.println("End time : "+d4);
	}

}
