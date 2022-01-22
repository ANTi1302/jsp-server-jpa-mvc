package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.DoctorFacade;
import facade.impl.DoctorImpl;
import model.Doctor;

@WebServlet(urlPatterns = {"/load01"})
public class Controler extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException  {

		DoctorFacade doctorFacade= new DoctorImpl();
		List<Doctor> list= doctorFacade.getDoctorsBySpecialty("Infectious disease");
		req.setAttribute("list", list);
		req.getRequestDispatcher("/Show.jsp").forward(req, resp);
	
	}
}
