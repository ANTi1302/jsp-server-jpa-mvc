package iuh.fit.app;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.hql.ast.origin.hql.resolve.GeneratedHQLResolver.intermediateIndexOperation_return;

import iuh.fit.facade.CartFacade;
import iuh.fit.facade.ProductFacade;
import iuh.fit.facade.UsersFacade;
import iuh.fit.impl.CartImpl;
import iuh.fit.impl.ProductImpl;
import iuh.fit.impl.UserImpl;
import iuh.fit.model.Cart;
import iuh.fit.model.Product;
import iuh.fit.model.Users;
import iuh.fit.until.HibernateUtil;

public class App {

	
	public static void main(String[] args) throws RemoteException {
		EntityManager em = HibernateUtil.getInstance().getEntityManager();
		ProductFacade productFacade= new ProductImpl();
		UsersFacade usersFacade=new UserImpl();
		CartFacade cartFacade=new CartImpl();
//		List<Product> list= productFacade.dsProductTheoIDCatorogyTop6(1,4);
//		for (Product product : list) {
//			System.out.println(product);
//		}
//		
//		System.out.println(usersFacade.timKiemUser("AN Ti", "123"));
//		System.out.println(usersFacade.timKiemUserLogin("admin", "1234"));
		Users user= new Users();
//		user.getUserID();
		Users user02= usersFacade.timKiemUser("admin", "1234");
	
		

		Product product= new Product(2);
		int ma=product.getProductID();
		Product product02= new Product(3);
		Product product03= new Product(5);
		Product product04= new Product(7);
//				if (usersFacade.themUser(user)) {
//			System.out.println("okkkkkk");
//		} else {
//			System.out.println("nooooooo");
//		}
		List<Object> cart= new ArrayList<Object>();
		cart.add(new Cart(user, product, 6));
		if (cartFacade.addCart(cart)) {
			if (productFacade.capNhatProduct(ma)) {
				System.out.println("đã cập nhật");
			}
			else {
				System.out.println("lỗi cập nhật");
			}
			
		}else {
			System.out.println("noooo");
		}
		
	
		
		
		
	}
}
