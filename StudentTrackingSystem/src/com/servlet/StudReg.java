package com.servlet;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.beanDao.BeanDao;

@WebServlet("/StudReg")
public class StudReg extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try{
			String roll = request.getParameter("roll");
			int no = Integer.parseInt(roll);
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			String pname = request.getParameter("pname");
			String mob = request.getParameter("mob");
			int phone = Integer.parseInt(mob);
			String d = request.getParameter("dob");
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
			System.out.println(date);
			java.sql.Date sql = new java.sql.Date(date.getTime()); 
			
			Student s = new Student();
			s.setName(name);
			s.setEmail(email);
			s.setDate(sql);
			s.setPname(pname);
			s.setRoll(no);
			s.setMob(phone);
			int status = BeanDao.sign(s);
			PrintWriter out = response.getWriter();
			if(status>0){
				RequestDispatcher rd = request.getRequestDispatcher("StudSignup.jsp");
				out.print("<p>students record added succesfully</p>");
				rd.include(request, response);
				//RequestDispatcher rd = request.setAttribute("detail","value stored");
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("StudSignup.jsp");
				out.print("<p>no record added succesfully</p>");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
