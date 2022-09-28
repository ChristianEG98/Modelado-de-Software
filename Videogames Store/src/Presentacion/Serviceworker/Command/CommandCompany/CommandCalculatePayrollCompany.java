/**
 * 
 */
package _2.Dise�o.Presentacion.Serviceworker.Command.CommandCompany;

import _2.Dise�o.Negocio.Company.imp.TCompany;
import _2.Dise�o.Negocio.Factory.FactorySA;
import _2.Dise�o.Presentacion.Context;
import _2.Dise�o.Presentacion.Events;
import _2.Dise�o.Presentacion.Serviceworker.Command.Command;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class CommandCalculatePayrollCompany implements Command{
	
	@Override
	public Context execute(Object details) {
	
		float suma = FactorySA.getInstance().createSACompany().calculatePayroll((int)details);
		
		if(suma > 0){
			return new Context(Events.CALCULATE_PAYROLL_COMPANY_OK, suma);
		}
		else {
			return new Context(Events.CALCULATE_PAYROLL_COMPANY_KO, suma);
		}
	}
}