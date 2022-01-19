package facade.impl;
/*
 * TranThiAnhThu 19516531
 */
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import facade.DoctorFacade;
import model.Department;
import model.Doctor;

public class DoctorImpl extends AbstractImpl implements DoctorFacade{
	public DoctorImpl() throws RemoteException {
		super();
	}
//	Thu19516531> db.doctors.createIndex({specialty:'text'})
//	Thu19516531> db.doctors.find({$text:{$search:'Infectious disease'}})
	@Override
	public List<Doctor> getDoctorsBySpecialty(String specialty) throws RemoteException {
		List<?> ds = getList("{$text:{$search:'" + specialty + "'}}", Doctor.class);
		return (List<Doctor>) ds;
	}
//	Thu19516531> db.doctors.aggregate([{$group:{_id:'$departmentId', tong:{$count:{}}}}])
	@Override
	public Map<Department, Integer> getNumOfDoctorsByDepartments() throws RemoteException {
		Map<Department, Integer> map = new HashMap<Department, Integer>();

		String query = "db.doctors.aggregate([{'$group':{_id:'$departmentId', tong:{$count:{}}}}])";

		List<?> list = em.createNativeQuery(query).getResultList();

		for (Object obj : list) {
			Object[] o = (Object[]) obj;
//			Long id = Long.parseLong(rs[0].toString());
			String id = (String) o[0];
			Department department = em.find(Department.class, id);
			int  count= (int) o[1];
			map.put(department, count);
		}

		return map;
	}
}
