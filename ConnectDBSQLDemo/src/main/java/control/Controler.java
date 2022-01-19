package control;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/load")
public class Controler extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// B1: get data from sql
		try {
			Student_Dao dao = new Student_Dao();
			ConnectDB.getInstance().connect();
			List<Student> list= dao.gettalltbSutdent();
			req.setAttribute("list", list);
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// set data to jsp
		req.getRequestDispatcher("Show.jsp").forward(req, resp);
	
	

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
