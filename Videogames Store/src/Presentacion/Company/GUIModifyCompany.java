/**
 * 
 */
package _2.Diseño.Presentacion.Company;


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
public class GUIModifyCompany extends GUICompany {
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
	private JButton btnModify;
	private int idCompany;
	private TCompany tCompany;
	
	
	/**
	 * 
	 */
	public GUIModifyCompany(){
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
		setTitle("MODIFY COMPANY");
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
		lblNumEmployees.setBounds(60, 160, 90, 14);
		contentPane.add(lblNumEmployees);
		
		textNumEmployees = new JTextField();
		textNumEmployees.setEditable(false);
		textNumEmployees.setBounds(160, 157, 150, 20);
		contentPane.add(textNumEmployees);
		textNumEmployees.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					idCompany = Integer.parseInt(textIdCompany.getText());
					if (idCompany <= 0) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Error,the id has to be greater than 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						Controller.getInstance().action(new Context(Events.SEARCH_MODIFY_COMPANY, idCompany));
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setBounds(330, 22, 89, 23);
		contentPane.add(btnSearch);
		
		btnModify = new JButton("Modify");
		btnModify.setBounds(200, 237, 89, 23);
		btnModify.setEnabled(false);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textName.getText().equals("") || textCif.getText().equals("")) {
						JOptionPane.showMessageDialog(new JFrame(), "You must fill all the fields", "Error",
								JOptionPane.ERROR_MESSAGE);
					} 
					else if(textCif.getText().length() != 9 || Character.isLetter(textCif.getText().charAt(0)) == false) {
	                	JOptionPane.showMessageDialog(new JFrame(), "Incorrect cif length or format. Ej: A12345678");
	                }  
					else {
						TCompany tCompany = new TCompany(idCompany,textName.getText(), textCif.getText(), Integer.parseInt(textNumEmployees.getText()), true);
						Controller.getInstance().action(new Context(Events.MODIFY_COMPANY, tCompany));
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(btnModify);
		

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
		
		textName.setEditable(false);
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void update(Context context) {
		switch(context.getEvent()){
			case Events.SEARCH_MODIFY_COMPANY_OK:
				tCompany = (TCompany) context.getDetails();
				textName.setText(tCompany.getName());
				textCif.setText(tCompany.getCif());
				textNumEmployees.setText(tCompany.getNumEmployees()+"");
				
				textName.setEditable(true);
				textCif.setEditable(true);
				btnModify.setEnabled(true);
				
				break;
			case Events.SEARCH_MODIFY_COMPANY_KO:
				JOptionPane.showMessageDialog(null, "Error searching the company");
				break;
			case Events.MODIFY_COMPANY_OK:
				JOptionPane.showMessageDialog(null, "Company " + context.getDetails() + " successfully modified.");
				this.dispose();
				break;
			case Events.MODIFY_COMPANY_KO:
				if((int)context.getDetails() == -5){
					JOptionPane.showMessageDialog(null, "The CIF: "+ textCif.getText() + " already exists");
				}
				else if((int)context.getDetails() == -2){
					JOptionPane.showMessageDialog(null, "The company is not active");
				}
				else if((int)context.getDetails() == -3){
					JOptionPane.showMessageDialog(null, "The company does not exist");
				}
				else{
					JOptionPane.showMessageDialog(null, "Company not found");
				}
				
				break;
			}
	}
}