package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.ConnectDB;
import dao.Student_Dao;
import entity.Student;

@WebServlet(urlPatterns = {"/delete"})
public class DeleteControler extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Student_Dao dao = new Student_Dao();
			ConnectDB.getInstance().connect();
			//get sid to jsp
			String id= req.getParameter("sid");
			// set sid to dao
			dao.delete(id);
		
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// set data to jsp
		resp.sendRedirect("load");
	
	}
	
}
