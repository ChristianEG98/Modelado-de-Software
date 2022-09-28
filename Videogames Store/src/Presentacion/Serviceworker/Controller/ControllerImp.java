/**
 * 
 */
package _2.Diseño.Presentacion.Serviceworker.Controller;

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Serviceworker.Command.Command;
import _2.Diseño.Presentacion.Serviceworker.Command.FactoryCommand.FactoryCommand;
import _2.Diseño.Presentacion.Serviceworker.Dispatcher.Dispatcher;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class ControllerImp extends Controller {

	@Override
	public void action(Context context) {
		Command command = FactoryCommand.getInstance().generateCommand(context.getEvent());
		Context cont = null;
		
		if(command != null) {
			cont = command.execute(context.getDetails());
			Dispatcher.getInstance().generateView(cont);;
		
		} else {
			Dispatcher.getInstance().generateView(context);
		}
	}
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/

}