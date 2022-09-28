package _2.Diseño.Presentacion.Serviceworker.Command.CommandFair;

import _2.Diseño.Negocio.Factory.FactorySA;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Command.Command;

public class CommandDeleteFair implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#ejecutar(Object dato)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Override
	public Context execute(Object dato) {

		int id = FactorySA.getInstance().createSAFair().deleteFair((int)dato);
		
		if(id > 0){
			return new Context(Events.DELETE_FAIR_OK, id);
		}
		else{
			return new Context(Events.DELETE_FAIR_KO, id);
		}
	}
}