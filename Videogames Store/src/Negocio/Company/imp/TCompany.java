/**
 * 
 */
package _2.Diseño.Negocio.Company.imp;

import java.util.ArrayList;
import _2.Diseño.Negocio.Employees.TEmployees;


public class TCompany {
	
	private int idCompany;
	
	private String name;
	
	private String cif;
	
	private int numEmployees;
	
	private boolean active;

	
	private ArrayList<TEmployees>employees;
	
	
	public TCompany(int idCompany, String name, String cif, int numEmployees, boolean active) {
		this.idCompany = idCompany;
		this.name = name;
		this.cif = cif;
		this.numEmployees = numEmployees;
		this.active = active;
	}
	
	public TCompany( String name, String cif, int numEmployees, boolean active) {
		this.name = name;
		this.cif = cif;
		this.numEmployees = numEmployees;
		this.active = active;
	}
	
	public int getIdCompany() {
		return this.idCompany;
	}
	
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCif() {
		return this.cif;
	}
	
	public void setCif(String cif) {
		this.cif = cif;
	}
	
	public int getNumEmployees() {
		return this.numEmployees;
	}
	
	public void setNumEmployees(int numEmployees) {
		this.numEmployees = numEmployees;
	}
	
	public boolean getActive() {
		return this.active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public ArrayList<TEmployees> getEmployees() {
		return this.employees;
	}
	
	public void setEmployees(ArrayList<TEmployees> employees) {
		this.employees = employees;
	}

}