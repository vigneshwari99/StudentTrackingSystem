package com.servlet;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Student;
import com.beanDao.BeanDao;
@WebServlet("/view")
public class view extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try{
			String roll = request.getParameter("roll");
			int no = Integer.parseInt(roll);
			String date = request.getParameter("date");
			Date d = new  SimpleDateFormat("yyyy-MM-dd").parse(date);
			java.sql.Date sqlDate = new java.sql.Date(d.getTime());
			
			Student s = new Student();
			s.setRoll(no);
			s.setDate(sqlDate);
			
			s = BeanDao.user(s);
   		    
	     if (s.isValid())
	     {
		        
	          HttpSession session = request.getSession(true);	    
	          session.setAttribute("currentSessionUser",s); 
	          response.sendRedirect("studPage.jsp"); //logged-in page      		
	     }
		        
	     else {
	          response.sendRedirect("index.jsp"); //error page 
	} 
			
		}
		catch(Exception e){
			
		}
	}

}
