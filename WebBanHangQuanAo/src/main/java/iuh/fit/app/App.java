package iuh.fit.app;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import iuh.fit.facade.ProductFacade;
import iuh.fit.impl.ProductImpl;
import iuh.fit.model.Product;
import iuh.fit.until.HibernateUtil;

public class App {

	
	public static void main(String[] args) throws RemoteException {
		EntityManager em = HibernateUtil.getInstance().getEntityManager();
		ProductFacade productFacade= new ProductImpl();
		List<Product> list= productFacade.dsProduct();
		for (Product product : list) {
			System.out.println(product.getImageLink());
		}
		
	}
}
