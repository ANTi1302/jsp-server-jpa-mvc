package iuh.fit.impl;

import java.rmi.RemoteException;
import java.util.List;

import iuh.fit.facade.CartFacade;
import iuh.fit.model.Cart;

public class CartImpl extends AbstractImpl implements CartFacade{

	public CartImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCart(List<Object> cart) throws RemoteException {
		// TODO Auto-generated method stub
		return them(cart);
	}

	

}
