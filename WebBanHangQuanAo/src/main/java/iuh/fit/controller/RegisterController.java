package iuh.fit.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import iuh.fit.facade.UsersFacade;
import iuh.fit.impl.UserImpl;
import iuh.fit.model.Users;
import iuh.fit.until.HibernateUtil;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		EntityManager em = HibernateUtil.getInstance().getEntityManager();
		UsersFacade usersFacade= new UserImpl();
		String ten=req.getParameter("exampleFirstName")+" " +req.getParameter("exampleLastName");
		String email=req.getParameter("exampleInputEmail");
		String password=req.getParameter("exampleInputPassword");
		Users users= new Users(ten, password, null, 0, 0, email);
		if (usersFacade.themUser(users)) {
			HttpSession session= req.getSession();
			session.setAttribute("acc", users);
			req.getRequestDispatcher("/template/view/custumer/login.jsp").forward(req, resp);
		}
		
		final String usernameMail="noreply.ellenthandmade.com@gmail.com";
		final String passwordMail="ellenthandmade123";
		Properties properties= new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		Session session= Session.getInstance(properties, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(usernameMail, passwordMail);
			}
		});
		
		//dang nhap mail
		String emailTo= req.getParameter("exampleInputEmail");
		String emailSubject="Member registration successful!";
		String content=req.getParameter("exampleFirstName")+" " +req.getParameter("exampleLastName");
		String emailContent="Thanks you "+content+", Congratulations on becoming a member of Ellent handmade";
		try {
			Message message= new MimeMessage(session);
			message.setFrom(new InternetAddress(usernameMail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));	
			message.setSubject(emailSubject);
			message.setText(emailContent);
			Transport.send(message);
			System.out.println("Done");
		
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
