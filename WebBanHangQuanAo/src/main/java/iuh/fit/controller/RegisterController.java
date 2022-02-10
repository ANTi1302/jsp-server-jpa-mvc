package iuh.fit.controller;

import java.io.IOException;

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
		} else {

		}
	}
}
