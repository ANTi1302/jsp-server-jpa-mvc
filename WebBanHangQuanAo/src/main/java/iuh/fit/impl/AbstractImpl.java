package iuh.fit.impl;
/*
 * TranThiAnhThu 19516531
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import iuh.fit.until.HibernateUtil;

public class AbstractImpl extends UnicastRemoteObject{
	protected EntityManager em;

	protected AbstractImpl() throws RemoteException {
		super();
		em = HibernateUtil.getInstance().getEntityManager();	
	}
	public boolean them(Object obj) throws RemoteException  {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(obj);
			tr.commit();

			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			
		}

		return false;
	}
	public boolean them(List<Object> obj) throws RemoteException  {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			obj.forEach(obj1 -> {
				em.persist(obj1);
				
				
			});
			
			tr.commit();

			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			
		}

		return false;
	}
	public boolean capNhat(Object obj) throws RemoteException  {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.merge(obj);
			tr.commit();

			return true;
		}catch (Exception e) {
			tr.rollback();
		}
		return false;
	}
	
	public boolean xoa(int id, Class<?> classname) throws RemoteException  {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(classname, id));
			tr.commit();

			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	public boolean xoa(String id, Class<?> classname) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();

			em.remove(em.find(classname, id));
			tr.commit();

			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public List<?> getList(String sql, Class<?> classname) throws RemoteException {
		return em.createNativeQuery(sql, classname)
				.getResultList();
	}
	
	public Object getSingle(String sql, Class<?> classname) throws RemoteException {
		return em.createNativeQuery(sql, classname)
				.getSingleResult();
	}
	
}
