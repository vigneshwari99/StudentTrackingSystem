package com.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Staff;
import com.beanDao.BeanDao;

@WebServlet("/Login")
public class Login extends HttpServlet{
	
protected void doPost(HttpServletRequest request,HttpServletResponse response){
	try
	{	    

	      Staff e = new Staff();
	     e.setEmail(request.getParameter("email"));
	     e.setPass(request.getParameter("pass"));
        
         
        
	     e = BeanDao.login(e);
		   		    
	     if (e.isValid())
	     {
		        
	          HttpSession session = request.getSession(true);	    
	          session.setAttribute("currentSessionUser",e); 
	          response.sendRedirect("HomePage.jsp"); //logged-in page      		
	     }
		        
	     else 
	          response.sendRedirect("index.jsp"); //error page 
	} 
			
			
	catch (Throwable theException) 	    
	{
	     System.out.println(theException); 
	}
	
}
}
