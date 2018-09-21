package com.servlet;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.CircularBean;
import com.bean.Student;
import com.beanDao.BeanDao;

@WebServlet("/Circular")
public class Circular extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		try{
			String d = request.getParameter("d");
			Date date = new  SimpleDateFormat("yyyy-MM-dd").parse(d);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			String txtName = request.getParameter("data");
			String det = request.getParameter("des");
			CircularBean c = new CircularBean();
			c.setD(sqlDate);
			c.setName(txtName);
			c.setText(det);
			int status = BeanDao.describe(c);
			 if (status>0)
		     {
				 RequestDispatcher rd = request.getRequestDispatcher("circular.jsp"); 
		         /* HttpSession session = request.getSession(true);	    
		          session.setAttribute("currentSessionUser",c);*/
		          PrintWriter out = response.getWriter();
		          out.print("<p>succ</p>");
		       //   response.sendRedirect("viewdata.jsp"); //logged-in page 
		          
		         
		     }
			        
		     else {
		          response.sendRedirect("index.jsp"); //error page
		          PrintWriter out = response.getWriter();
		          out.print("<p>Not succ</p>");
		} 
			 
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
