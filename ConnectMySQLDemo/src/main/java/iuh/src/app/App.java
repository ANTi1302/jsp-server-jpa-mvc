package iuh.src.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

@WebServlet(urlPatterns = "/demo")
public class App extends HttpServlet{

	@Resource(name = "jdbc/web_student_tracker")
	private DataSource dataSource;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter printWriter=resp.getWriter();
		resp.setContentType("text/plain");
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs= null;
		try {
			myConn=dataSource.getConnection();
			String sql="select * from class";
			myStmt=myConn.createStatement();
			myRs=myStmt.executeQuery(sql);
			while (myRs.next()) {
				String id= myRs.getString("maLop");
				String lastname= myRs.getString("tenLop");
				String firstname= myRs.getString("soPhong");
				String email= myRs.getString("soTiet");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println();
		
	}
}
