package _2.Diseño.Negocio.Employees.imp;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import _2.Diseño.Negocio.Employees.TEmployees;
import _2.Diseño.Negocio.Employees.TPartTimeEmployees;


@Entity
@NamedQueries({
@NamedQuery(name = "Negocio.Employees.imp.PartTimeEmployees.findByidemployees", query = "select obj from PartTimeEmployees obj where :idEmployees = obj.idEmployees"),
@NamedQuery(name = "Negocio.Employees.imp.PartTimeEmployees.findByhours", query = "select obj from PartTimeEmployees obj where :hours = obj.hours ") })
public  class PartTimeEmployees extends Employees implements Serializable{

	private int hours;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public PartTimeEmployees() {
		
	}
	
	public PartTimeEmployees(TPartTimeEmployees tPartTimeEmployees)
	{
		super(tPartTimeEmployees);
		this.hours = tPartTimeEmployees.getHours();
		
	
	}
	
	
	@Override
	public TPartTimeEmployees toTransfer() {
		return new TPartTimeEmployees(this.getIdEmployees(), this.getDni(), this.getName(), this.getLastName(), this.getPhone(), this.getEmail(),this.getPayroll(),this.getActive(),this.getcompany(),this.getHours());
	}

	public Float calculatePayRoll() {
		return (this.getPayroll()*this.getHours())*30;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	


	

}
