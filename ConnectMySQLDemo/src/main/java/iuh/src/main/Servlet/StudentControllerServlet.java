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

@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDbUtil studentDbUtil;
	private ClassDbUtil classDbUtil;
	@Resource(name = "jdbc/web_student_tracker")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			studentDbUtil = new StudentDbUtil(dataSource);
			classDbUtil = new ClassDbUtil(dataSource);
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
		try {
			String theCommand = request.getParameter("command");

			if (theCommand == null) {
				theCommand = "LIST";
			}

			switch (theCommand) {
			case "LIST":
				listStudents(request, response);
				break;
			case "ADD":
				addStudents(request, response);
				break;
			case "LOAD":
				loadStudents(request, response);
				break;
			case "UPDATE":
				updateStudents(request, response);
				break;
			case "DELETE":
				deleteStudent(request, response);
				break;
			case "CLASS":
				getClass(request, response);
				break;
			default:
				listStudents(request, response);
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
		try {
			String theCommand = req.getParameter("command");

			if (theCommand == null) {
				theCommand = "LIST";
			}

			switch (theCommand) {
			case "LIST":
				listStudents(req, resp);
				break;
			case "ADD":
				addStudents(req, resp);
				break;
			case "LOAD":
				loadStudents(req, resp);
				break;
			case "UPDATE":
				updateStudents(req, resp);
				break;
			case "DELETE":
				deleteStudent(req, resp);
				break;
			case "CLASS":
				getClass(req, resp);
				break;
			default:
				listStudents(req, resp);
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	private void getClass(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<LopHoc> lopHocs = classDbUtil.getLopHoc();

		// add students to the request
		req.setAttribute("LOPHOC_LIST", lopHocs);

		// send to JSP page (view)
		RequestDispatcher dispatcher = req.getRequestDispatcher("/add-student-form.jsp");
		dispatcher.forward(req, resp);

	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		String theStudentId = request.getParameter("studentId");

		studentDbUtil.deleteStudent(theStudentId);

		listStudents(request, response);

	}

	private void updateStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// read student info from form data
		int id = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String maLop = request.getParameter("maLop");
		LopHoc lop=classDbUtil.getLopHocTheoTen(maLop);
		// create a new student object
		Student theStudent = new Student(id, firstName, lastName, email,lop);

		// perform update on database
		studentDbUtil.updateStudent(theStudent);

		// send them back to the "list students" page
		listStudents(request, response);

	}

	private void loadStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// read student id from form data
		String theStudentId = request.getParameter("studentId");
		List<LopHoc> lopHocs = classDbUtil.getLopHoc();

		// add students to the request

		// get student from database (db util)
		Student theStudent = studentDbUtil.getTheStudent(theStudentId);

		// place student in the request attribute
		request.setAttribute("THE_STUDENT", theStudent);

		// add students to the request
		request.setAttribute("LOPHOC_LIST", lopHocs);


		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);

	}

	private void addStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read student info from form data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String maLop = request.getParameter("maLop");
		LopHoc ma= classDbUtil.getLopHocTheoTen(maLop);
		// create a new student object
		Student theStudent = new Student(firstName, lastName, email,ma);

		// add the student to the database
		studentDbUtil.addStudent(theStudent);

		// send back to main page (the student list)
		listStudents(request, response);
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get students from db util
		List<Student> students = studentDbUtil.getStudent();

		// add students to the request
		request.setAttribute("STUDENT_LIST", students);

		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);

	}
}