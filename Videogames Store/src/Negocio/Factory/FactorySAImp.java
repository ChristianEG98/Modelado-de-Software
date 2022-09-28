/**
 * 
 */
package _2.Dise�o.Negocio.Factory;

import _2.Dise�o.Negocio.Client.SAClient;
import _2.Dise�o.Negocio.Client.imp.SAClientImp;
import _2.Dise�o.Negocio.Company.SACompany;
import _2.Dise�o.Negocio.Company.imp.SACompanyImp;
import _2.Dise�o.Negocio.Employees.SAEmployees;
import _2.Dise�o.Negocio.Employees.imp.SAEmployeesImp;
import _2.Dise�o.Negocio.Fair.SAFair;
import _2.Dise�o.Negocio.Fair.imp.SAFairImp;
import _2.Dise�o.Negocio.Product.SAProduct;
import _2.Dise�o.Negocio.Product.imp.SAProductImp;
import _2.Dise�o.Negocio.Ticket.SATicket;
import _2.Dise�o.Negocio.Ticket.imp.SATicketImp;


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