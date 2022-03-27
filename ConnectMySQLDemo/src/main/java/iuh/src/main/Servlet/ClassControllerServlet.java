package iuh.src.main.Servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import iuh.src.main.model.LopHoc;
import iuh.src.main.model.Student;
import iuh.src.main.until.ClassDbUtil;
import iuh.src.main.until.StudentDbUtil;

@WebServlet("/ClassControllerServlet")
public class ClassControllerServlet extends HttpServlet{

	private ClassDbUtil classDbUtil;
	
	@Resource(name = "jdbc/web_student_tracker")
	private DataSource dataSource;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF8");
		
		try {
			classDbUtil = new ClassDbUtil(dataSource);
		}catch(Exception exc){
			throw new ServletException(exc);
		}
		
		try {
			String theCommand = req.getParameter("command");
			
			if(theCommand==null) {
				theCommand = "LIST";
			}
			
			switch(theCommand) {
			case "LIST":
				listClass(req, resp);
				break;
			case "ADD":
				addClass(req, resp);
				break;
			case "LOAD":
				loadClass(req, resp);
				break;
			case "DETAILS":
				listClassDetails(req, resp);
				break;
			case "UPDATE":
				updateClass(req, resp);
				break;
			case "DELETE":
				deleteClass(req, resp);
				break;
			default:
				listClass(req, resp);
			}
			

		}catch(Exception exc) {
			throw new ServletException(exc);
		}
	}
	private void listClassDetails(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int maLop= Integer.parseInt(req.getParameter("maLop"));
		List<Student> lopHocs = classDbUtil.getLopHocTheoMa(maLop);
		
		//add students to the request
		req.setAttribute("STUDENT_LIST", lopHocs);
		
		//send to JSP page (view)
		RequestDispatcher dispatcher = req.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(req, resp);
		
	}
	private void deleteClass(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String theStudentId = req.getParameter("maLop");
		
		classDbUtil.deleteClass(theStudentId);
		
		listClass(req, resp);
		
	}
	private void updateClass(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("maLop"));
		String tenLop = req.getParameter("tenLop");
		String soPhong = req.getParameter("soPhong");
		int soTiet = Integer.parseInt(req.getParameter("soTiet"));
		
		LopHoc lopHoc= new LopHoc(id, tenLop, soPhong, soTiet);
		
		classDbUtil.updateClass(lopHoc);
		
		listClass(req, resp);
	}
	private void loadClass(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String theStudentId = req.getParameter("maLop");
		LopHoc lopHoc= classDbUtil.getLopHoc(theStudentId);
		req.setAttribute("THE_STUDENT", lopHoc);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/update-class-form.jsp");
		dispatcher.forward(req, resp);
		
	}
	private void addClass(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		int soTiet=Integer.parseInt(email);
		LopHoc lopHoc= new LopHoc(firstName, lastName, soTiet);
		classDbUtil.addLopHoc(lopHoc);
		
		listClass(req, resp);
		
	}
	private void listClass(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
	List<LopHoc> lopHocs = classDbUtil.getLopHoc();
		
		//add students to the request
		req.setAttribute("LOPHOC_LIST", lopHocs);
		
		//send to JSP page (view)
		RequestDispatcher dispatcher = req.getRequestDispatcher("/list-class.jsp");
		dispatcher.forward(req, resp);
		
	}
}
