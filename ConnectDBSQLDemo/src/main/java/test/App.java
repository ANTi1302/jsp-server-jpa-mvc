package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import dao.Student_Dao;
import entity.Student;

public class App {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	ConnectDB.getInstance().connect();
	Student_Dao dao= new Student_Dao();
	 List<Student> list= dao.gettalltbSutdent();
//	 for (Student student : list) {
//		System.out.println(student);
//	}
//	 System.out.println(dao.getNhanVienTheoMaNV("1004"));
	 
}
}
