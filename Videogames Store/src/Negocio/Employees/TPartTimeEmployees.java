package _2.Diseño.Negocio.Employees;

import _2.Diseño.Negocio.Company.imp.Company;

public class TPartTimeEmployees extends TEmployees {

	private int hours;
	
	public TPartTimeEmployees(int idEmployees, String Dni, String name, String lastName, int phone, String email,
			Float payroll, Boolean active, Company company,int hours) {
		super(idEmployees, Dni, name, lastName, phone, email, payroll, active,company);
		this.hours=hours;
	
	}
	
	public TPartTimeEmployees( String Dni, String name, String lastName, int phone, String email,
			Float payroll, Boolean active,Company company,int hours) {
		super( Dni, name, lastName, phone, email, payroll, active,company);
		this.hours=hours;
		
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	
	
	
	
	
}
