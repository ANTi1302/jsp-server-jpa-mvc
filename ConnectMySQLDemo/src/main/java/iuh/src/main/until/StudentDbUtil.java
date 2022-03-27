package iuh.src.main.until;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import iuh.src.main.model.LopHoc;
import iuh.src.main.model.Student;

public class StudentDbUtil {

	private DataSource dataSource;
	
	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public void deleteStudent(String theStudentId) throws Exception{
		// TODO Auto-generated method stub
		
		Connection myConn = null;
		PreparedStatement myStmt = null;	
		
		try {
			//convert student id to int
			int studentId = Integer.parseInt(theStudentId);
			
			//get db connection
			myConn = dataSource.getConnection();

			//create SQL delete statement
			String sql = "delete from  student where id=?";
			
			//prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setInt(1, studentId);
			
			//execute SQL statement
			myStmt.execute();
			
		}finally {
			//clean up JDBC code
			close(myConn, myStmt, null);
		}
		
	}
	

	public void updateStudent(Student theStudent)throws Exception {
		// TODO Auto-generated method stub
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			//create SQL update statement
			String sql = "update student "
						+ "set firstname = ?, lastname = ?, email=?, maLop=? "
						+ "where id=?";
			
			//prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getEmail());
			myStmt.setInt(4, theStudent.getMaLop().getMaLop());
			myStmt.setInt(5, theStudent.getId());
	
			//execute SQL statement
			myStmt.execute();
		}
		finally {
			close(myConn, myStmt, null);
			
		}
	}
	
	public Student getTheStudent(String theStudentId) throws Exception {
		// TODO Auto-generated method stub
		
		Student theStudent = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int studentId;
		
		try {
			//convert student id to int
			studentId = Integer.parseInt(theStudentId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to get selected student
			String sql = "select * from student where id = ?";
			
			//create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setInt(1, studentId);
			
			//execute statement
			myRs = myStmt.executeQuery();
			
			//retrieve data from result set row
			if(myRs.next()) {
				String firstName = myRs.getString("firstname");
				String lastName = myRs.getString("lastname");
				String email = myRs.getString("email");
				int maLop = myRs.getInt("maLop");
				LopHoc lop=new LopHoc(maLop);
				//use the studentId during construction
				theStudent = new Student(studentId, firstName, lastName, email,lop);
			}else {
				throw new Exception("Could not find student id: " + studentId);
			}
			
			return theStudent;
			
		}finally {
			
			//clean p JDBC objects
			close(myConn, myStmt, myRs);
			
		}
		
	}

	
	public void addStudent(Student theStudent) throws Exception{
		// TODO Auto-generated method stub
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			//create sql for insert
			String sql = "insert into student\r\n"
					+ "						(firstname,lastname, email,maLop)\r\n"
					+ "						values (?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);

			//set the param values for the student
			myStmt.setString(1,theStudent.getFirstName());
			myStmt.setString(2,theStudent.getLastName());
			myStmt.setString(3,theStudent.getEmail());
			myStmt.setInt(4,theStudent.getMaLop().getMaLop());
			//execute sql insert
			myStmt.execute();
		}
		
		finally {
		
			//clean up JDBC objects
			close(myConn, myStmt, null);
			
		}
		
	}
	
	public List<Student> getStudent() throws Exception{
		List<Student> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		
		try {
		// get a connection
		myConn = dataSource.getConnection();
		
		//create sql statement
		String sql = "select * from student ";
		myStmt = myConn.createStatement();
		
		//execute query
		myRs = myStmt.executeQuery(sql);
		
		//process result set
		while(myRs.next()) {
			//retrieve data from result set row
			int id = myRs.getInt("id");
			String firstName = myRs.getString("firstname");
			String lastName = myRs.getString("lastname");
			String email = myRs.getString("email");
			
			//create new student object
			Student tempStudent = new Student(id, firstName, lastName, email);
			
			//add it to the list of students
			students.add(tempStudent);
		}
		
		
			return students;

			
		}finally {
			//close JDBC objects
			close(myConn, myStmt, myRs);
			
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		// TODO Auto-generated method stub
		try {
			if(myRs != null) {
				myRs.close();
			}
			if(myStmt !=null) {
				myStmt.close();
			}
			if(myConn !=null) {
				myConn.close(); //doesn't really close it ... just puts back in connection pool
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	
}