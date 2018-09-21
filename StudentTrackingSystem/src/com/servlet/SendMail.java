package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;

import javax.mail.*;

import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;

/**
 * Servlet implementation class Servlet_Continue_Take
 */
@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendMail() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub

	}

	/**
	 * @throws IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Student s = new Student();
		
	int n =	s.getEmail().length();

		out.println(s + "this is your conformation pin...");
		out.print("pls check your mail");
		try {

			String host = "smtp.gmail.com";
			String user = "vigneshwari.makpo@gmail.com";
			String pass = "Vigneshwari@123";

			String from = "vigneshwari.makpo@gmail.com";
			String subject = "Task completed";
			// String messageText=s;
			boolean sessionDebug = false;
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");
			props.put("mail.smtp.EnableSSL.enable", "true");
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.socketFactory.fallback", "false");

			props.setProperty("mail.smtp.socketFactory.port", "465");
			for(int i =0; i<n;i++){
			java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);

			Message message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(from));
			
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(s.getEmail()));
			
			message.setSubject(subject);
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			}
			System.out.println("added successfully");
		} catch (Exception ex) {
			System.out.println(ex);
		}

		doGet(request, response);
	}

}
