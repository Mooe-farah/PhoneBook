package Myphone;

public class PersonInfo {
	private String fullName, address, city;
	private int phoneNumber;
	
	//default constructor
	public PersonInfo() {
		fullName = "";
		address = "";
		city = "";
		 phoneNumber = 0;
	}
	
	public PersonInfo(String fullName, String address, String city, int phoneNumber) {
		this.fullName = fullName;
		this.address = address;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}
	
	//setters
	public void setfullNames(String name) {
		fullName = name;
	}
	
	public void setAddress(String addr) {
		address = addr;
	}
	
	public void setCity(String city) {
		city = city;
	}
	
	public void  setPhoneNumber(int phone) {
		phoneNumber = phone;
	}
	
	//getters
	public String getfullNames() {
		return fullName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}
	
	public int getphoneNumber() {
		return phoneNumber;
	}
}
