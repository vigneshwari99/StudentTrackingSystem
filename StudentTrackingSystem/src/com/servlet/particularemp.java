package com.servlet;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Student;
import com.beanDao.BeanDao;


@WebServlet("/particularemp")
public class particularemp extends HttpServlet {
protected void doPost(HttpServletRequest request,HttpServletResponse response){
	try{
		Student stud = new Student();
		String roll = request.getParameter("roll");
		int r = Integer.parseInt(roll);
		stud.setRoll(r);
	     stud =   BeanDao.getEmp(stud);
	 if (stud.isId())
     {
	        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",stud);
          
          response.sendRedirect("samp.jsp"); //logged-in page      		
     }
	        
     else {
          response.sendRedirect("index.jsp"); //error page 
} 
		
	 
	}catch(Exception e){
		System.out.println(e);
	}
}
}
