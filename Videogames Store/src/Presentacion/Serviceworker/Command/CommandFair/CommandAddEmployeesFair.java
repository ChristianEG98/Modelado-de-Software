package _2.Dise�o.Presentacion.Serviceworker.Command.CommandFair;

import _2.Dise�o.Negocio.Factory.FactorySA;
import _2.Dise�o.Negocio.Fair.imp.TAssist;
import _2.Dise�o.Presentacion.Context;
import _2.Dise�o.Presentacion.Events;
import _2.Dise�o.Presentacion.Serviceworker.Command.Command;

public class CommandAddEmployeesFair implements Command{
	public Context execute(Object dato) {
		TAssist tAssist = (TAssist) dato;;
		int r = FactorySA.getInstance().createSAFair().addEmployeesFair(tAssist);
	
		if(r > 0){
			return new Context(Events.ADD_EMPLOYEE_FAIR_OK, r);
		}
		else{
		return new Context(Events.ADD_EMPLOYEE_FAIR_KO, r);
		}
	}
}
