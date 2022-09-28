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

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class GUIDeleteFair extends GUIFair{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;


	public GUIDeleteFair(){
		super();
		contentPane = new JPanel();
		initGUI();
		this.setLocationRelativeTo(null);
	}
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private void initGUI() {
		setTitle("DELETE FAIR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 250, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnRemove = new JButton("Delete");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int idFair;
					
					idFair = Integer.parseInt(textField.getText());
					
					if(idFair <= 0){
						JOptionPane.showMessageDialog(new JFrame(), "Error, the id has to be greater than 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else{
						int option = JOptionPane.showOptionDialog(new JFrame(),
								"Are you sure to delete this fair?", "Quit",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.YES_NO_OPTION, null, null, null);
						if (option == JOptionPane.YES_OPTION){
						Controller.getInstance().action(new Context(Events.DELETE_FAIR, idFair));
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
		
		JLabel lblId = new JLabel("ID Fair:");
		lblId.setBounds(40, 50, 55, 14);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(90, 48, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
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

	public void update(Context context){
		switch(context.getEvent()){
		case Events.DELETE_FAIR_OK:
			JOptionPane.showMessageDialog(null, "Fair " + context.getDetails() + " deleted.");
			this.dispose();
			break;
			
		case Events.DELETE_FAIR_KO:
			if((int)context.getDetails() == -1){
				JOptionPane.showMessageDialog(null, "The Fair does not exist");
			}
			else if((int)context.getDetails() == -2){
				JOptionPane.showMessageDialog(null, "The Fair has already been eliminated");
			}
			else if((int)context.getDetails() == -3){
				JOptionPane.showMessageDialog(null, "The Fair still has some employee");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error deleting Fair");
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
		textField.setText("");
	}
}