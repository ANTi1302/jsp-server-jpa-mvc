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

@WebServlet(urlPatterns = {"/details/caterogy","/caterogy"})
public class CaterogyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager em = HibernateUtil.getInstance().getEntityManager();
		ProductFacade productFacade= new ProductImpl();
		String textSearch = req.getParameter("txtC");
		int tenC=Integer.parseInt(textSearch);
	
	String indexPageC = req.getParameter("index");

	if (indexPageC == null) {
		indexPageC = "1";
	}
	int indexC = Integer.parseInt(indexPageC);
	List<Product> productsC = productFacade.dsProductTheoIDCatorogyTop6(indexC, tenC);

	// Phan trang
	int soLuongC = productFacade.demSLKhiSearchTheoIDCatorogy(tenC);

	int endpageC = soLuongC / 3;
	if (soLuongC % 3 != 0) {
		endpageC++;
	}
	
	/////////////
	req.setAttribute("dsProduct", productsC);
	req.setAttribute("endpage", endpageC);
	req.setAttribute("tag", indexC);
	req.setAttribute("tenC", tenC);
	req.getRequestDispatcher("/template/view/custumer/shop.jsp").forward(req, resp);
	}
}
