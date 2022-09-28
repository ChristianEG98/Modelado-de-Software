/**
 * 
 */
package _2.Diseño.Negocio.Fair.imp;
import javax.persistence.*;
import java.io.Serializable;


@Embeddable
public class AssistId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int idEmployees;
	
	
	private int idFair;
	

	public AssistId() {
		
	}

	
	public AssistId(int fair, int employees) {
		this.idFair = fair;
		this.idEmployees = employees;
	}
	
	
	public boolean equals(Object o) {
		if (o == this){
			return true;
		}
		if (!(o instanceof AssistId)){
			return false;
		}
		AssistId id = (AssistId) o;
		if(!(idFair == id.idFair))
			return false;
		if(!(idEmployees == id.idEmployees))
			return false;
		return true;
	}

	
	public int getidEmployees() {
		return this.idEmployees;
	}
	
	
	public void setidEmployees(int empleado) {
		this.idEmployees = empleado;
	}
	
	
	public int getidFair() {
		return this.idFair;
	}
	
	public void setFeria(int feria) {
		this.idFair = feria;
	}
	
	public int hashCode() {
		int ok = 0;
		ok += idFair;
		ok += idEmployees;
		return ok;
	}
}