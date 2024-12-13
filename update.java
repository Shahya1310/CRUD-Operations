package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class update {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String username="root";
	private static final String password="root";
	private static final String url="jdbc:mysql://localhost:3306/std";
	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		try {
			Scanner scr=new Scanner(System.in);
			Class.forName(Driver);
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("enter table name");
			String sql="update "+scr.next()+" set id=?,name=?,email=?,password=? where id=?";
			pmst=conn.prepareStatement(sql);
			System.out.println("enter id");
			pmst.setString(1, scr.next());
			System.out.println("enter name");
			pmst.setString(2, scr.next());
			System.out.println("enter email");
			pmst.setString(3, scr.next());
			System.out.println("enter password");
			pmst.setString(4, scr.next());
			System.out.println("provide id");
			pmst.setString(5, scr.next());
			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("updated succesfully");
			}
			else {
				System.out.println("error");
			}
			conn.close();
			pmst.close();
			scr.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
