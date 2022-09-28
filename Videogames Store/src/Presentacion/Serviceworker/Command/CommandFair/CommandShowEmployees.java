package _2.Dise�o.Presentacion.Serviceworker.Command.CommandFair;

import java.util.List;

import _2.Dise�o.Negocio.Factory.FactorySA;
import _2.Dise�o.Negocio.Fair.imp.TAssist;
import _2.Dise�o.Presentacion.Context;
import _2.Dise�o.Presentacion.Events;
import _2.Dise�o.Presentacion.Serviceworker.Command.Command;

public class CommandShowEmployees implements Command {

	@Override
	public Context execute(Object details) {
		// TODO Auto-generated method stub
List<TAssist> companies = FactorySA.getInstance().createSAFair().showEmployeesFair((int)details);
		
		if(companies != null){
			return new Context(Events.SHOW_EMPLOYEES_FAIR_OK, companies);
		}
		else {
			return new Context(Events.SHOW_EMPLOYEES_FAIR_KO, companies);
		}
	}
	

}
