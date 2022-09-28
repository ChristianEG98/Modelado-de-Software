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
public class CommandModifyCompany implements Command{
	
	@Override
	public Context execute(Object details) {
		TCompany tCompany = (TCompany) details;
	
		int idCompany = FactorySA.getInstance().createSACompany().modifyCompany(tCompany);
		
		if(idCompany > 0){
			return new Context(Events.MODIFY_COMPANY_OK, idCompany);
		}
		else {
			return new Context(Events.MODIFY_COMPANY_KO, idCompany);
		}
	}
}