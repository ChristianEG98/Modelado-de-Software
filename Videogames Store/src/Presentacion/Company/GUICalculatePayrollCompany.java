/**
 * 
 */
package _2.Diseño.Presentacion.Company;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
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
public class GUICalculatePayrollCompany extends JFrame implements GUI {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	JLabel calculoNominas_label;
	JTextField textIdCompany;
	JTextPane text_idCom;
	TCompany idCompany;
	public GUICalculatePayrollCompany()
	{
		super();
		setResizable(false);
		initGUI();
		this.setLocationRelativeTo(null);
	}
	public void clearData() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private void initGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblClculoDeLa = new JLabel("Calculate company payroll");
		lblClculoDeLa.setBounds(23, 24, 234, 32);
		contentPane.add(lblClculoDeLa);

		calculoNominas_label = new JLabel("");
		calculoNominas_label.setFont(new Font("Tahoma", Font.ITALIC, 12));
		calculoNominas_label.setBounds(33, 70, 134, 32);
		contentPane.add(calculoNominas_label);

		JLabel label = new JLabel("€");
		label.setBounds(201, 78, 56, 16);
		contentPane.add(label);
		
		
		
			
			text_idCom = new JTextPane();
			text_idCom.setBounds(200,28, 50, 23);
			contentPane.add(text_idCom);
			JButton btnPayRollCompany = new JButton("PayRoll Company");
			btnPayRollCompany.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (!text_idCom.getText().equals("")) {
						try {
							int id = Integer.parseInt(text_idCom.getText());
							
							
							Controller.getInstance().action(new Context(Events.CALCULATE_PAYROLL_COMPANY, id));

						} catch (Exception ex) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Error en la introducción del id. Tipo error " + ex.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Introduzca un Id en la caja de texto", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnPayRollCompany.setBounds(260, 28, 150, 23);
			contentPane.add(btnPayRollCompany);
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void update(Context context) {
		float suma = (float)context.getDetails();
		switch (context.getEvent()) {
		case Events.CALCULATE_PAYROLL_COMPANY_OK:
			this.calculoNominas_label.setText(""+suma);
			break;
		case Events.CALCULATE_PAYROLL_COMPANY_KO:
			if((float)context.getDetails() == -3){
				JOptionPane.showMessageDialog(null, "la empresa no existe");
			}
			else if((float)context.getDetails()== -4){
				JOptionPane.showMessageDialog(null, "la empresa no está activo");
			}
			else{
			JOptionPane.showMessageDialog(new JFrame(), context.getDetails() ,"Error", JOptionPane.ERROR_MESSAGE);
			}
			this.dispose();
			break;
		}

	
	}
}