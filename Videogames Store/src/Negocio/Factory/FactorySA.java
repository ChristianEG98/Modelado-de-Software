/**
 * 
 */
package _2.Diseño.Negocio.Factory;


import _2.Diseño.Negocio.Client.SAClient;
import _2.Diseño.Negocio.Company.SACompany;
import _2.Diseño.Negocio.Employees.SAEmployees;
import _2.Diseño.Negocio.Fair.SAFair;
import _2.Diseño.Negocio.Product.SAProduct;
import _2.Diseño.Negocio.Ticket.SATicket;


public abstract class FactorySA {
	
	private static FactorySA instance;

	
	public static FactorySA getInstance() {
		if(instance == null){
			instance = new FactorySAImp();
		}
		return instance;
	}

	
	public abstract SAProduct createSAProduct();
	
	
	public abstract SATicket createSATicket();
	
	
	public abstract SAClient createSAClient();
	
	public abstract SAFair createSAFair();
	
	public abstract SAEmployees createSAEmployees();
	
	public abstract SACompany createSACompany();
}