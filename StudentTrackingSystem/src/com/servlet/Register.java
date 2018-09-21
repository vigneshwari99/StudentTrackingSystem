
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Staff;
import com.beanDao.BeanDao;

import sun.util.calendar.BaseCalendar.Date;
@WebServlet("/Register")
public class Register extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		try{
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String uname = request.getParameter("univname");
			
			String d = request.getParameter("dob");
			System.out.println(d);
			java.util.Date date = new SimpleDateFormat("yyyy-mm-dd").parse(d);
			System.out.println(date);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
		    System.out.println(sqlDate);
			Staff s = new Staff();
	        s.setName(name);
	        s.setPass(pass);
	        s.setEmail(email);
	        s.setUnivname(uname);
	        s.setDate(sqlDate);
	        System.out.println("continue");
	        int status = BeanDao.save(s);
	        PrintWriter out = response.getWriter();
	        if(status>0){
				RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
			    out.println("<p>Registered succesfully</p>");
				rd.include(request, response);
				
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
				out.println("<p>email id already registered</p>");
				rd.include(request, response);
			}
			
		}catch(Exception e)
		
		{
			
		}		
	}
}
