package Myphone;
import java.sql.*;
import java.util.*;
import java.sql.*; 
import java.sql.*;
public class PersonDAO {
	/* Person Table needs to be created in the SQL Server Database.
	 * create table Person (
	fullNames Varchar(30),
	address Varchar(30),
	city Varchar(30),
	phoneNumber Integer,
);*/
	
	private ArrayList personsList;
	private String user = "sa";
	private String password = "Farah2022";
	private String Url = "jdbc:sqlserver://REHAAN10\\SQLEXPRESS01; " + " databaseName = MyPhoneBook; user = sa; password = Farah2022;encrypt=true;trustServerCertificate=true";
	
	private Connection conn;
	
	//constructor
	public PersonDAO() {
		personsList = new ArrayList();
		getConnection(); //Create Connection to the SQL Server Database
	}
		
	//this is code for connecting to the Database
	public Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch(java.lang.ClassNotFoundException e) {
			System.err.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		
		try {
			conn = DriverManager.getConnection(Url, user, password);
		} catch(SQLException es) {
			System.err.println("SQLException: " + es.getMessage());
		}
		
		return conn;
	}
	
	public void SavePerson(PersonInfo person) {
		try {
			String sql =  "INSERT INTO Person_Details (fullName, address, " +
					"phoneNumber, city) VALUES (?,?,?,?) ";
 			PreparedStatement ps = conn.prepareStatement(sql);
 			ps.setString(1, person.getfullNames());
			ps.setString(2, person.getAddress());
			ps.setInt(3, person.getphoneNumber());
			ps.setString(4, person.getCity());

			ps.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	//code for searching from the from the data using their full names
	public ArrayList searchPerson(String fullName) {
		try {
			String sql = "SELECT * FROM Person_Details  WHERE fullName like '%"+ fullName +"%'";
			//create a prepared statement
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			String fullNames = "";
			String address = "";
			String city = "";
			
			int phoneNumber;
			
				while(rs.next()) {
					fullName = rs.getString("fullName");
					address = rs.getString("address");
					city = rs.getString("city");
					phoneNumber = rs.getInt("phoneNumber");
					
					//create a personInfo object
					PersonInfo person = new PersonInfo(fullName, address, city, phoneNumber);
					//add the person object to array list
					personsList.add(person);
				}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return personsList;
	}
	
	public void UpdatePerson(PersonInfo person) {
		try {
			String sql = "Update Person_Details  SET fullName = ?, address = ?, city = ?, phoneNumber = ?,";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1 , person.getfullNames());		
			ps.setString(2 , person.getAddress());
			ps.setInt(3 , person.getphoneNumber());
			ps.setString(4 , person.getCity());
			ps.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	//deleting from the record
	public int removePerson(String name) {
		int no = 0;
		try {
			String sql = "DELETE FROM Person_Details  WHERE fullName = ?";
			//create a prepared statement
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			no = ps.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return no;
	}
	
}
