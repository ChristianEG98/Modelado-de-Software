package _2.Dise�o.Presentacion.Serviceworker.Command.CommandEmployees;

import _2.Dise�o.Negocio.Factory.FactorySA;
import _2.Dise�o.Presentacion.Context;
import _2.Dise�o.Presentacion.Events;
import _2.Dise�o.Presentacion.Serviceworker.Command.Command;

public class CommandDeleteEmployees implements Command{

	@Override
	public Context execute(Object details) {
		// TODO Auto-generated method stub
int id = FactorySA.getInstance().createSAEmployees().deleteEmployees((int) details);
		
		if(id > 0) return new Context(Events.DELETE_EMPLOYEES_OK, id);
		else return new Context(Events.DELETE_EMPLOYEES_KO, id);
	}

}
