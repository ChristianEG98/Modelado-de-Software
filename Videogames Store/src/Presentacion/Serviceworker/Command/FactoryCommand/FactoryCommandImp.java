/**
 * 
 */
package _2.Diseño.Presentacion.Serviceworker.Command.FactoryCommand;

import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Command.Command;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandClient.CommandCreateClient;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandClient.CommandCustomersWhoHaveMadeMoreThan_X_Purchases;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandClient.CommandDeleteClient;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandClient.CommandListClient;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandClient.CommandModifyClient;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandClient.CommandModifySearchClient;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandClient.CommandSearchClient;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandCompany.CommandCalculatePayrollCompany;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandCompany.CommandCreateCompany;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandCompany.CommandDeleteCompany;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandCompany.CommandListCompanies;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandCompany.CommandModifyCompany;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandCompany.CommandSearchCompany;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandCompany.CommandSearchModifyCompany;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandEmployees.CommandCreateEmployees;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandEmployees.CommandDeleteEmployees;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandEmployees.CommandListEmployees;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandEmployees.CommandModifyEmployees;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandEmployees.CommandModifySearchEmployees;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandEmployees.CommandPayRollEmployees;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandEmployees.CommandSearchByDniEmployees;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandEmployees.CommandSearchEmployees;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandFair.CommandAddEmployeesFair;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandFair.CommandCreateFair;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandFair.CommandDeleteEmployeesFair;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandFair.CommandDeleteFair;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandFair.CommandListFairs;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandFair.CommandModifyFair;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandFair.CommandModifySearchFair;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandFair.CommandSearchFair;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandFair.CommandShowEmployees;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandProduct.CommandBestSellingProducts;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandProduct.CommandCreateProduct;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandProduct.CommandDeleteProduct;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandProduct.CommandListProducts;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandProduct.CommandModifyProduct;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandProduct.CommandSearchModifyProduct;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandProduct.CommandSearchProduct;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandProduct.CommandSearchProductsByPrice;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandTicket.CommandCloseTicket;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandTicket.CommandCreateTicket;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandTicket.CommandGetInvoice;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandTicket.CommandListTickets;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandTicket.CommandModifyTicket;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandTicket.CommandReturnTicket;
import _2.Diseño.Presentacion.Serviceworker.Command.CommandTicket.CommandSearchTicket;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoryCommandImp extends FactoryCommand {

	@Override
	public Command generateCommand(int event) {
		switch (event) {
		
		//Product
		case Events.CREATE_PRODUCT:
			return new CommandCreateProduct();
		case Events.DELETE_PRODUCT:
			return new CommandDeleteProduct();
		case Events.SEARCH_PRODUCT:
			return new CommandSearchProduct();
		case Events.LIST_PRODUCTS:
			return new CommandListProducts();
		case Events.MODIFY_PRODUCT:
			return new CommandModifyProduct();
		case Events.SEARCH_MODIFY_PRODUCT:
			return new CommandSearchModifyProduct();
		case Events.SEARCH_PRODUCTS_BY_PRICE:
			return new CommandSearchProductsByPrice();
		case Events.BEST_SELLING_PRODUCTS:
			return new CommandBestSellingProducts();
		
		//Client
		case Events.CREATE_CLIENT:
			return new CommandCreateClient();
		case Events.DELETE_CLIENT:
			return new CommandDeleteClient();
		case Events.SEARCH_CLIENT:
			return new CommandSearchClient();
		case Events.LIST_CLIENTS:
			return new CommandListClient();
		case Events.MODIFY_CLIENT:
			return new CommandModifyClient();
		case Events.MODIFY_SEARCH_CLIENT:
			return new CommandModifySearchClient();
		case Events.CUSTOMERS_MORE_X_PURCHASES:
			return new CommandCustomersWhoHaveMadeMoreThan_X_Purchases();
		
		//Ticket
		case Events.CREATE_TICKET:
			return new CommandCreateTicket();
		case Events.CLOSE_TICKET:
			return new CommandCloseTicket();
		case Events.GET_INVOICE:
			return new CommandGetInvoice();
		case Events.MODIFY_TICKET:
			return new CommandModifyTicket();
		case Events.SEARCH_TICKET:
			return new CommandSearchTicket();
		case Events.LIST_TICKET:
			return new CommandListTickets();
		case Events.RETURN_PRODUCT:
			return new CommandReturnTicket();
			
		//Feria
		case Events.CREATE_FAIR:
			return new CommandCreateFair();
		case Events.DELETE_FAIR:
			return new CommandDeleteFair();
		case Events.SEARCH_FAIR:
			return new CommandSearchFair();
		case Events.SEARCH_MODIFY_FAIR:
			return new CommandModifySearchFair();
		case Events.MODIFY_FAIR:
			return new CommandModifyFair();
		case Events.LIST_FAIRS:
			return new CommandListFairs();
		case Events.ADD_EMPLOYEE_FAIR:
			return new CommandAddEmployeesFair();
		case Events.DELETE_EMPLOYEE_FAIR:
			return new CommandDeleteEmployeesFair();
		case Events.SHOW_EMPLOYEES_FAIR:
			return new CommandShowEmployees();
		//Employees
		case Events.CREATE_EMPLOYEES:
			return new CommandCreateEmployees();
		case Events.DELETE_EMPLOYEES:
			return new CommandDeleteEmployees();
		case Events.LIST_EMPLOYEESS:
			return new CommandListEmployees();
		case Events.MODIFY_EMPLOYEES:
			return new CommandModifyEmployees();
		case Events.SEARCH_EMPLOYEES:
			return new CommandSearchEmployees();
		case Events.SEARCH_MODIFY_EMPLOYEES:
			return new CommandModifySearchEmployees();
		case Events.SEARCH_BY_DNI_EMPLOYEES:
			return new  CommandSearchByDniEmployees();
		case Events.PAYROLL_EMPLOYEES:
			return new CommandPayRollEmployees();
		
		//Company
		case Events.CREATE_COMPANY:
			return new CommandCreateCompany();
		case Events.DELETE_COMPANY:
			return new CommandDeleteCompany();
		case Events.MODIFY_COMPANY:
			return new CommandModifyCompany();
		case Events.LIST_COMPANIES:
			return new CommandListCompanies();
		case Events.SEARCH_COMPANY:
			return new CommandSearchCompany();
		case Events.SEARCH_MODIFY_COMPANY:
			return new CommandSearchModifyCompany();
		case Events.CALCULATE_PAYROLL_COMPANY:
			return new CommandCalculatePayrollCompany();
			
		default:
			return null;	
			}
		}
}