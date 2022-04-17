package iuh.fit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import iuh.fit.facade.ProductFacade;
import iuh.fit.impl.ProductImpl;
import iuh.fit.model.Product;
import iuh.fit.model.Users;
import iuh.fit.until.HibernateUtil;

@WebServlet(urlPatterns = { "/check" })
public class CheckoutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager em = HibernateUtil.getInstance().getEntityManager();
		ProductFacade productFacade = new ProductImpl();
		Cookie arr[] = req.getCookies();
		PrintWriter out = resp.getWriter();
		List<Product> listCc = new ArrayList<>();
		ProductFacade dao = new ProductImpl();
		for (Cookie o : arr) {
			if (o.getName().equals("productID")) {
				String txt[] = o.getValue().split("/");
				for (String s : txt) {
					listCc.add(dao.getProduct(s));
				}
			}
		}
		int soLuong = 0;
		for (int i = 0; i < listCc.size(); i++) {
			int count = 1;
			for (int j = i + 1; j < listCc.size(); j++) {
				if (listCc.get(i).getProductID() == listCc.get(j).getProductID()) {
					count++;
					listCc.remove(j);
					j--;
				}
			}
			soLuong++;
			listCc.get(i).setAmount(count);
		}
		///

		HttpSession session = req.getSession();
		Users username = (Users) session.getAttribute("acc");
		
		double product = (double) session.getAttribute("total");
		System.out.println("Xuat pr: " + product);
		req.setAttribute("soLuong", soLuong);
		

		req.getRequestDispatcher("/template/view/custumer/checkout.jsp").forward(req, resp);

	}
}
