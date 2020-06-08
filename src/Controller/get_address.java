package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.model;

/**
 * Servlet implementation class get_address
 */
public class get_address extends HttpServlet {
	public void service(HttpServletRequest x,HttpServletResponse y)
	 {
		String phone=x.getParameter("phone");
		
		 //System.out.println(phone);
		 model m=new model();
		 m.setPhone(phone);
		 boolean res=m.get_address();
		 if(res==true)
		 {
			 String addr=m.getAddress();
			 
			 HttpSession hs=x.getSession();
			 hs.setAttribute("addr",addr); 
			 try {
				y.sendRedirect("/Project/view_address.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
		 else
		 {
			 try {
					y.sendRedirect("/Project/view_address_fails.html");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
		 }
		 
		 
		 
	 
		
	 }

}
