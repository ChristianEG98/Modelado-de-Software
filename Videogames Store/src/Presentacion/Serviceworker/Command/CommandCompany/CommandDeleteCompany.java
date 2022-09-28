/**
 * 
 */
package _2.Diseño.Presentacion.Serviceworker.Command.CommandCompany;

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
public class CommandDeleteCompany implements Command{
	
	@Override
	public Context execute(Object details) {
		int idCompany = FactorySA.getInstance().createSACompany().deleteCompany((int) details);
		
		if(idCompany > 0){
			return new Context(Events.DELETE_COMPANY_OK, idCompany);
		}
		else {
			return new Context(Events.DELETE_COMPANY_KO, idCompany);
		}
	}
}