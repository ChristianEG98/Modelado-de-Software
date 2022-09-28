/**
 * 
 */
package _2.Diseño.Presentacion.Fair;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Negocio.Fair.imp.TAssist;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class GUIAddEmployeesFair extends GUIFair{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFair;
	private JTextField textemployees;

	private JPanel contentPanel;
	
	public GUIAddEmployeesFair(){
		super();
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private void initGUI() {
		// begin-user-code
		// TODO Auto-generated method stub
		setTitle("Add employee");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 260, 275);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblIdemployees = new JLabel("Id Employees:");
		lblIdemployees.setBounds(40, 40, 85, 14);
		contentPanel.add(lblIdemployees);
		
		JLabel lblIdFair = new JLabel("Id Fair:");
		lblIdFair.setBounds(40, 80, 55, 14);
		contentPanel.add(lblIdFair);
		
		textemployees = new JTextField();
		textemployees.setBounds(130, 40, 96, 20);
		contentPanel.add(textemployees);
		textemployees.setColumns(10);
		
		textFair = new JTextField();
		textFair .setBounds(130, 80, 96, 20);
		contentPanel.add(textFair );
		textFair .setColumns(10);
		
		JButton btnCancel = new JButton("Close");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(70, 170, 120,30);
		contentPanel.add(btnCancel);
		
		JButton btnAceptar = new JButton("OK");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int employees = Integer.parseInt(textemployees.getText());
					int Fair = Integer.parseInt(textFair .getText());
					if (employees <= 0 || Fair <= 0)
						JOptionPane.showMessageDialog(new JFrame(), "Id's incorrects, has to be greater than 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					
					TAssist tAssist = new TAssist(Fair, employees, true);

					Controller.getInstance().action(new Context(Events.ADD_EMPLOYEE_FAIR, tAssist));

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Error", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setBounds(70, 130, 120,30);
		contentPanel.add(btnAceptar);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		// end-user-code
	}

	public void update(Context context){
		switch (context.getEvent()) {
		case Events.ADD_EMPLOYEE_FAIR_OK:
			JOptionPane.showMessageDialog(null, "Employee "+" added to the Fair " );
			this.dispose();
			break;
		case Events.ADD_EMPLOYEE_FAIR_KO:
			if((int)context.getDetails() == -1){
				JOptionPane.showMessageDialog(null, "Fair not exists");
			}
			else if((int)context.getDetails()  == -2){
				JOptionPane.showMessageDialog(null, "Employee not exists");
			}
			else if((int)context.getDetails()  == -3){
				JOptionPane.showMessageDialog(null, "Fair not active");
			}
			else if((int)context.getDetails()  == -4){
				JOptionPane.showMessageDialog(null, "Employee not active");
			}
			else if((int)context.getDetails()  == -5){
				JOptionPane.showMessageDialog(null, "Employee already added to that fair");
			}
			else if((int)context.getDetails()  == -6){
				JOptionPane.showMessageDialog(null, "Fair is already full");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error adding employee to that fair");
			}
			break;
		}
	}
	
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void clearData() {
		// begin-user-code
		// TODO Auto-generated method stub
		textFair.setText("");
		textemployees.setText("");
		// end-user-code
	}
}