package control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.ConnectDB;
import dao.Student_Dao;
import entity.Student;

@WebServlet(urlPatterns = { "/add" })
public class AddControl extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		try {
			String name=req.getParameter("name");
			String gender=req.getParameter("gender");
			String dob=req.getParameter("dob");
			Student_Dao dao = new Student_Dao();
			ConnectDB.getInstance().connect();
			 dao.create(name,gender,dob);
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		resp.sendRedirect("load");
	}
}
