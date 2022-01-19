package facade.impl;
/*
 * TranThiAnhThu 19516531
 */
import java.rmi.RemoteException;

import facade.PatientFacade;
import model.Patient;

public class PatientImpl extends AbstractImpl implements PatientFacade{

	public PatientImpl() throws RemoteException {
		super();
	}

	@Override
	public boolean addPatient(Patient patient) throws RemoteException {
		// TODO Auto-generated method stub
		return them(patient);
	}
}
