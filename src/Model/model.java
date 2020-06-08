package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class model {

	String url="jdbc:oracle:thin:@//localhost:1521/XE";
	String uname="system";
	String pwd="system";
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	
	
	String name=null;
	String phone=null;
	String address=null;
	
	public model()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url, uname, pwd);
			System.out.println("Driver loaded and Connection established");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean register()
	{
		try {
			pstmt=con.prepareStatement("INSERT INTO task_register VALUES(?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			int c=pstmt.executeUpdate();
			System.out.println("Query executed");
			if(c==1)
			{
				return true;
			}
			else
			{
				return  false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean get_address()
	{
		try {
			pstmt=con.prepareStatement("SELECT * FROM task_register WHERE phone=?");
			pstmt.setString(1, phone);
			res=pstmt.executeQuery();
			System.out.println("query executed");
			while(res.next()==true)
			{
				 address=res.getString(3);
				 System.out.println(address);
				 return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
}
