package _2.Diseño.Presentacion.Employees;

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

public class GUIEmployeesImp extends GUIEmployees{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GUICreateEmployees gUICreateEmployees;
	private GUIDeleteEmployees gUIDeleteEmployees;
	private GUIModifyEmployees gUIModifyEmployees;
	private GUIListEmployees gUIListEmployees;
	private GUISearchEmployees gUISearchEmployees;
	private GUIPayRollEmployees gUIPayRollEmployees;
	private GUISearchByDniEmployees gUISearchByDniEmployees;
	
	private JPanel contentPanel;
	
	 public GUIEmployeesImp() {
		// TODO Auto-generated constructor stub
		 gUICreateEmployees= new GUICreateEmployees();
		 gUIDeleteEmployees = new GUIDeleteEmployees();
		 gUIModifyEmployees = new GUIModifyEmployees();
		 gUIListEmployees = new GUIListEmployees();
		 gUISearchEmployees = new GUISearchEmployees();
		 gUIPayRollEmployees = new GUIPayRollEmployees();
		 gUISearchByDniEmployees= new GUISearchByDniEmployees();
		 setResizable(false);
			initGUI();
			this.setLocationRelativeTo(null);
	}

	 private void initGUI()
	 {
		 this.setTitle("Employees");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 450, 325);
			contentPanel = new JPanel();
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.setBackground(new Color(192, 217, 252));
			setContentPane(contentPanel);
			contentPanel.setLayout(null);
		 
			JButton btnCreateEmpoloyees = new JButton("Create Employees");
			btnCreateEmpoloyees.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 gUICreateEmployees.clearData();
					 gUICreateEmployees.setVisible(true);
				}
			});
			btnCreateEmpoloyees.setBounds(10, 11, 200, 45);
			contentPanel.add(btnCreateEmpoloyees);
			
			JButton btnDeleteEmployees = new JButton("Delete Employees");
			btnDeleteEmployees.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gUIDeleteEmployees.clearData();
					gUIDeleteEmployees.setVisible(true);
				}
			});
			btnDeleteEmployees.setBounds(224, 11, 200, 45);
			contentPanel.add(btnDeleteEmployees);
			
			JButton btnModifyEmployees = new JButton("Modify Employees");
			btnModifyEmployees.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gUIModifyEmployees.clearData();
					gUIModifyEmployees.setVisible(true);
				}
			});
			btnModifyEmployees.setBounds(10, 67, 200, 45);
			contentPanel.add(btnModifyEmployees);
			
			JButton btnSearchEmployees = new JButton("Search Employees");
			btnSearchEmployees.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gUISearchEmployees.clearData();
					gUISearchEmployees.setVisible(true);
				}
			});
			btnSearchEmployees.setBounds(224, 67, 200, 45);
			contentPanel.add(btnSearchEmployees);
			
			JButton btnListEmployees = new JButton("List Employees");
			btnListEmployees.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gUIListEmployees.clearData();
					gUIListEmployees.setVisible(true);
					Controller.getInstance().action(new Context(Events.LIST_EMPLOYEESS, null));
					gUIListEmployees.toFront();
				}
			});
			btnListEmployees.setBounds(10, 123, 200, 45);
			contentPanel.add(btnListEmployees);
			

			
			JButton btnSearchByDniEmployees = new JButton("Search By Dni Employees");
			btnSearchByDniEmployees.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gUISearchByDniEmployees.clearData();
					gUISearchByDniEmployees.setVisible(true);
				}
			});
		
			btnSearchByDniEmployees.setBounds(224, 123, 200, 45);
			contentPanel.add(btnSearchByDniEmployees);
			
			JButton btnPayRollEmployees = new JButton("PayRoll Employee");
			btnPayRollEmployees.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gUIPayRollEmployees.clearData();
					gUIPayRollEmployees.setVisible(true);
				}
			});
			btnPayRollEmployees.setBounds(60, 179, 315, 45);
			contentPanel.add(btnPayRollEmployees);
			
			
			
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
	 
	@Override
	public void update(Context context) {
		// TODO Auto-generated method stub
		switch(context.getEvent()){
		case Events.CREATE_EMPLOYEES_OK:
			gUICreateEmployees.update(context);
			break;
		case Events.CREATE_EMPLOYEES_KO:
			gUICreateEmployees.update(context);
			break;
		case Events.DELETE_EMPLOYEES_OK:
			gUIDeleteEmployees.update(context);
			break;
		case Events.DELETE_EMPLOYEES_KO:
			gUIDeleteEmployees.update(context);
			break;
		case Events.SEARCH_EMPLOYEES_OK:
			gUISearchEmployees.update(context);
			break;
		case Events.SEARCH_EMPLOYEES_KO:
			gUISearchEmployees.update(context);
			break;
		case Events.SEARCH_MODIFY_EMPLOYEES_OK:
		case Events.SEARCH_MODIFY_EMPLOYEES_KO:			
		case Events.MODIFY_EMPLOYEES_OK:
			gUIModifyEmployees.update(context);
			break;
		case Events.MODIFY_EMPLOYEES_KO:
			gUIModifyEmployees.update(context);
			break;
		case Events.LIST_EMPLOYEESS_OK:
			gUIListEmployees.update(context);
			break;
		case Events.LIST_EMPLOYEESS_KO:
			gUIListEmployees.update(context);
			break;
		case Events.PAYROLL_EMPLOYEE_OK:
			gUIPayRollEmployees.update(context);
			break;
		case Events.PAYROLL_EMPLOYEE_KO:
			gUIPayRollEmployees.update(context);
			break;
		case Events.SEARCH_BY_DNI_EMPLOYEES_OK:
			gUISearchByDniEmployees.update(context);
			break;
		case Events.SEARCH_BY_DNI_EMPLOYEES_KO:
			gUISearchByDniEmployees.update(context);
			break;
		
		}
	}

}
