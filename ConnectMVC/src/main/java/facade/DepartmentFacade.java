package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import model.Department;

public interface DepartmentFacade extends Remote{

	public  Map<Department, Integer> getNumOfDoctorsByDepartments () throws RemoteException ;
}
