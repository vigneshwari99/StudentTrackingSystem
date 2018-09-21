package com.servlet;

import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.bean.subject;
import com.beanDao.BeanDao;
  
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String roll = request.getParameter("roll");
		int no = Integer.parseInt(roll);
		String sem = request.getParameter("sem");
		String sub1 = request.getParameter("eng");
		float per1 = Float.parseFloat(sub1);
		String sub2 = request.getParameter("mat");
		float per2 = Float.parseFloat(sub2);
		String sub3= request.getParameter("sci");
		float per3 = Float.parseFloat(sub3);
		String sub4 = request.getParameter("ssc");
		float per4 = Float.parseFloat(sub4);
		String sub5 = request.getParameter("lan");
		float per5 = Float.parseFloat(sub5);
		String percent = request.getParameter("per");
		float per = Float.parseFloat(percent);
		String percent1 = request.getParameter("att");
		int atd = Integer.parseInt(percent1);
		subject s = new subject();
        s.setPercent(per);
        s.setRoll(no);
        s.setSem(sem);
        s.setSub1(per1);
        s.setSub2(per2);
        s.setSub3(per3);
        s.setSub4(per4);
        s.setSub5(per5);
        s.setAtd(atd);
          
        int status=BeanDao.update(s);  
        if(status>0){  
        	RequestDispatcher rd = request.getRequestDispatcher("HomePage.jsp");
			
			out.println("<p>updated successfully</p>");
			rd.include(request, response);
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  
