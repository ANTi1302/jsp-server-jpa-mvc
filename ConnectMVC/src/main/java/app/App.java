package app;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import facade.DoctorFacade;
import facade.PatientFacade;
import facade.impl.DoctorImpl;
import facade.impl.PatientImpl;
import model.Doctor;
import model.Patient;
import model.Treatment;




public class App {

	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
//	
		DoctorFacade doctorFacade= new DoctorImpl();
//		PatientFacade patientFacade= new PatientImpl();
//		Doctor doctor= new Doctor("BBB01");
//		List<Treatment> treatments= new ArrayList<Treatment>();
//		treatments.add(new Treatment("BBB01", new Date(), new Date(), doctor));
//		Patient patient = new Patient("BBB01", 5, "text", "text", "text", "text", "0932904529", treatments);
//		Cau 1
//		if (patientFacade.addPatient(patient)) {
//			System.out.println("Da them thanh cong");
//		} else {
//			System.out.println("Loi!");
//		}
		
//		Cau 2
		System.out.println(doctorFacade.getDoctorsBySpecialty("Infectious disease")); 
		
//		Cau 3
//		doctorFacade
//		.getNumOfDoctorsByDepartments()
//		.entrySet()
//		.iterator()
//		.forEachRemaining(entry -> {
//			System.out.println(": Department" + entry.getKey()) ;
//			System.out.println("Number doctor of Department: " + entry.getValue()) ;
//		});
//		
	}
}
