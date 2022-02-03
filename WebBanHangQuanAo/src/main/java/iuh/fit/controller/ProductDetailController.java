package iuh.fit.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iuh.fit.facade.ProductFacade;
import iuh.fit.impl.ProductImpl;
import iuh.fit.model.Product;
import iuh.fit.until.HibernateUtil;

@WebServlet(urlPatterns = { "/details/*", "/detail" })
public class ProductDetailController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		@SuppressWarnings("unused")
		EntityManager em = HibernateUtil.getInstance().getEntityManager();
		ProductFacade productFacade = new ProductImpl();
		String idReq = req.getParameter("idProduct");
		int id = Integer.parseInt(idReq);
		Product product = productFacade.thongTinChiTiet(id);
		req.setAttribute("dsProductChiTiet", product);

		
		
		req.getRequestDispatcher("/template/view/custumer/product-details.jsp").forward(req, resp);
	}
}
