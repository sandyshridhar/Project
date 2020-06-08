package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.model;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	 
	public void service(HttpServletRequest x,HttpServletResponse y)
	 {
		String name=x.getParameter("name");
		String phone=x.getParameter("phone");
		String address=x.getParameter("address");
		
		 
		model m=new model();
		m.setName(name);
		m.setPhone(phone);
		m.setAddress(address);
		
		boolean res=m.register();
		if(res==true)
		{
			try {
				y.sendRedirect("/Project/success.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		else
		{
			try {
				y.sendRedirect("/Project/error.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	 }
 
}
