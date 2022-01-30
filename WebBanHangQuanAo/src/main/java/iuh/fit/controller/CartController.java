package iuh.fit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iuh.fit.facade.ProductFacade;
import iuh.fit.impl.ProductImpl;
import iuh.fit.model.Product;
import iuh.fit.until.HibernateUtil;

@WebServlet(urlPatterns = { "/cart" })
public class CartController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF8");
		Cookie arr[] = req.getCookies();
		String id = req.getParameter("id");
		String txt = "";
		for (Cookie o : arr) {
			if (o.getName().equals("productID")) {
				txt = txt + o.getValue();
				o.setMaxAge(0);
				resp.addCookie(o);
			}
		}
		if (txt.isEmpty()) {
            txt = id;
        } else {
            txt = txt + "," + id;
        }
		Cookie c = new Cookie("id", txt);
		c.setMaxAge(60 * 60 * 24);
		resp.addCookie(c);
		resp.sendRedirect("print");

	}
}