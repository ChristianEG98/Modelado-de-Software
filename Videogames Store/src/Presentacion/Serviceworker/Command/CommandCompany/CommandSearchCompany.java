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
public class CommandSearchCompany implements Command{
	
	@Override
	public Context execute(Object details) {
	
		TCompany tCompany = FactorySA.getInstance().createSACompany().searchCompany((int) details);
		
		if(tCompany != null){
			return new Context(Events.SEARCH_COMPANY_OK, tCompany);
		}
		else {
			return new Context(Events.SEARCH_COMPANY_KO, tCompany);
		}
	}
}