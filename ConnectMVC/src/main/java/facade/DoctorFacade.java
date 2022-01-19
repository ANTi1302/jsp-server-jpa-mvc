package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import model.Department;
import model.Doctor;

/*
 * TranThiAnhThu 19516531
 */
public interface DoctorFacade extends Remote{

	public List<Doctor> getDoctorsBySpecialty(String specialty)throws RemoteException ;
	public  Map<Department, Integer> getNumOfDoctorsByDepartments () throws RemoteException ;
}
