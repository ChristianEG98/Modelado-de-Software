/**
 * 
 */
package _2.Diseño.Negocio.Fair.imp;

import java.util.Date;


public class TAssist {
	
	private boolean active;
	
	private int employees;
	
	private int fair;
	
	private Date date;
	
	private int duration;

	
	public TAssist(int fair, int employees, boolean active) {
		this.fair = fair;
		this.employees = employees;
		this.active = active;
	}
	
	public boolean getActive() {
		return this.active;
	}

	
	public void setActive(boolean active) {
		this.active = active;
	}

	
	public Date getdate() {
		return this.date;
	}

	
	public void setdate(Date date) {
		this.date = date;
	}

	
	public int getduration() {
		return this.duration;
	}

	
	public void setduration(int duration) {
		this.duration = duration;
	}

		
	public int getemployees() {
		return this.employees;
	}

	public void setemployees(int employees) {
		this.employees = employees;
	}
	
	public int getfair() {
		return this.fair;
	}

	public void setfair(int fair) {
		this.fair = fair;
	}

}