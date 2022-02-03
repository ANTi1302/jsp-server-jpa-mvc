package iuh.fit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.hql.ast.origin.hql.resolve.GeneratedHQLResolver.intermediateIndexOperation_return;

import iuh.fit.facade.ProductFacade;
import iuh.fit.impl.ProductImpl;
import iuh.fit.model.Product;
import iuh.fit.until.HibernateUtil;

@WebServlet(urlPatterns = {"/details/search","/search"})
public class SearchController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManager em = HibernateUtil.getInstance().getEntityManager();
		ProductFacade productFacade= new ProductImpl();
		String ten=req.getParameter("txt");
		String indexPage= req.getParameter("index");
		
		
		if (indexPage ==null) {
			indexPage="1";
		}
		int index= Integer.parseInt(indexPage);
		List<Product> products= productFacade.dsProductTop6(index,ten);
		
		//Phan trang
		int soLuong= productFacade.demSLKhiSearch(ten);
		
		int endpage= soLuong/3;
		if (soLuong%3 !=0) {
			endpage++;
		}
		
		req.setAttribute("dsProduct", products);
		req.setAttribute("endpage", endpage);
		req.setAttribute("tag", index);
		req.setAttribute("tenS", ten);
		
		
//		HttpSession session = req.getSession();
//		List<String> items = (List<String>) req.getSession().getAttribute("history");
//		if (items == null) {
//			items = new ArrayList<String>();
//			 req.getSession().setAttribute("history", items);
//		}
//		// getParameter tra ve String (todo-demo.jsp?theItem=? thi add ?)
//		String theItem = req.getParameter("txt");
//		if (theItem != null) {
//			items.add(theItem);
//		}
//		System.out.println(theItem);
		req.getRequestDispatcher("/template/view/custumer/shop.jsp").forward(req, resp);
	}
}
