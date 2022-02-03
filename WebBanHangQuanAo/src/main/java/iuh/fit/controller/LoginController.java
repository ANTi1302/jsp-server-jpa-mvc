package iuh.fit.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import iuh.fit.facade.ProductFacade;
import iuh.fit.facade.UsersFacade;
import iuh.fit.impl.ProductImpl;
import iuh.fit.impl.UserImpl;
import iuh.fit.model.Users;
import iuh.fit.until.HibernateUtil;

public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		EntityManager em = HibernateUtil.getInstance().getEntityManager();
		String ten=req.getParameter("name");
		String pass=req.getParameter("pass");
		UsersFacade productFacade= new UserImpl();
		Users users=productFacade.timKiemUser(ten, pass);
		if (users==null) {
			req.getRequestDispatcher("/template/view/custumer/login.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("home").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		EntityManager em = HibernateUtil.getInstance().getEntityManager();
		String ten=req.getParameter("name");
		String pass=req.getParameter("pass");
		UsersFacade productFacade= new UserImpl();
		Users users=productFacade.timKiemUser(ten, pass);
		if (users==null) {
			req.getRequestDispatcher("/template/view/custumer/login.jsp").forward(req, resp);
		}else {
			HttpSession session= req.getSession();
			session.setAttribute("acc", users);
			resp.sendRedirect("home");
		}
	}
}
