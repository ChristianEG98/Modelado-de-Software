/**
 * 
 */
package _2.Diseño.Presentacion.Serviceworker.Command.CommandCompany;

import java.util.List;

import _2.Diseño.Negocio.Company.imp.TCompany;
import _2.Diseño.Negocio.Factory.FactorySA;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Command.Command;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class CommandListCompanies implements Command{
	
	@Override
	public Context execute(Object details) {
	
		List<TCompany> companies = FactorySA.getInstance().createSACompany().listCompanies();
		
		if(companies != null){
			return new Context(Events.LIST_COMPANIES_OK, companies);
		}
		else {
			return new Context(Events.LIST_COMPANIES_KO, companies);
		}
	}
}