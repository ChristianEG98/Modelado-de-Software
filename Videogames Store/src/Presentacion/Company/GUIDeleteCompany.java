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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Presentacion.View.GUI;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public class GUIDeleteCompany extends GUICompany {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIdCompany;
	private JLabel lblIdCompany;

	public GUIDeleteCompany(){
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
		setTitle("DELETE COMPANY");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 270, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnRemove = new JButton("Delete");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int idComapny;
					
					idComapny = Integer.parseInt(textIdCompany.getText());
					
					if(idComapny <= 0){
						JOptionPane.showMessageDialog(new JFrame(), "Error, the id has to be greater than 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else{
						int option = JOptionPane.showOptionDialog(new JFrame(),
								"Are you sure to delete this company?", "Quit",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.YES_NO_OPTION, null, null, null);
						if (option == JOptionPane.YES_OPTION){
						Controller.getInstance().action(new Context(Events.DELETE_COMPANY, idComapny));
						}
					}
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRemove.setBounds(70, 80,120,30);
		contentPane.add(btnRemove);
		
		JLabel lblId = new JLabel("ID Company:");
		lblId.setBounds(40, 50, 70, 14);
		contentPane.add(lblId);
		
		textIdCompany = new JTextField();
		textIdCompany.setBounds(120, 48, 96, 20);
		contentPane.add(textIdCompany);
		textIdCompany.setColumns(10);
		
		JButton btnCancel = new JButton("Close");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(70, 120, 120,30);
		contentPane.add(btnCancel);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void clearData() {
		textIdCompany.setText("");
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Override
	public void update(Context context) {
		switch(context.getEvent()){
			case Events.DELETE_COMPANY_OK:
				JOptionPane.showMessageDialog(null, "Company " + context.getDetails() + " deleted.");
				this.dispose();
				break;
				
			case Events.DELETE_COMPANY_KO:
				if((int)context.getDetails() == -3){
					JOptionPane.showMessageDialog(null, "Company does not exist");
				}
				else if((int)context.getDetails() == -4){
					JOptionPane.showMessageDialog(null, "Company has already been deleted");
				}
				else if((int)context.getDetails() == -5){
					JOptionPane.showMessageDialog(null, "Company do you still have an employee");
				}
				else{
					JOptionPane.showMessageDialog(null, "Error deleting Company");
				}
				break;
			}
	}
}