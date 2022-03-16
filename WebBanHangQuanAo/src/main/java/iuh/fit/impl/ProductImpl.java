package iuh.fit.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
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

//Phan trang
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
//	select * from [dbo].[Product]
//			where [ProductName] like N'%2%'
//					order by [ProductID]
//					offset 0 row fetch next 6 row only
	@Override
	public List<Product> dsProductTop6(int index, String ten) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			List<Product> list = em.createNativeQuery("select * from [dbo].[Product]\r\n"
					+ "where [ProductName] like N'%"+ten+"%'\r\n"
					+ "		order by [ProductID]\r\n"
					+ "		offset "+((index-1)*3)+" row fetch next 6 row only ", Product.class).getResultList();
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

//	select * from [dbo].[Product] where productID=1
	@Override
	public Product thongTinChiTiet(int ma) throws RemoteException {
		return (Product) getSingle("select * from [dbo].[Product] where productID= '" + ma + "'", Product.class);
	}

//	select *from [dbo].[Product]
//			where [ProductName] like N'%2%'
	@Override
	public List<Product> timKiemTheoTen(String ten) throws RemoteException {
		List<?> ds = getList("select *from [dbo].[Product]\r\n"
				+ "where [ProductName] like N'%"+ten+"%'", Product.class);
		return (List<Product>) ds;
	}

//	select count(*)from [dbo].[Product]
//	where [ProductName] like N'%2%' 
	@Override
	public int demSLKhiSearch(String ten) throws RemoteException {
		EntityTransaction tr = em.getTransaction();		
		try {
			tr.begin();
		String query = "select count(*)from [dbo].[Product]\r\n"
				+ "where [ProductName] like N'%"+ten+"%' ";

		int soHoaDon = (int) em.createNativeQuery(query).getSingleResult();
		tr.commit();
		return  soHoaDon;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return 0;
	}

	 public Product getProduct(String txt) throws RemoteException {
		 try {
			 return (Product) getSingle("select * from Product where productID = '" + txt+"'" , Product.class);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		 
	        
	    }


	@Override
	public List<Product> dsProductTheoIDCatorogyTop6(int index, int ten) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			List<Product> list = em.createNativeQuery("select * from [dbo].[Product]\n"
					+ "	where [CategoryID]="+ten
					+ "			order by [ProductID]\n"
					+ "			offset "+((index-1)*3)+" row fetch next 6 row only ", Product.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}


	@Override
	public int demSLKhiSearchTheoIDCatorogy(int ten) throws RemoteException {
		EntityTransaction tr = em.getTransaction();		
		try {
			tr.begin();
		String query = "select count(*)from [dbo].[Product]\n"
				+ "				where  [CategoryID]= "+ten;

		int soHoaDon = (int) em.createNativeQuery(query).getSingleResult();
		tr.commit();
		return  soHoaDon;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return 0;
	}

//	UPDATE [dbo].[Product]
//			SET [dbo].[Product].amount = [dbo].[Cart].amount-[dbo].[Product].amount
//			FROM [dbo].[Product],[dbo].[Cart]
//			WHERE [dbo].[Product].ProductID=[dbo].[Cart].ProductID
//			and [dbo].[Product].ProductID = '1';
	@Override
	public boolean capNhatProduct(int product) throws RemoteException {
		
		EntityTransaction tr = em.getTransaction();		
		try {
			tr.begin();
		String query = "\n"
				+ "UPDATE [dbo].[Product]\n"
				+ "SET [dbo].[Product].amount =[dbo].[Product].amount-[dbo].[Cart].amount\n"
				+ "FROM [dbo].[Product],[dbo].[Cart]\n"
				+ "WHERE [dbo].[Product].ProductID=[dbo].[Cart].ProductID\n"
				+ "and [dbo].[Product].ProductID ="+product;

		 em.createNativeQuery(query).executeUpdate();
		tr.commit();
		return  true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
		
	}

	
	

}
