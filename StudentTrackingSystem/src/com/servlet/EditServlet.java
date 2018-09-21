package com.servlet;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.bean.subject;
import com.beanDao.BeanDao;


@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Student details</h1>");  
        String sid=request.getParameter("roll");  
        int id=Integer.parseInt(sid);  
          
        subject e=BeanDao.getEmployeeById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
      
        out.print("<tr><td>Roll:</td><td><input type='number' name='roll' value='"+e.getRoll()+"'/></td></tr>");  
        out.print("<tr><td>sem:</td><td><input type='text' name='sem' value='"+e.getSem()+"'/></td></tr>");  
        out.print("<tr><td>English:</td><td><input type='number' name='eng' value='"+e.getSub1()+"'/></td></tr>");  
        out.print("<tr><td>Maths:</td><td><input type='integer' name='mat' value='"+e.getSub2()+"'/></td></tr>");  
        out.print("<tr><td>Science:</td><td><input type='integer' name='sci' value='"+e.getSub3()+"'/></td></tr>");  
        out.print("<tr><td>SocialScience:</td><td><input type='integer' name='ssc' value='"+e.getSub4()+"'/></td></tr>");  
        out.print("<tr><td>Language:</td><td><input type='integer' name='lan' value='"+e.getSub5()+"'/></td></tr>");  
        out.print("<tr><td>Percentage:</td><td><input type='integer' name='per' value='"+e.getPercent()+"'/></td></tr>");  
        out.print("<tr><td>Attendance:</td><td><input type='integer' name='att' value='"+e.getAtd()+"'/></td></tr>"); 
       
        
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  