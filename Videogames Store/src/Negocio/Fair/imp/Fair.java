/**
 * 
 */
package _2.Diseño.Negocio.Fair.imp;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


@Entity
@NamedQueries({
		@NamedQuery(name = "Negocio.Fair.imp.Fair.readAll", query = "select obj from Fair obj where obj.active = 1"),
		@NamedQuery(name = "Negocio.Fair.imp.Fair.findByid", query = "select obj from Fair obj where :id = obj.idFair "),
		@NamedQuery(name = "Negocio.Fair.imp.Fair.findByname", query = "select obj from Fair obj where obj.nameFair = :name "),
		@NamedQuery(name = "Negocio.Fair.imp.Fair.findByplace", query = "select obj from Fair obj where :place = obj.place "),
		@NamedQuery(name = "Negocio.Fair.imp.Fair.findBycapacity", query = "select obj from Fair obj where :capacity = obj.capacity "),
		@NamedQuery(name = "Negocio.Fair.imp.Fair.findByactive", query = "select obj from Fair obj where :active = obj.active "),
		@NamedQuery(name = "Negocio.Fair.imp.Fair.findByversion", query = "select obj from Fair obj where :version = obj.version "),
		@NamedQuery(name = "Negocio.Fair.imp.Fair.findByassist", query = "select obj from Fair obj where :assist MEMBER OF obj.assist ")
})
public class Fair implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Version
	private int version;
	
	private boolean active;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFair;
	
	private String place;
	
	private int capacity;
	
	private String nameFair;
	
	@OneToMany(mappedBy = "Fair", fetch = FetchType.EAGER)
	private List<Assist> assist;


	public Fair() {
		// begin-user-code
		// TODO Auto-generated constructor stub
		// end-user-code
	}

	public Fair(TFair tFair) {
		this.idFair = tFair.getIdFair();
		this.active = tFair.getActive();
		this.capacity = tFair.getCapacity();
		this.place = tFair.getPlace();
		this.nameFair = tFair.getNameFair();
	}

	
	public boolean getActive() {
		return this.active;
	}

	
	public void setActive(boolean active) {
		this.active = active;
	}

	
	public int getCapacity() {
		return this.capacity;
	}

	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	
	public int getIdFair() {
		return this.idFair;
	}

	
	public void setIdFair(int idFair) {
		this.idFair = idFair;
	}

	
	public String getPlace() {
		return this.place;
	}

	
	public void setPlace(String place) {
		this.place = place;
	}

	
	public String getNameFair() {
		return this.nameFair;
	}

	
	public void setNameFair(String nameFair) {
		this.nameFair = nameFair;
	}

	
	public TFair toTransfer() {
		return new TFair(this.idFair, this.active, this.capacity, this.place, this.nameFair);
	}


}