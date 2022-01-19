package facade;
/*
 * TranThiAnhThu 19516531
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

import model.Patient;

public interface PatientFacade extends Remote{

	public boolean addPatient (Patient patient) throws RemoteException;
}
