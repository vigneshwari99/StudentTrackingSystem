package com.servlet;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.bean.subject;
import com.beanDao.BeanDao;



@WebServlet("/report")
public class report extends HttpServlet {
 
	protected void doGet(HttpServletRequest request,HttpServletResponse response){
		try{
			 List<Student> list=BeanDao.getAllEmployees();
			 PrintWriter out = response.getWriter();
			 out.print("<table border='1px solid black'  width='100%'>");  
		        out.print("<tr><th>roll</th><th>Semester</th><th>Name</th><th>Date</th><th>English</th><th>Maths</th><th>Science</th><th>Social</th><th>Language</th><th>Percentage</th><th>Attendance</th><th>ParentName</th><th>MobileNo</th><th>Edit</th><th>Delete</th></tr>");  
		        for(Student e:list ){  
		         out.print("<tr><td>"+e.getRoll()+"</td><td>"+e.getSem()+"</td><td>"+e.getName()+"</td><td>"+e.getDate()+"</td><td>"+e.getSub1()+"</td><td>"+e.getSub2()+"</td><td>"+e.getSub3()+"</td><td>"+e.getSub4()+"</td><td>"+e.getSub5()+"</td><td>"+e.getPercent()+"</td><td>"+e.getAtd()+"</td><td>" +e.getPname()+"</td><td>"+e.getMob()+"</td><th><a href='EditServlet?roll="+e.getRoll()+"'>edit</a></th><th><a href='DeleteServlet?roll="+e.getRoll()+"'>delete</a></th></tr>");  
		        }  
		        out.print("</table>");  
		          
		        out.close(); 
			
		}catch(Exception e){
			
		}
	}
}
