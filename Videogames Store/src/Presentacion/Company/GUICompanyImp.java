/**
 * 
 */
package _2.Diseño.Presentacion.Company;

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
public class GUICompanyImp extends GUICompany {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private GUICreateCompany GUICreateCompany;
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private GUIDeleteCompany GUIDeleteCompany;
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private GUISearchCompany GUISearchCompany;
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private GUIListCompanies GUIListCompanies;
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private GUIModifyCompany GUIModifyCompany;
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private GUICalculatePayrollCompany GUICalculatePayrollCompany;
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public GUICompanyImp() {

		
		this.GUICreateCompany = new GUICreateCompany();
		this.GUIDeleteCompany = new GUIDeleteCompany();
		this.GUISearchCompany = new GUISearchCompany();
		this.GUIListCompanies = new GUIListCompanies();
		this.GUIModifyCompany = new GUIModifyCompany();
		this.GUICalculatePayrollCompany = new GUICalculatePayrollCompany();
		setResizable(false);

		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * 	
	 */
	private void initGUI() {
		this.setTitle("Company");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(192, 217, 252));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	 
		JButton btnCreateCompany = new JButton("Create Company");
		btnCreateCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUICreateCompany.clearData();
				GUICreateCompany.setVisible(true);
			}
		});
		btnCreateCompany.setBounds(10, 11, 200, 45);
		contentPane.add(btnCreateCompany);
		
		JButton btnDeleteCompany = new JButton("Delete Company");
		btnDeleteCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIDeleteCompany.clearData();
				GUIDeleteCompany.setVisible(true);
			}
		});
		btnDeleteCompany.setBounds(224, 11, 200, 45);
		contentPane.add(btnDeleteCompany);
		
		JButton btnModifyCompany = new JButton("Modify Company");
		btnModifyCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIModifyCompany.clearData();
				GUIModifyCompany.setVisible(true);
			}
		});
		btnModifyCompany.setBounds(10, 67, 200, 45);
		contentPane.add(btnModifyCompany);
		
		JButton btnSearchCompany = new JButton("Search Company");
		btnSearchCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUISearchCompany.clearData();
				GUISearchCompany.setVisible(true);
			}
		});
		btnSearchCompany.setBounds(224, 67, 200, 45);
		contentPane.add(btnSearchCompany);
		
		JButton btnListCompany = new JButton("List Companies");
		btnListCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIListCompanies.clearData();
				GUIListCompanies.setVisible(true);
				Controller.getInstance().action(new Context(Events.LIST_COMPANIES, null));
				GUIListCompanies.toFront();
			}
		});
		btnListCompany.setBounds(10, 123, 200, 45);
		contentPane.add(btnListCompany);
		
		JButton btnPayRollCompany = new JButton("PayRoll Company");
		btnPayRollCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUICalculatePayrollCompany.clearData();
				GUICalculatePayrollCompany.setVisible(true);
			}
		});
		btnPayRollCompany.setBounds(224, 123, 200, 45);
		contentPane.add(btnPayRollCompany);
		
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
		btMainMenu.setBounds(115, 179, 200, 45);
		contentPane.add(btMainMenu);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}




	@Override
	public void update(Context context) {
		switch (context.getEvent()) {
		case Events.CREATE_COMPANY_OK:
			GUICreateCompany.update(context);
			break;
		case Events.CREATE_COMPANY_KO:
			GUICreateCompany.update(context);
			break;
		case Events.DELETE_COMPANY_OK:
			GUIDeleteCompany.update(context);
			break;
		case Events.DELETE_COMPANY_KO:
			GUIDeleteCompany.update(context);
			break;

		case Events.SEARCH_COMPANY_OK:
			GUISearchCompany.update(context);
			break;
		case Events.SEARCH_COMPANY_KO:
			GUISearchCompany.update(context);
			break;
		case Events.LIST_COMPANIES_OK:
		case Events.LIST_COMPANIES_KO:
			GUIListCompanies.update(context);
			break;
		case Events.SEARCH_MODIFY_COMPANY_OK:
		case Events.SEARCH_MODIFY_COMPANY_KO:
		case Events.MODIFY_COMPANY_OK:
		case Events.MODIFY_COMPANY_KO:
			GUIModifyCompany.update(context);
			break;
		
		case Events.CALCULATE_PAYROLL_COMPANY_OK:
			GUICalculatePayrollCompany.update(context);

			break;
		case Events.CALCULATE_PAYROLL_COMPANY_KO:
			GUICalculatePayrollCompany.update(context);
			break;
		}		
	}
	

}