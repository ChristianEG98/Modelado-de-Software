/**
 * 
 */
package _2.Diseño.Presentacion.Client;

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
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIDeleteClient extends GUIClient {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JTextField textField;

	public GUIDeleteClient(){
		super();
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private void initGUI() {
		setTitle("DELETE CLIENT");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 250, 200);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);
		
		JButton btnRemove = new JButton("Delete");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int idClient;
					
					idClient = Integer.parseInt(textField.getText());
					
					if(idClient <= 0){
						JOptionPane.showMessageDialog(new JFrame(), "Error, the id has to be greater than 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else{
						int option = JOptionPane.showOptionDialog(new JFrame(),
								"Are you sure to delete this client?", "Quit",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.YES_NO_OPTION, null, null, null);
						if (option == JOptionPane.YES_OPTION){
						Controller.getInstance().action(new Context(Events.DELETE_CLIENT, idClient));
						}
					}
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRemove.setBounds(70, 80,120,30);
		contentPanel.add(btnRemove);
		
		JLabel lblId = new JLabel("ID Client:");
		lblId.setBounds(40, 50, 55, 14);
		contentPanel.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(90, 48, 96, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnCancel = new JButton("Close");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(70, 120, 120,30);
		contentPanel.add(btnCancel);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void clearData() {
		textField.setText("");
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void update(Context context) {
		switch(context.getEvent()){
		case Events.DELETE_CLIENT_OK:
			JOptionPane.showMessageDialog(null, "Client " + context.getDetails() + " removed successfully.");
			this.dispose();
			break;
		case Events.DELETE_CLIENT_KO:
			if((int)context.getDetails() == -1){
				JOptionPane.showMessageDialog(null, "The indicated client does not exist");
			}
			else if((int)context.getDetails() == -2){
				JOptionPane.showMessageDialog(null, "The indicated customer has been deleted");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error to delete client");
			}
			break;
		}
	}
}