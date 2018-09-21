package com.servlet;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CircularBean;
import com.bean.Student;
import com.bean.subject;
import com.beanDao.BeanDao;

@WebServlet("/report1")
public class report1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Student> list = BeanDao.getEmployees();
			List<CircularBean> list1 = BeanDao.getCircular();
			for (int i = 0; i <= list.size(); i++) {
				for (int j = 0; j <= list1.size(); j++) {					
					String messageText = list1.get(j).getText();					
					String to = list.get(i).getEmail();
					String host = "smtp.gmail.com";
					String user = "vigneshwari.makpo@gmail.com";
					String pass = "Vigneshwari@123";
					String from = "vigneshwari.makpo@gmail.com";
					String subject = list.get(j).getName();
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

					java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

					Session mailSession = Session.getDefaultInstance(props, null);
					mailSession.setDebug(sessionDebug);

					Message message = new MimeMessage(mailSession);
					message.setFrom(new InternetAddress(from));
					InternetAddress[] address = { new InternetAddress(to) };
					message.setRecipients(Message.RecipientType.TO, address);

					message.setSubject(subject);

					message.setText(messageText);

					Transport transport = mailSession.getTransport("smtp");
					transport.connect(host, user, pass);
					transport.sendMessage(message, message.getAllRecipients());
					transport.close();
					System.out.println("added successfully");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
