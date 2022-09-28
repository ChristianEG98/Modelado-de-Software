package _2.Diseño.Presentacion.Serviceworker.Command.CommandEmployees;


import _2.Diseño.Negocio.Employees.TEmployees;
import _2.Diseño.Negocio.Factory.FactorySA;

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Command.Command;

public class CommandCreateEmployees implements Command {

	@Override
	public Context execute(Object details) {
		// TODO Auto-generated method stub
		TEmployees tEmployees = (TEmployees) details;

		int id = FactorySA.getInstance().createSAEmployees().createEmployees(tEmployees);
		
		if(id > 0){
			return new Context(Events.CREATE_EMPLOYEES_OK, id);
		}
		else{
			return new Context(Events.CREATE_EMPLOYEES_KO, id);
		}
	}

}
