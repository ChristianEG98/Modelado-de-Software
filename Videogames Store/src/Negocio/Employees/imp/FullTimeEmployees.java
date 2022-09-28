package _2.Diseño.Negocio.Employees.imp;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import _2.Diseño.Negocio.Employees.TFullTimeEmployees;

@Entity
@NamedQueries({
	@NamedQuery(name = "Negocio.Employees.imp.FullTimeEmployees.findByidemployees", query = "select obj from FullTimeEmployees obj where :idEmployees = obj.idEmployees "),
	@NamedQuery(name = "Negocio.Employees.imp.FullTimeEmployees.findBybonus", query = "select obj from FullTimeEmployees obj where :bonus = obj.bonus ") })
public class FullTimeEmployees extends Employees implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Float bonus;

	public FullTimeEmployees(){
		
	}
	public FullTimeEmployees(TFullTimeEmployees tFullTimeEmployees)
	{
		super(tFullTimeEmployees);
		this.bonus = tFullTimeEmployees.getBonus();
		
	
	}
		
	
	@Override
	public TFullTimeEmployees toTransfer() {
		return new TFullTimeEmployees(this.getIdEmployees(), this.getDni(), this.getName(), this.getLastName(), this.getPhone(), this.getEmail(),this.getPayroll(),this.getActive(),this.getcompany(),this.getBonus());
	}

	@Override
	public Float calculatePayRoll() {
		return ((this.getPayroll()*30) * 8) + bonus;
	}

	public void setBonus(Float bonus)
	{
		this.bonus=bonus;
	}
	
	public Float getBonus()
	{
		return this.bonus;
	}
	
}
