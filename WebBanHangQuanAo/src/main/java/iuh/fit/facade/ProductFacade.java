package iuh.fit.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import iuh.fit.model.Product;

public interface ProductFacade extends Remote{

	public List<Product> dsProduct() throws RemoteException;
	public List<Product> dsProductTop6(int index) throws RemoteException;
	public List<Product> dsProductTop6(int index, String ten) throws RemoteException;
	public List<Product> dsProductTop9() throws RemoteException;
	public int demSLProduct() throws RemoteException;
	public int demSLKhiSearch(String ten) throws RemoteException;
	public Product thongTinChiTiet(int id) throws RemoteException;
	public List<Product> timKiemTheoTen(String ten) throws RemoteException;
	public Product getProduct(String txt)throws RemoteException;;
}
