/**
 * 
 */
package _2.Diseño.Negocio.Fair.imp;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import _2.Diseño.Negocio.Employees.imp.Employees;


@Entity
@NamedQueries({
	@NamedQuery(name = "Negocio.Fair.imp.Assist.findBydate", query = "select obj from Assist obj where obj.date = :date"),
	@NamedQuery(name = "Negocio.Fair.imp.Assist.findByFair", query = "select obj from Assist obj where obj.Fair = :Fair and obj.active = 1"),
	@NamedQuery(name = "Negocio.Fair.imp.Assist.findByemployees", query = "select obj from Assist obj where obj.employees = :employees and obj.active = 1"),
	@NamedQuery(name = "Negocio.Fair.imp.Assist.findByactive", query = "select obj from Assist obj where obj.active = :active")
	
})
public class Assist implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Version
	private int version;

	
	@EmbeddedId @GeneratedValue(strategy = GenerationType.IDENTITY)
	private AssistId id;
	
	private boolean active;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("idEmployees")
	private Employees employees;
	
	@ManyToOne
	@MapsId("idFair")
	private Fair Fair;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private int duration;

	
	public Assist() {
		
	}
	
	public Assist(Fair Fair, Employees Employees) {
		this.Fair = Fair;
		this.employees = Employees;
	}
	
	public Assist(int idEmployees, int idFair) {
		id = new AssistId(idEmployees, idFair);
	}
	
	public int getVersion() {
		
		return version;
	}

	
	public void setVersion(int version) {
		
		this.version = version;
	}
	
	public AssistId getId() {
		return id;
	}

	public void setId(AssistId id) {
		this.id = id;
	}
	
	public boolean getActive() {
		return this.active;
	}

	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	public Date getDate() {
		return this.date;
	}
	
	
	public void setDate(Date date) {
		this.date = date;
	}

	
	public int getDuration() {
		return this.duration;
	}

	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees Employees) {
		this.employees = Employees;
	}

	public Fair getFair() {
		return this.Fair;
	}

	public void setFair(Fair Fair) {
		this.Fair = Fair;
	}
	
	public TAssist toTransfer() {
		return new TAssist(this.Fair.getIdFair(), this.employees.getIdEmployees(), this.active);
	}

}