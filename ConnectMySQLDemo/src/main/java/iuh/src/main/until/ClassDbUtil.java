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

public class ClassDbUtil {
private DataSource dataSource;
	
	public ClassDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public void deleteClass(String theStudentId) throws Exception{
		// TODO Auto-generated method stub
		
		Connection myConn = null;
		PreparedStatement myStmt = null;	
		
		try {
			//convert student id to int
			int studentId = Integer.parseInt(theStudentId);
			
			//get db connection
			myConn = dataSource.getConnection();

			//create SQL delete statement
			String sql = "delete from  class where maLop=?";
			
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
	
	public void updateClass(LopHoc theStudent)throws Exception {
		// TODO Auto-generated method stub
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			//create SQL update statement
			String sql = "update class "
						+ "set tenLop = ?, soPhong = ?, soTiet=? "
						+ "where maLop=?";
			
			//prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setString(1, theStudent.getTenLop());
			myStmt.setString(2, theStudent.getSoPhong());
			myStmt.setInt(3, theStudent.getSoTiet());
			myStmt.setInt(4, theStudent.getMaLop());
	
			//execute SQL statement
			myStmt.execute();
		}
		finally {
			close(myConn, myStmt, null);
			
		}
	}
//	select * from class where tenLop = 'DHKTPM15CTT'
	public LopHoc getLopHocTheoTen(String theStudentId) throws Exception {
		// TODO Auto-generated method stub
		
		LopHoc theStudent = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//convert student id to int
			
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to get selected student
			String sql = "select maLop from class where tenLop = ?";
			
			//create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setString(1, theStudentId);
			
			//execute statement
			myRs = myStmt.executeQuery();
			
			//retrieve data from result set row
			if(myRs.next()) {
				int studentId=myRs.getInt("maLop");
	
				
				//use the studentId during construction
				theStudent = new LopHoc(studentId);
			}else {
				throw new Exception("Could not find student id: " + theStudentId);
			}
			
			return theStudent;
			
		}finally {
			
			//clean p JDBC objects
			close(myConn, myStmt, myRs);
			
		}
		
	}
	public LopHoc getLopHoc(String theStudentId) throws Exception {
		// TODO Auto-generated method stub
		
		LopHoc theStudent = null;
		
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
			String sql = "select * from class where maLop = ?";
			
			//create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setInt(1, studentId);
			
			//execute statement
			myRs = myStmt.executeQuery();
			
			//retrieve data from result set row
			if(myRs.next()) {
				String tenLop = myRs.getString("tenLop");
				String soPhong = myRs.getString("soPhong");
				int soTiet = myRs.getInt("soTiet");
				
				//use the studentId during construction
				theStudent = new LopHoc(studentId, tenLop, soPhong, soTiet);
			}else {
				throw new Exception("Could not find student id: " + studentId);
			}
			
			return theStudent;
			
		}finally {
			
			//clean p JDBC objects
			close(myConn, myStmt, myRs);
			
		}
		
	}

//	select firstname,lastname,email from student join  class on class.maLop=student.maLop
//			where class.maLop=3
	
	public List<Student> getLopHocTheoMa(int maLop) throws Exception{
		List<Student> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		
		try {
		// get a connection
		myConn = dataSource.getConnection();
		
		//create sql statement
		String sql = "select id,firstname,lastname,email from student join  class on class.maLop=student.maLop\r\n"
				+ "where class.maLop= "+maLop+"";
		myStmt = myConn.createStatement();
		
		//execute query
		myRs = myStmt.executeQuery(sql);
		
		//process result set
		while(myRs.next()) {
			//retrieve data from result set row
			int id= myRs.getInt("id");
			String firstName = myRs.getString("firstName");
			String lastName = myRs.getString("lastName");
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
	
	public void addLopHoc(LopHoc theStudent) throws Exception{
		// TODO Auto-generated method stub
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			//create sql for insert
			String sql = "INSERT  into class(tenLop,soPhong,soTiet) values (?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);

			//set the param values for the student
			myStmt.setString(1,theStudent.getTenLop());
			myStmt.setString(2,theStudent.getSoPhong());
			myStmt.setInt(3,theStudent.getSoTiet());
			//execute sql insert
			myStmt.execute();
		}
		
		finally {
		
			//clean up JDBC objects
			close(myConn, myStmt, null);
			
		}
		
	}
	
	public List<LopHoc> getLopHoc() throws Exception{
		List<LopHoc> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		
		try {
		// get a connection
		myConn = dataSource.getConnection();
		
		//create sql statement
		String sql = "select * from class ";
		myStmt = myConn.createStatement();
		
		//execute query
		myRs = myStmt.executeQuery(sql);
		
		//process result set
		while(myRs.next()) {
			//retrieve data from result set row
			int id = myRs.getInt("maLop");
			String firstName = myRs.getString("tenLop");
			String lastName = myRs.getString("soPhong");
			int soTiet = myRs.getInt("soTiet");
			
			//create new student object
			LopHoc tempStudent = new LopHoc(id, firstName, lastName, soTiet);
			
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
