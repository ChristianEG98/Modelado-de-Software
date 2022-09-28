package _2.Diseño.Negocio.Employees;

import _2.Diseño.Negocio.Company.imp.Company;

public class TEmployees {
	
	private int idEmployees;
	private String Dni;
	private String name;
	private String lastName;
	private Integer phone;
	private String email;
	private Float payroll;
	private Boolean active;
	private Company company;
	
	public TEmployees(int idEmployees, String Dni, String name, String lastName, Integer phone, String email, Float payroll, Boolean active,Company company)
	{
		this.idEmployees= idEmployees;
		this.Dni= Dni;
		this.name= name;
		this.lastName=lastName;
		this.phone= phone;
		this.email= email;
		this.payroll= payroll;
		this.active=active;
		this.company= company;
		
	}
	
	
	public TEmployees(String Dni, String name, String lastName, Integer phone, String email, Float payroll, Boolean active, Company company)
	{
		this.Dni= Dni;
		this.name= name;
		this.lastName=lastName;
		this.phone= phone;
		this.email= email;
		this.payroll= payroll;
		this.active=active;
		this.company=company;
	}
	
	
	
	public int getIdEmployees() {
		return idEmployees;
	}
	public void setIdEmployees(int idEmployees) {
		this.idEmployees = idEmployees;
	}
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		this.Dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Float getPayroll() {
		return payroll;
	}
	public void setPayroll(Float payroll) {
		this.payroll = payroll;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}
}
