/**
 * 
 */
package _2.Diseño.Presentacion.Company;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Presentacion.View.GUI;
import _2.Diseño.Negocio.Company.imp.TCompany;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public class GUISearchCompany extends GUICompany {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textIdCompany;
	private JLabel lblIdCompany;
	private JTextField textName;
	private JLabel lblName;
	private JTextField textCif;
	private JLabel lblCif;
	private JTextField textNumEmployees;
	private JLabel lblNumEmployees;
	private JTextField activeType;
	private JTextField nonActiveType;

	public GUISearchCompany(){
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
		setTitle("SEARCH COMPANY");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(8, 8, 8, 8));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		

		
		lblIdCompany = new JLabel("Id company:");
		lblIdCompany.setBounds(60, 26, 90, 14);
		contentPane.add(lblIdCompany);
		
		textIdCompany = new JTextField();
		textIdCompany.setBounds(160, 23, 150, 20);
		contentPane.add(textIdCompany);
		textIdCompany.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 424, 2);
		contentPane.add(separator);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(60, 67, 90, 14);
		contentPane.add(lblName);

		textName = new JTextField();
		textName.setEditable(false);
		textName.setBounds(160, 64, 150, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		lblCif = new JLabel("Cif:");
		lblCif.setBounds(60, 113, 90, 14);
		contentPane.add(lblCif);
		
		textCif = new JTextField();
		textCif.setEditable(false);
		textCif.setBounds(160, 110, 150, 20);
		contentPane.add(textCif);
		textCif.setColumns(10);

		lblNumEmployees = new JLabel("Num Employees:");
		lblNumEmployees.setBounds(60, 160, 110, 14);
		contentPane.add(lblNumEmployees);
		
		textNumEmployees = new JTextField();
		textNumEmployees.setEditable(false);
		textNumEmployees.setBounds(160, 157, 150, 20);
		contentPane.add(textNumEmployees);
		textNumEmployees.setColumns(10);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(60, 200, 90, 14);
		contentPane.add(lblStatus);
		
		activeType = new JTextField();
		activeType.setEditable(false);
		activeType.setBounds(160, 200,  150, 20);
		activeType.setBackground(Color.GREEN);
		contentPane.add(activeType);
		activeType.setColumns(10);
		
		nonActiveType = new JTextField();
		nonActiveType.setEditable(false);
		nonActiveType.setBounds(160, 200,  150, 20);
		nonActiveType.setBackground(Color.RED);
		contentPane.add(nonActiveType);
		nonActiveType.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int id;
					id = Integer.parseInt(textIdCompany.getText());
					if (id <= 0) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Error,the id has to be greater than 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						Controller.getInstance().action(new Context(Events.SEARCH_COMPANY, id));
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setBounds(330, 22, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(330, 237, 89, 23);
		contentPane.add(btnClose);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void clearData() {
		textIdCompany.setText("");
		textName.setText("");
		textCif.setText("");
		textNumEmployees.setText("");
		activeType.setVisible(false);
		nonActiveType.setVisible(false);
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void update(Context context) {
		switch (context.getEvent()) {
		case Events.SEARCH_COMPANY_OK:
			TCompany company = (TCompany)context.getDetails();
			
			textName.setText(company.getName());
			textCif.setText(company.getCif()+"");
			textNumEmployees.setText(company.getNumEmployees()+"");
			
			if(company.getActive()){
				activeType.setVisible(true);
				nonActiveType.setVisible(false);
			}
			else{
				activeType.setVisible(false);
				nonActiveType.setVisible(true);
			}
			break;
		case Events.SEARCH_COMPANY_KO:
			JOptionPane.showMessageDialog(null, "Error searching the company");
			break;
		}
	}
}