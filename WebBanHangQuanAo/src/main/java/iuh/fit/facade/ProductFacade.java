package iuh.fit.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import iuh.fit.model.Product;

public interface ProductFacade extends Remote{

	public List<Product> dsProduct() throws RemoteException;
}
