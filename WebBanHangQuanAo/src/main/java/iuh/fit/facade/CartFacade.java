package iuh.fit.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import iuh.fit.model.Cart;

public interface CartFacade extends Remote{

	public long addCart(List<Object> cart) throws RemoteException;
}
