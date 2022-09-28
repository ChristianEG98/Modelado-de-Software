package _2.Diseño.Negocio.Employees.imp;

import java.io.Serializable;
import java.util.List;


import javax.persistence.*;


import _2.Diseño.Negocio.Company.imp.Company;
import _2.Diseño.Negocio.Employees.TEmployees;
import _2.Diseño.Negocio.Employees.TFullTimeEmployees;
import _2.Diseño.Negocio.Employees.TPartTimeEmployees;
import _2.Diseño.Negocio.Fair.imp.Assist;


@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@NamedQueries({
		@NamedQuery(name = "Negocio.Employees.imp.Employees.findByidEmployees", query = "select obj from Employees obj where :idEmployees = obj.idEmployees "),
		@NamedQuery(name = "Negocio.Employees.imp.Employees.findByDni", query = "select obj from Employees obj where :Dni = obj.Dni "),
		@NamedQuery(name = "Negocio.Employees.imp.Employees.findByname", query = "select obj from Employees obj where :name = obj.name "),
		@NamedQuery(name = "Negocio.Employees.imp.Employees.findBylastname", query = "select obj from Employees obj where :lastname = obj.lastName "),
		@NamedQuery(name = "Negocio.Employees.imp.Employees.findByemail", query = "select obj from Employees obj where :email = obj.email "),
		@NamedQuery(name = "Negocio.Employees.imp.Empleado.findByasiste", query = "select obj from Employees obj where :asiste MEMBER OF obj.asiste "),
		@NamedQuery(name = "Negocio.Employees.imp.Employees.readALL", query = "select obj from Employees obj"),
		@NamedQuery(name = "Negocio.Employees.imp.Employees.findByphone", query = "select obj from Employees obj where :phone = obj.phone "),
		@NamedQuery(name = "Negocio.Employees.imp.Employees.findBypayroll", query = "select obj from Employees obj where :payroll = obj.payroll "),
		@NamedQuery(name = "Negocio.Employees.imp.Employees.findByactive", query = "select obj from Employees obj where :active = obj.active "),
		@NamedQuery(name = "Negocio.Employees.imp.Employees.findByversion", query = "select obj from Employees obj where :version = obj.version "),
		@NamedQuery(name = "Negocio.Employees.imp.Employees.findBycompany", query = "select obj from Employees obj where :company = obj.company and obj.active = true ") })

public abstract class Employees implements Serializable {

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmployees;
	private String Dni;
	private String name;
	private String lastName;
	private int phone;
	private String email;
	private Float payroll;
	private Boolean active;
	@ManyToOne
	private Company company;
	
	@OneToMany(mappedBy = "employees")
	private List<Assist> asiste;
	
	public Employees()
	{
		
	}

	public Employees(TEmployees employees)
	{
		this.Dni= employees.getDni();
		this.name= employees.getName();
		this.lastName= employees.getLastName();
		this.email=employees.getEmail();
		this.phone= employees.getPhone();
		this.payroll=employees.getPayroll();
		this.active= employees.getActive();
		this.company=employees.getCompany();
	}
	
		
	
	
	public TEmployees toTransfer()
	{
		if(this instanceof FullTimeEmployees)
			return new TFullTimeEmployees(idEmployees, Dni, name, lastName, phone,email,payroll, active, company, ((FullTimeEmployees)this).getBonus());
		else
			return new TPartTimeEmployees(idEmployees, Dni, name, lastName, phone, email, payroll, active,company,((PartTimeEmployees)this).getHours());
	}
	
	
	@Version
	private Integer version;
	
	public abstract Float calculatePayRoll();
	
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
		Dni = dni;
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
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

	public Company getcompany() {
		return company;
	}

	public void setcompany(Company company) {
		this.company = company;
	}
	
	
}
