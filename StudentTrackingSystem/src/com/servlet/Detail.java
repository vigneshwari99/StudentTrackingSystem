package com.servlet;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.subject;
import com.beanDao.BeanDao;
@WebServlet("/Detail")
public class Detail extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		
		try{
			
			String roll = request.getParameter("roll");
			int no = Integer.parseInt(roll);
			String sem = request.getParameter("sem");
			String sub1 = request.getParameter("eng");
			float per1 = Integer.parseInt(sub1);
			String sub2 = request.getParameter("mat");
			float per2 = Integer.parseInt(sub2);
			String sub3= request.getParameter("sci");
			float per3 = Integer.parseInt(sub3);
			String sub4 = request.getParameter("ssc");
			float per4 = Integer.parseInt(sub4);
			String sub5 = request.getParameter("lan");
			float per5 = Integer.parseInt(sub5);
			String percent = request.getParameter("per");
			float per = Integer.parseInt(percent);
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
			
            int status = BeanDao.marksave(s);
            PrintWriter out = response.getWriter();
            if(status>0){
              RequestDispatcher rd = request.getRequestDispatcher("detail.jsp");
			   out.println("<p>Registered succesfully</p>");
				rd.include(request, response);
            }
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
