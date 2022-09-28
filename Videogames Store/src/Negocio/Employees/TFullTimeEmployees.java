package _2.Diseño.Negocio.Employees;

import _2.Diseño.Negocio.Company.imp.Company;

public class TFullTimeEmployees extends TEmployees{
	
	private Float bonus;

	public TFullTimeEmployees(int idEmployees, String Dni, String name, String lastName, int phone, String email,
			Float payroll, Boolean active,Company company, Float bonus) {
		super(idEmployees, Dni, name, lastName, phone, email, payroll, active,company);
		this.bonus= bonus;
		
	}

	public TFullTimeEmployees( String Dni, String name, String lastName, int phone, String email,
			Float payroll, Boolean active,Company  company, Float bonus) {
		super( Dni, name, lastName, phone, email, payroll, active,company);

		this.bonus=bonus;
	}

	public Float getBonus() {
		return bonus;
	}

	public void setBonus(Float bonus) {
		this.bonus = bonus;
	}
}
