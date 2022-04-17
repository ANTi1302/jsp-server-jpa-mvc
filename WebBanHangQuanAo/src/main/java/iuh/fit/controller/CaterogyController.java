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
     int soLuong=0;
     for (int i = 0; i < listCc.size(); i++) {
         int count = 1;
         for (int j = i+1; j < listCc.size(); j++) {
             if(listCc.get(i).getProductID() == listCc.get(j).getProductID()){
                 count++;
                 listCc.remove(j);
                 j--;
             }
         }
         soLuong++;
         listCc.get(i).setAmount(count);
     }
     

 req.setAttribute("soLuong", soLuong);
	
	
	////////////
	req.setAttribute("dsProduct", productsC);
	req.setAttribute("endpage", endpageC);
	req.setAttribute("tag", indexC);
	req.setAttribute("tenC", tenC);
	req.getRequestDispatcher("/template/view/custumer/shop.jsp").forward(req, resp);
	}
}
