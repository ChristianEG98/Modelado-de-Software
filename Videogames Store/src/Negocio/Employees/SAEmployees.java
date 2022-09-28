package _2.Diseño.Negocio.Employees;


import java.util.List;

public interface SAEmployees {

	public int createEmployees(TEmployees employees);
	public int deleteEmployees (int idemployees);
	public int modifyEmployees(TEmployees employees);
	public List<TEmployees> listEmployees();
	public TEmployees searchEmployees(int idemployees);
	public TEmployees seacrhEmployeesByDni(String Dni);
	public Float calculatePayRollEmployees(int idEmployees);
	
}
