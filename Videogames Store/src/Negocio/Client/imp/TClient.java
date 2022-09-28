package _2.Diseño.Negocio.Client.imp;

public class TClient {
	private int idClient;
	private String name;
	private String lastName;
	private String email;
	private String DNI;
	private int phone;
	private Boolean active;
	
	public TClient (int idClient, String name, String lastName, String email, String DNI, int phone, Boolean active)
	{
		this.idClient=idClient;
		this.name= name;
		this.lastName=lastName;
		this.email=email;
		this.DNI=DNI;
		this.phone=phone;
		this.active=active;
		
	}
	
	public TClient ( String name, String lastName, String email, String DNI, int phone, Boolean active)
	{
		this.name=name;
		this.lastName=lastName;
		this.email=email;
		this.DNI=DNI;
		this.phone=phone;
		this.active=active;
	}
	
	
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
}
