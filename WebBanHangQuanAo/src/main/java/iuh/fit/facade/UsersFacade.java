package iuh.fit.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;

import iuh.fit.model.Users;

public interface UsersFacade extends Remote{
 public Users timKiemUser(String ten, String pass) throws RemoteException;
}
