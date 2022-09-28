/**
 * 
 */
package _2.Diseño.Negocio.Company.imp;

import java.io.Serializable;
import java.util.List;

import _2.Diseño.Negocio.Employees.imp.Employees;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Jesús Vélez Ayuso
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.persistence.NamedQueries;

@Entity
@NamedQueries({
	@NamedQuery(name = "Negocio.Company.imp.Company.findByidCompany", query = "select obj from Company obj where :idDepartamento = obj.idCompany "),		
	@NamedQuery(name = "Negocio.Company.imp.Company.findByname", query = "select obj from Company obj where :name = obj.name "),
	@NamedQuery(name = "Negocio.Company.imp.Company.findBycif", query = "select obj from Company obj where :cif = obj.cif "),
	@NamedQuery(name = "Negocio.Company.imp.Company.findBynumEmployees", query = "select obj from Company obj where :numEmployees = obj.numEmployees "),
	@NamedQuery(name = "Negocio.Company.imp.Company.findByactive", query = "select obj from Company obj where :active = obj.active "),
	@NamedQuery(name = "Negocio.Company.imp.Company.findAll", query= "select obj from Company obj where obj.active = 1"),})

public class Company implements Serializable {
	
	@OneToMany(mappedBy = "company",fetch = FetchType.EAGER)
	private List<Employees> employees;
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCompany;
	
	
	@Version
	private int version;
	
	private String name;
	
	private String cif;
	
	private int numEmployees;
	
	private boolean active;
	
	
	
	public Company() {}
	
	
	public Company(TCompany tCompany) {
		this.name = tCompany.getName();
		this.cif = tCompany.getCif();
		this.idCompany = tCompany.getIdCompany();
		this.numEmployees = tCompany.getNumEmployees();
		this.active = tCompany.getActive();		
	}

	public int getIdCompany() {
		return this.idCompany;
	}

	public void setName(int idCompany) {
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
		return numEmployees;
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

	public List<Employees> getEmployees() {
		return this.employees;
	}
	
	public void setEmployees(List<Employees> listEmployees) {
		this.employees = listEmployees;
	}

	
	public TCompany toTransfer() {				
		return new TCompany(this.idCompany, this.name, this.cif, this.numEmployees, this.active);
	}
	
}