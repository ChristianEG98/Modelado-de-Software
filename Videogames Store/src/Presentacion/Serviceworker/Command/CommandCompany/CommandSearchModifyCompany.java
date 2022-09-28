package _2.Diseño.Presentacion.Serviceworker.Command.CommandCompany;

import _2.Diseño.Negocio.Company.imp.TCompany;
import _2.Diseño.Negocio.Factory.FactorySA;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Command.Command;

public class CommandSearchModifyCompany implements Command{
	
	public Context execute(Object details) {
		TCompany tCompany = null;
		tCompany = FactorySA.getInstance().createSACompany().searchCompany((int) details);
	
		if(tCompany != null){
			return new Context(Events.SEARCH_MODIFY_COMPANY_OK, tCompany);
		}
		else {
			return new Context(Events.SEARCH_MODIFY_COMPANY_KO, tCompany);
		}
	}

}
