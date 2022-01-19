package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.Student;

public class Student_Dao {
	
	public ArrayList<Student> gettalltbSutdent() throws ClassNotFoundException {
		ArrayList<Student> dsTaiKhoan=new ArrayList<Student>();
		try {
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql="select * from [dbo].[Student]";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while (rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				boolean gender=rs.getBoolean(3);
				Date dob=rs.getDate(4);
				Student student= new Student(id, name, gender, dob);
				dsTaiKhoan.add(student);
				
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsTaiKhoan;
	}
	
	public boolean update(String id, String name, String gender, String dob) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("update [dbo].[Student] set name =? , gender = ?, dob = ? where [StudentID] = ?");
			stmt.setString(1,name);
			stmt.setString(2,gender);
			stmt.setString(3,dob);
			stmt.setString(4, id);
			n=stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}return n>0;
	}

	public boolean create(String name, String gender, String dob) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into"+" [dbo].[Student] values(?, ?, ?)");
			stmt.setString(1,name);
			stmt.setString(2,gender);
			stmt.setString(3,dob);
			
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}return n>0;
	}
	public boolean delete(String id) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("delete from [dbo].[Student] where [StudentID] =?");
			stmt.setString(1, id);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	public Student getNhanVienTheoMaNV(String ma) throws ClassNotFoundException {
		Student nv = null;
		
		
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance().connect();
			Connection con = (Connection) ConnectDB.getConnection();
			String sql = "select* from [dbo].[Student] where [StudentID] =?";
			statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();
			if (rs.next() == false) {
				return nv;
			} else {
				int maNV = rs.getInt("StudentID");
				String tenNV = rs.getString("name");
				Boolean gender = rs.getBoolean("gender");
				Date dob=rs.getDate("dob");
				nv = new Student(maNV, tenNV, gender, dob);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return nv;
	}
	
}
