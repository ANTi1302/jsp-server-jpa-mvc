/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.fit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import iuh.fit.facade.CartFacade;
import iuh.fit.facade.ProductFacade;
import iuh.fit.impl.CartImpl;
import iuh.fit.impl.ProductImpl;
import iuh.fit.model.Cart;
import iuh.fit.model.Product;
import iuh.fit.model.Users;
import iuh.fit.until.HibernateUtil;


@WebServlet(name = "OrderControl", urlPatterns = {"/order"})
public class OrderControl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	  HttpSession session = request.getSession();
          Users username =  (Users) session.getAttribute("acc");
        response.setContentType("text/html;charset=UTF-8");
        EntityManager em = HibernateUtil.getInstance().getEntityManager();
        Cookie arr[] = request.getCookies();
        List<Product> list = new ArrayList<>();
        
       ProductFacade productFacade= new ProductImpl();
       CartFacade cartFacade=new CartImpl();
     
       
        for (Cookie o : arr) {
            if (o.getName().equals("productID")) {
                String txt[] = o.getValue().split("/");
                for (String s : txt) {
                    list.add(productFacade.getProduct(s));
                }
            }
        }
        Users users= new Users();
//        users= new Users(list.getSellerID().getUserID());
        for (int i = 0; i < list.size(); i++) {
        	  
            int count = 1;
            for (int j = i+1; j < list.size(); j++) {
                if(((Product) list.get(i)).getProductID() == ((Product) list.get(j)).getProductID()){
                    count++;
                    list.remove(j);
                    j--;
                    ((Product) list.get(i)).setAmount(count);
                   
                }
            }
            System.out.println("ProductID: "+list.get(i).getProductID());
            System.out.println("Amount: "+list.get(i).getAmount());
            System.out.println("UserID: "+list.get(i).getSellerID().getUserID());
            List<Object> cart=new ArrayList<Object>();
            List<Object> cartacc=new ArrayList<Object>();
            Product product= new Product(list.get(i).getProductID());
            int ma=product.getProductID();
            cart.add(new Cart(users, product, list.get(i).getAmount()));
            //Th??m h??a ????n kh??ng c???n login
           

            cartacc.add(new Cart(username, product, list.get(i).getAmount()));
            if (username != null) {
    			cartFacade.addCart(cartacc);
    		}else {
            if (cartFacade.addCart(cart)) {
            	productFacade.capNhatProduct(ma);
            	System.out.println("???? c???p nh???t");
			}else {
				System.out.println("l???i c???p nh???t");
			}
    		}
        }
        
//        List<Object> cart= new ArrayList<Object>();
//        
//        cart.add(list);
//        System.out.println(cart);
        for (Cookie o : arr) {
        	if (o.getName().equals("productID")) {
        		o.setMaxAge(0);
                response.addCookie(o);
			}else {
				 HttpSession session01= request.getSession();
		    		session01.setAttribute("acc", username);
			}
          
           
        }
        
//		session01.setAttribute("acc", username);
//        System.out.println("/order input: "+ username.getUsername());
        
      //////////
//    
//        HttpSession session01= request.getSession();
//		session01.setAttribute("acc", username);
//		 if (session01 != null) {
//			 System.out.println("????y n??: "+session01.getAttribute("acc"));
//			 response.sendRedirect("home");
//			}else 
		
       
        response.sendRedirect("home");
//        request.getRequestDispatcher("/template/view/custumer/index.jsp").forward(request, response);
        
    }

   
}
