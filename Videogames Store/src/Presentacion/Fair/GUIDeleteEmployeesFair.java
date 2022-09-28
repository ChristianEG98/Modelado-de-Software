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
public class GUIDeleteEmployeesFair extends GUIFair{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFair;
	private JTextField textEmployees;

	private JPanel contentPanel;
	
	public GUIDeleteEmployeesFair(){
		super();
		initGUI();
		this.setLocationRelativeTo(null);
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
		textEmployees.setText("");
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private void initGUI() {
		// begin-user-code
		// TODO Auto-generated method stub
		setTitle("Delete Employees");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 260, 275);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblIdEmployees = new JLabel("Id Employees:");
		lblIdEmployees.setBounds(40, 40, 85, 14);
		contentPanel.add(lblIdEmployees);
		
		JLabel lblIdFair = new JLabel("Id Fair:");
		lblIdFair.setBounds(40, 80, 55, 14);
		contentPanel.add(lblIdFair);
		
		textEmployees = new JTextField();
		textEmployees.setBounds(130, 40, 96, 20);
		contentPanel.add(textEmployees);
		textEmployees.setColumns(10);
		
		textFair = new JTextField();
		textFair.setBounds(130, 80, 96, 20);
		contentPanel.add(textFair);
		textFair.setColumns(10);
		
		JButton btnCancel = new JButton("Close");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(70, 170, 120,30);
		contentPanel.add(btnCancel);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int Employees = Integer.parseInt(textEmployees.getText());
					int Fair = Integer.parseInt(textFair.getText());
					if (Employees <= 0 || Fair <= 0)
						JOptionPane.showMessageDialog(new JFrame(), "Id's incorrects, have to be greater than 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					
					TAssist tAssist = new TAssist(Fair, Employees, true);
					int option = JOptionPane.showOptionDialog(new JFrame(),
							"Are you sure you want to remove this employee from the fair?", "Quit",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.YES_NO_OPTION, null, null, null);
					if (option == JOptionPane.YES_OPTION){

					Controller.getInstance().action(new Context(Events.DELETE_EMPLOYEE_FAIR, tAssist));
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnOk.setBounds(70, 130, 120,30);
		contentPanel.add(btnOk);
		// end-user-code
	}
	
	public void update(Context context){
		switch (context.getEvent()) {
		case Events.DELETE_EMPLOYEE_FAIR_OK:
			JOptionPane.showMessageDialog(null, "Employee "+" removed from the Fair " );
			this.dispose();
			break;
		case Events.DELETE_EMPLOYEE_FAIR_KO:
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
				JOptionPane.showMessageDialog(null, "Employee already removed from that fair");
			}
			else if((int)context.getDetails()  == -6){
				JOptionPane.showMessageDialog(null, "Employee not assists that fair");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error removing employee to that fair");
			}
			break;
		}
	}
	
}