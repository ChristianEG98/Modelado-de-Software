/**
 * 
 */
package _2.Diseño.Presentacion.Serviceworker.Dispatcher;

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Client.GUIClient;
import _2.Diseño.Presentacion.Company.GUICompany;
import _2.Diseño.Presentacion.Employees.GUIEmployees;
import _2.Diseño.Presentacion.Fair.GUIFair;
import _2.Diseño.Presentacion.Producto.GUIProduct;
import _2.Diseño.Presentacion.Ticket.GUITicket;
import _2.Diseño.Presentacion.View.GUIMain;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DispatcherImp extends Dispatcher {

	@Override
	public void generateView(Context context) {
		// TODO Auto-generated method stub
		int event = context.getEvent();

		switch (event) {

		case Events.GUI_PRINCIPAL:
			GUIMain.getInstance();
			break;

		// Product
		case Events.CREATE_GUI_PRODUCT:
			GUIProduct.getInstance().setVisible(true);
			break;
		case Events.CREATE_PRODUCT_OK:
		case Events.CREATE_PRODUCT_KO:
		case Events.LIST_PRODUCTS_OK:
		case Events.LIST_PRODUCTS_KO:
		case Events.SEARCH_PRODUCTS_BY_PRICE_OK:
		case Events.SEARCH_PRODUCTS_BY_PRICE_KO:
		case Events.DELETE_PRODUCT_OK:
		case Events.DELETE_PRODUCT_KO:
		case Events.SEARCH_PRODUCT_OK:
		case Events.SEARCH_PRODUCT_KO:
		case Events.SEARCH_MODIFY_PRODUCT_OK:
		case Events.SEARCH_MODIFY_PRODUCT_KO:
		case Events.MODIFY_PRODUCT_OK:
		case Events.MODIFY_PRODUCT_KO:
		case Events.BEST_SELLING_PRODUCTS_OK:
		case Events.BEST_SELLING_PRODUCTS_KO:
			GUIProduct.getInstance().update(context);
			break;
			
		//Ticket
		case Events.CREATE_GUI_TICKET:
			GUITicket.getInstance().setVisible(true);
			break;
		case Events.CREATE_TICKET_OK:
		case Events.CREATE_TICKET_KO:
		case Events.LIST_TICKET_OK:
		case Events.LIST_TICKET_KO:
		case Events.RETURN_PRODUCT_OK:
		case Events.RETURN_PRODUCT_KO:
		case Events.GET_INVOICE_OK:
		case Events.GET_INVOICE_KO:
		case Events.SEARCH_TICKET_OK:
		case Events.SEARCH_TICKET_KO:
		case Events.MODIFY_TICKET_OK:
		case Events.MODIFY_TICKET_KO:
		case Events.CLOSE_TICKET_OK:
		case Events.CLOSE_TICKET_KO:
			GUITicket.getInstance().update(context);
			break;
			
		// Client
		case Events.CREATE_GUI_CLIENT:
			GUIClient.getInstance().setVisible(true);
			break;
		case Events.CREATE_CLIENT_OK:
		case Events.CREATE_CLIENT_KO:
		case Events.LIST_CLIENTS_OK:
		case Events.LIST_CLIENTS_KO:
		case Events.DELETE_CLIENT_OK:
		case Events.DELETE_CLIENT_KO:
		case Events.SEARCH_CLIENT_OK:
		case Events.SEARCH_CLIENT_KO:
		case Events.MODIFY_CLIENT_OK:
		case Events.MODIFY_CLIENT_KO:
		case Events.MODIFY_SEARCH_CLIENT_OK:
		case Events.MODIFY_SEARCH_CLIENT_KO:
		case Events.CUSTOMERS_MORE_X_PURCHASES_OK:
		case Events.CUSTOMERS_MORE_X_PURCHASES_KO:
			GUIClient.getInstance().update(context);
			break;
			
		//FAIR
		case Events.CREATE_GUI_FAIR:
			GUIFair.getInstance().setVisible(true);
			break;
		case Events.CREATE_FAIR_OK:
		case Events.CREATE_FAIR_KO:
		case Events.DELETE_FAIR_OK:
		case Events.DELETE_FAIR_KO:
		case Events.SEARCH_FAIR_OK:
		case Events.SEARCH_FAIR_KO:
		case Events.LIST_FAIRS_OK:
		case Events.LIST_FAIRS_KO:
		case Events.MODIFY_FAIR_OK:
		case Events.MODIFY_FAIR_KO:
		case Events.SEARCH_MODIFY_FAIR_OK:
		case Events.SEARCH_MODIFY_FAIR_KO:
		case Events.ADD_EMPLOYEE_FAIR_OK:
		case Events.ADD_EMPLOYEE_FAIR_KO:
		case Events.DELETE_EMPLOYEE_FAIR_OK:
		case Events.DELETE_EMPLOYEE_FAIR_KO:
		case Events.SHOW_EMPLOYEES_FAIR_OK:
		case Events.SHOW_EMPLOYEES_FAIR_KO:
			GUIFair.getInstance().update(context);
			break;
			
			
		case Events.CREATE_GUI_EMPLOYEES:
			GUIEmployees.getInstance().setVisible(true);
			break;
		case Events.CREATE_EMPLOYEES_OK:
		case Events.CREATE_EMPLOYEES_KO:
		case Events.DELETE_EMPLOYEES_OK:
		case Events.DELETE_EMPLOYEES_KO:
		case Events.SEARCH_EMPLOYEES_OK:
		case Events.SEARCH_EMPLOYEES_KO:
		case Events.LIST_EMPLOYEESS_OK:
		case Events.LIST_EMPLOYEESS_KO:
		case Events.MODIFY_EMPLOYEES_OK:
		case Events.MODIFY_EMPLOYEES_KO:
		case Events.SEARCH_MODIFY_EMPLOYEES_OK:
		case Events.SEARCH_MODIFY_EMPLOYEES_KO:
		case Events.PAYROLL_EMPLOYEES_OK:
		case Events.PAYROLL_EMPLOYEES_KO:
		case Events.PAYROLL_EMPLOYEE_OK:
		case Events.PAYROLL_EMPLOYEE_KO:
		case Events.SEARCH_BY_DNI_EMPLOYEES_OK:
		case Events.SEARCH_BY_DNI_EMPLOYEES_KO:
			GUIEmployees.getInstance().update(context);
			break;
			
		case Events.CREATE_GUI_COMPANY:
			GUICompany.getInstance().setVisible(true);
			break;
		case Events.CREATE_COMPANY_OK:
		case Events.CREATE_COMPANY_KO:
		case Events.DELETE_COMPANY_OK:
		case Events.DELETE_COMPANY_KO:
		case Events.SEARCH_COMPANY_OK:
		case Events.SEARCH_COMPANY_KO:
		case Events.LIST_COMPANIES_OK:
		case Events.LIST_COMPANIES_KO:
		case Events.MODIFY_COMPANY_OK:
		case Events.MODIFY_COMPANY_KO:
		case Events.SEARCH_MODIFY_COMPANY_OK:
		case Events.SEARCH_MODIFY_COMPANY_KO:
		case Events.CALCULATE_PAYROLL_COMPANY_OK:
		case Events.CALCULATE_PAYROLL_COMPANY_KO:
			GUICompany.getInstance().update(context);
			break;
	}
	}
}