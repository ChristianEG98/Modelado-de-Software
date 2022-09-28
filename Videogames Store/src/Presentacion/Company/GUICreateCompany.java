/**
 * 
 */
package _2.Diseño.Presentacion.Company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
public class GUICreateCompany extends GUICompany {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JLabel lblName;
	private JTextField textCif;
	private JLabel lblCif;
	
	public GUICreateCompany() {
		 super();
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
		setTitle("CREATE COMPANY");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblName = new JLabel("Company Name:");
		lblName.setBounds(10, 16, 94, 14);
		contentPane.add(lblName);

		textName = new JTextField();
		textName.setBounds(114, 8, 310, 30);
		contentPane.add(textName);
		textName.setColumns(10);
		
		lblCif = new JLabel("Company Cif:");
		lblCif.setBounds(10, 53, 94, 14);
		contentPane.add(lblCif);

		textCif = new JTextField();
		textCif.setBounds(114, 45, 310, 30);
		contentPane.add(textCif);
		textCif.setColumns(10);

		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
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
						TCompany tCompany = new TCompany(textName.getText(), textCif.getText(), 0, true);
						Controller.getInstance().action(new Context(Events.CREATE_COMPANY, tCompany));
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnOK.setBounds(302, 108, 99, 30);
		contentPane.add(btnOK);
		
		JButton btnCancel = new JButton("Close");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(190, 108, 99, 30);
		contentPane.add(btnCancel);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void clearData() {
		textName.setText("");
		textCif.setText("");
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void update(Context context) {
		switch(context.getEvent()){
			case Events.CREATE_COMPANY_OK:
				JOptionPane.showMessageDialog(null, "Company " + context.getDetails() + " create.");
				this.dispose();
				break;
			case Events.CREATE_COMPANY_KO:
				if((int)context.getDetails() == -3){
					JOptionPane.showMessageDialog(null, "Error to create company");
				}
				else{
					JOptionPane.showMessageDialog(null, "Company exists");
				}
				break;
		}
	}
}