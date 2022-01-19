package facade.impl;

import java.rmi.RemoteException;
import java.util.Map;

import facade.DepartmentFacade;
import model.Department;

public class DepartmentImpl extends AbstractImpl implements DepartmentFacade{
	public DepartmentImpl() throws RemoteException {
		super();
	}

	@Override
	public Map<Department, Integer> getNumOfDoctorsByDepartments() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
