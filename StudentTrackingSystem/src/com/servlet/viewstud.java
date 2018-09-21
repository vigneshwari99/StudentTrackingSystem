package com.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Student;
import com.beanDao.BeanDao;
@WebServlet("/viewstud")
public class viewstud extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

	try{
		String roll = request.getParameter("roll");
		int no = Integer.parseInt(roll);
		Student s = new Student();
	    s = BeanDao.display(s);
	    if (s.isValid())
	     {
		        
	          HttpSession session = request.getSession(true);	    
	          session.setAttribute("currentSessionUser",s); 
	          response.sendRedirect("viewstud.jsp"); //logged-in page      		
	     }
		        
	     else {
	          response.sendRedirect("index.jsp"); //error page 
	} 	
			
		
		
	}catch(Exception e){
	
	
	}
}
}
