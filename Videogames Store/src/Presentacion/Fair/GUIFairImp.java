/**
 * 
 */
package _2.Diseño.Presentacion.Fair;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class GUIFairImp extends GUIFair {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private GUIShowEmployees gUIShowEmployees;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private GUISearchFair gUISearchFair;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private GUIModifyFair gUIModifyFair;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private GUIListFairs gUIListFairs;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private GUIDeleteFair gUIDeleteFair;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private GUIDeleteEmployeesFair gUIDeleteEmployee;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private GUICreateFair gUICreateFair;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private GUIAddEmployeesFair gUIAddEmployee;

	private JPanel contentPanel;
	
	public GUIFairImp(){
		gUICreateFair = new GUICreateFair();
		gUIDeleteFair = new GUIDeleteFair();
		gUISearchFair= new GUISearchFair();
		gUIModifyFair = new GUIModifyFair();
		gUIListFairs = new GUIListFairs();
		gUIAddEmployee = new GUIAddEmployeesFair();
		gUIDeleteEmployee = new GUIDeleteEmployeesFair();
		gUIShowEmployees = new GUIShowEmployees();
		setResizable(false);
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
		this.setTitle("FAIRS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(192, 217, 252));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JButton btnAltaEvento = new JButton("Create Fair");
		btnAltaEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUICreateFair.clearData();
				gUICreateFair.setVisible(true);
			}
		});
		btnAltaEvento.setBounds(10, 11, 200, 45);
		contentPanel.add(btnAltaEvento);

		JButton btnBajaEvento = new JButton("Delete Fair");
		btnBajaEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIDeleteFair.clearData();
				gUIDeleteFair.setVisible(true);
			}
		});
		btnBajaEvento.setBounds(224, 11, 200, 45);
		contentPanel.add(btnBajaEvento);

		JButton btnModificarEvento = new JButton("Modify Fair");
		btnModificarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIModifyFair.clearData();
				gUIModifyFair.setVisible(true);
			}
		});
		btnModificarEvento.setBounds(10, 67, 200, 45);
		contentPanel.add(btnModificarEvento);

		JButton btnBuscarEvento = new JButton("Search Fair");
		btnBuscarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUISearchFair.clearData();
				gUISearchFair.setVisible(true);
			}
		});
		btnBuscarEvento.setBounds(224, 67, 200, 45);
		contentPanel.add(btnBuscarEvento);

		JButton btnListarAnadirEmployee = new JButton("Add Employee");
		btnListarAnadirEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIAddEmployee.clearData();
				gUIAddEmployee.setVisible(true);
			}
		});
		btnListarAnadirEmployee.setBounds(10, 123, 200, 45);
		contentPanel.add(btnListarAnadirEmployee);

		JButton btnBuscarEliminarEmployee = new JButton("Delete Employee");
		btnBuscarEliminarEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIDeleteEmployee.clearData();
				gUIDeleteEmployee.setVisible(true);
			}
		});
		btnBuscarEliminarEmployee.setBounds(224, 123, 200, 45);
		contentPanel.add(btnBuscarEliminarEmployee);

		JButton btnListarEventos = new JButton("List Fairs");
		btnListarEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIListFairs.clearData();
				gUIListFairs.setVisible(true);
				Controller.getInstance().action(new Context(Events.LIST_FAIRS, null));
				gUIListFairs.toFront();
			}
		});
		btnListarEventos.setBounds(10, 179, 200, 45);
		contentPanel.add(btnListarEventos);
		
		JButton btnMostrarEmployeesFAIR = new JButton("Employees in Fair");
		btnMostrarEmployeesFAIR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIShowEmployees.clearData();
				gUIShowEmployees.setVisible(true);
			}
		});
		btnMostrarEmployeesFAIR.setBounds(224, 179, 200, 45);
		contentPanel.add(btnMostrarEmployeesFAIR);
		// end-user-code
		
		JButton btMainMenu = new JButton("MAIN MENU");
		btMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int option = JOptionPane.showOptionDialog(new JFrame(),
							"Are you sure to return to the main menu?", "Quit",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.YES_NO_OPTION, null, null, null);
					if (option == JOptionPane.YES_OPTION){
				dispose();
					}
			}
		});
		btMainMenu.setBounds(115, 235, 200, 45);
		contentPanel.add(btMainMenu);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	
	public void update(Context context){
		switch(context.getEvent()){
		case Events.CREATE_FAIR_OK:
			gUICreateFair.update(context);
			break;
		case Events.CREATE_FAIR_KO:
			gUICreateFair.update(context);
			break;
		case Events.DELETE_FAIR_OK:
			gUIDeleteFair.update(context);
			break;
		case Events.DELETE_FAIR_KO:
			gUIDeleteFair.update(context);
			break;
		case Events.SEARCH_FAIR_OK:
			gUISearchFair.update(context);
			break;
		case Events.SEARCH_FAIR_KO:
			gUISearchFair.update(context);
			break;
		case Events.SEARCH_MODIFY_FAIR_OK:
		case Events.SEARCH_MODIFY_FAIR_KO:
			
		case Events.MODIFY_FAIR_OK:
			gUIModifyFair.update(context);
			break;
		case Events.MODIFY_FAIR_KO:
			gUIModifyFair.update(context);
			break;
		case Events.LIST_FAIRS_OK:
			gUIListFairs.update(context);
			break;
		case Events.LIST_FAIRS_KO:
			gUIListFairs.update(context);
			break;
		case Events.ADD_EMPLOYEE_FAIR_OK:
			gUIAddEmployee.update(context);
			break;
		case Events.ADD_EMPLOYEE_FAIR_KO:
			gUIAddEmployee.update(context);
			break;
		case Events.DELETE_EMPLOYEE_FAIR_OK:
			gUIDeleteEmployee.update(context);
			break;
		case Events.DELETE_EMPLOYEE_FAIR_KO:
			gUIDeleteEmployee.update(context);
			break;
		case Events.SHOW_EMPLOYEES_FAIR_OK:
			gUIShowEmployees.update(context);
			break;
		case Events.SHOW_EMPLOYEES_FAIR_KO:
			gUIShowEmployees.update(context);
			break;
		}
	}
}
