package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.ConnectDB;
import dao.Student_Dao;
import entity.Student;

@WebServlet(urlPatterns = { "/update" })
public class UpdateControler extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Student_Dao dao = new Student_Dao();
			ConnectDB.getInstance().connect();
			// get sid to jsp
			String id = req.getParameter("sid");
			// set sid to dao
			Student student = dao.getNhanVienTheoMaNV(id);
			req.setAttribute("st", student);

		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// set data to jsp
		req.getRequestDispatcher("Upload.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Student_Dao dao = new Student_Dao();
			ConnectDB.getInstance().connect();
			// get sid to jsp
			String sid = req.getParameter("id");
			String sname = req.getParameter("name");
			String sgender = req.getParameter("gender");
			String sdob = req.getParameter("dob");
			// set sid to dao
			dao.update(sid, sname, sgender, sdob);

		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		resp.sendRedirect("load");
	}
}
