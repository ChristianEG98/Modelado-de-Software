/**
 * 
 */
package _2.Diseño.Presentacion.Ticket;

import _2.Diseño.Presentacion.View.GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUICreateTicket extends JFrame implements GUI {
	
	private static final long serialVersionUID = 1L; 
	/** 											
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JTextField textField_IdCliente;
	private JPanel contentPane;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void initGUI() {
		setTitle("CREATE TICKET");
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIntroducirElId = new JLabel("Client id:");
		lblIntroducirElId.setBounds(65, 20, 126, 29);

		contentPane.add(lblIntroducirElId);

		textField_IdCliente = new JTextField();
		textField_IdCliente.setBounds(120, 25, 86, 20);
		contentPane.add(textField_IdCliente);
		textField_IdCliente.setColumns(10);

		JButton btnAceptar = new JButton("Create");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!textField_IdCliente.getText().equals("")) {

					try {
						int idCliente = Integer.parseInt(textField_IdCliente.getText());
						Controller.getInstance().action(new Context(Events.CREATE_TICKET, idCliente)); 
						dispose();

					} catch (Exception ex) {

						JOptionPane.showMessageDialog(new JFrame(), "Error entering the idClient", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Enter an idClient", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAceptar.setBounds(90, 60, 107, 29);
		contentPane.add(btnAceptar);
		
		JButton btnExit = new JButton("Close");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(90, 100, 107, 29);
		contentPane.add(btnExit);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public GUICreateTicket() {
		super();
		setResizable(true);
		initGUI();
		this.setLocationRelativeTo(null);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void refresh() {
		this.textField_IdCliente.setText("");
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void update(Context context) {
		switch(context.getEvent()){
		case Events.CREATE_TICKET_OK:
			JOptionPane.showMessageDialog(null, "Ticket " + context.getDetails() + " create.");
			this.dispose();
			break;
		case Events.CREATE_TICKET_KO:
			if((int)context.getDetails() == -1){
				JOptionPane.showMessageDialog(null, "The ticket already exists");
			}
			else if((int)context.getDetails() == -2){
				JOptionPane.showMessageDialog(null, "Reactivation error");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error");
			}
			
			break;
		}
	}

}