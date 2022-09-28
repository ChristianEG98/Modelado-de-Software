/**
 * 
 */
package _2.Diseño.Negocio.Factory;

import _2.Diseño.Negocio.Client.SAClient;
import _2.Diseño.Negocio.Client.imp.SAClientImp;
import _2.Diseño.Negocio.Company.SACompany;
import _2.Diseño.Negocio.Company.imp.SACompanyImp;
import _2.Diseño.Negocio.Employees.SAEmployees;
import _2.Diseño.Negocio.Employees.imp.SAEmployeesImp;
import _2.Diseño.Negocio.Fair.SAFair;
import _2.Diseño.Negocio.Fair.imp.SAFairImp;
import _2.Diseño.Negocio.Product.SAProduct;
import _2.Diseño.Negocio.Product.imp.SAProductImp;
import _2.Diseño.Negocio.Ticket.SATicket;
import _2.Diseño.Negocio.Ticket.imp.SATicketImp;


public class FactorySAImp extends FactorySA {
	
	@Override
	public SAProduct createSAProduct() {
		return new SAProductImp();
	}

	@Override
	public SATicket createSATicket() {
		return new SATicketImp();
	}

	@Override
	public SAClient createSAClient() {
		return new SAClientImp();
	}

	@Override
	public SAFair createSAFair() {
		return new SAFairImp();
	}

	@Override
	public SAEmployees createSAEmployees() {
		// TODO Auto-generated method stub
		return new SAEmployeesImp();
	}

	@Override
	public SACompany createSACompany() {
		return new SACompanyImp();
	}
}