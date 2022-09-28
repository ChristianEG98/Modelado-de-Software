package _2.Diseño.Presentacion;

import javax.swing.SwingUtilities;

import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

public class Main {	
	public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Controller.getInstance().action(new Context(Events.GUI_PRINCIPAL,null));
			}
		});
	}
}
