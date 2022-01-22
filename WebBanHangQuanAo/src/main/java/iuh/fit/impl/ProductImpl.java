package iuh.fit.impl;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import iuh.fit.facade.ProductFacade;
import iuh.fit.model.Product;

public class ProductImpl extends AbstractImpl implements ProductFacade{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ProductImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	@Transactional
	public List<Product> dsProduct() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			List<Product> list = em.createNativeQuery("select top 9 *from  [dbo].[Product] order by  [ProductID] desc", Product.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	

}
