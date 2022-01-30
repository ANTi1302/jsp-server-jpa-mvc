package iuh.fit.impl;

import java.rmi.RemoteException;

import iuh.fit.facade.UsersFacade;
import iuh.fit.model.Product;
import iuh.fit.model.Users;

public class UserImpl extends AbstractImpl implements UsersFacade {

	public UserImpl() throws RemoteException {
		super();
	}

//	select *from [dbo].[Users]
//			where [Username]='admin' and Password=1234
	@Override
	public Users timKiemUser(String ten, String pass) throws RemoteException {
		try {
			return (Users) getSingle("select *from [dbo].[Users]\r\n"
					+ "where [Username]='"+ten+"' and Password=" +pass, Users.class);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
