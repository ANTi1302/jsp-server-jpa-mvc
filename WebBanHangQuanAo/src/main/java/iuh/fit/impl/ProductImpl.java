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
			List<Product> list = em.createNativeQuery("select *from  [dbo].[Product] order by  [ProductID] ", Product.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

//	SELECT count(productID) FROM [dbo].[Product]
	@Override
	public int demSLProduct() throws RemoteException {
		EntityTransaction tr = em.getTransaction();		
		try {
			tr.begin();
		String query = "SELECT count(productID) FROM [dbo].[Product]";

		int soHoaDon = (int) em.createNativeQuery(query).getSingleResult();
		tr.commit();
		return  soHoaDon;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return 0;
	}

//	select * from [dbo].[Product]
//			order by [ProductID]
//			offset 0 row fetch next 6 row only
	@Override
	public List<Product> dsProductTop6(int index) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			List<Product> list = em.createNativeQuery("select * from [dbo].[Product]\r\n"
					+ "order by [ProductID]\r\n"
					+ "offset "+((index-1)*3)+" row fetch next 6 row only ", Product.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}


	@Override
	public List<Product> dsProductTop9() throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			List<Product> list = em.createNativeQuery("select top 9 *from  [dbo].[Product] order by  [ProductID] ", Product.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	
	

}
