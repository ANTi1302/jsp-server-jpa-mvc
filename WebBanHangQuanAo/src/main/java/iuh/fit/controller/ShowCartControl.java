/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

@WebServlet(name = "ShowCartControl", urlPatterns = {"/print"})
public class ShowCartControl extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
		 EntityManager em = HibernateUtil.getInstance().getEntityManager();
	        Cookie arr[] = request.getCookies();
	        PrintWriter out = response.getWriter();
	        List<Product> list = new ArrayList<>();
	        ProductFacade dao = new ProductImpl();
	        for (Cookie o : arr) {
	            if (o.getName().equals("productID")) {
	                String txt[] = o.getValue().split("/");
	                for (String s : txt) {
	                    list.add(dao.getProduct(s));
	                }
	            }
	        }
	        for (int i = 0; i < list.size(); i++) {
	            int count = 1;
	            for (int j = i+1; j < list.size(); j++) {
	                if(list.get(i).getProductID() == list.get(j).getProductID()){
	                    count++;
	                    list.remove(j);
	                    j--;
	                    list.get(i).setAmount(count);
	                }
	            }
	        }
	        double total = 0;
	        for (Product o : list) {
	            total = total + o.getAmount() * o.getPrice();
	        }
	        request.setAttribute("list", list);
	        request.setAttribute("total", total);
	        request.setAttribute("vat", 0.1 * total);
	        request.setAttribute("sum", 1.1 * total);
	        request.getRequestDispatcher("/template/view/custumer/cart.jsp").forward(request, response);
    }
	
	
}
