/**
 * 
 */
package _2.Diseño.Presentacion.Client;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Presentacion.View.GUI;
import _2.Diseño.Negocio.Client.imp.TClient;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIModifyClient extends GUIClient {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPanel;
	private int idClient;
	private TClient tClient;
	private JTextField textIdClient;
	private JLabel lblDni;
	private JLabel lblName;
	private JLabel lblLastName;
	private JLabel lblPhone;
	private JLabel lblEmail;
	
	private JTextField textDni;
	private JTextField textName;
	private JTextField textLastName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JButton btnModify;

	public GUIModifyClient()
	{
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
		setTitle("Modify Client");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);
		
		JLabel lblIdClient = new JLabel("Id Client:");
		lblIdClient.setBounds(10, 23, 90, 14);
		contentPanel.add(lblIdClient);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 424, 2);
		contentPanel.add(separator);
		
		textIdClient = new JTextField();
		textIdClient.setBounds(140, 20, 150, 20);
		contentPanel.add(textIdClient);
		textIdClient.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int id;
					id = Integer.parseInt(textIdClient.getText());
					idClient = id;
					if (id <= 0) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Wrong information(Id has to be greater than 0)", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						Controller.getInstance().action(new Context(Events.MODIFY_SEARCH_CLIENT, id));
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setBounds(330, 19, 89, 23);
		contentPanel.add(btnSearch);
		
		//Nombre
		lblName = new JLabel("Name:");
		lblName.setBounds(10, 67, 90, 14);
		contentPanel.add(lblName);
		textName = new JTextField();
		textName.setEditable(false);
		textName.setBounds(140, 64, 150, 20);
		contentPanel.add(textName);
		
		//LastName
		lblLastName = new JLabel("Last name:");
		lblLastName.setBounds(10, 98, 90, 14);
		contentPanel.add(lblLastName);
		
		textLastName = new JTextField();
		textLastName.setEditable(false);
		textLastName.setBounds(140, 95, 150, 20);
		contentPanel.add(textLastName);
		
		//DNI
		lblDni = new JLabel("Dni:");
		lblDni.setBounds(10, 129, 90, 14);
		contentPanel.add(lblDni);
		
		textDni = new JTextField();
		textDni.setEditable(false);
		textDni.setBounds(140, 126, 150, 20);
		contentPanel.add(textDni);
		
		//Phone
		lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(10, 157, 118, 14);
		contentPanel.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setEditable(false);
		textPhone.setBounds(140, 157, 150, 20);
		contentPanel.add(textPhone);
		textPhone.setColumns(10);
		
		//Email
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 190, 118, 14);
		contentPanel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setBounds(140, 188, 150, 20);
		contentPanel.add(textEmail);
		
		 btnModify = new JButton("Modify");
		 btnModify.setEnabled(false);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(
					textName.getText().isEmpty()
            		|| textLastName.getText().isEmpty()
            		|| textDni.getText().isEmpty() 
            		|| textPhone.getText().isEmpty() 
            		|| textEmail.getText().isEmpty()
                ) {
                	JOptionPane.showMessageDialog(new JFrame(), "You must fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
                } 
				 else if(!Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", textEmail.getText())) {
                	JOptionPane.showMessageDialog(new JFrame(), "Incorrect email format. Ej: aaa@aaa.com","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(textDni.getText().length() != 9 || Character.isLetter(textDni.getText().charAt(8)) == false) {
                	JOptionPane.showMessageDialog(new JFrame(), "Incorrect dni length or format. ej: 12345678K","Error",JOptionPane.ERROR_MESSAGE);
                }       
                else if(textPhone.getText().length() != 9) {
                	JOptionPane.showMessageDialog(new JFrame(), "Incorrect length phone","Error",JOptionPane.ERROR_MESSAGE);
                } 
                else {                    
                	Controller.getInstance().action(new Context(Events.MODIFY_CLIENT, new TClient(idClient, textName.getText(),textLastName.getText(),textEmail.getText(),textDni.getText(), Integer.parseInt(textPhone.getText()), true)));
                }
			}
		});
		btnModify.setBounds(330, 220, 89, 23);
		contentPanel.add(btnModify);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(330, 190, 89, 23);
		contentPanel.add(btnClose);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void clearData() {
       	textName.setText("");
    	textLastName.setText("");
    	textDni.setText("");
    	textPhone.setText("");
    	textEmail.setText("");  
    	textIdClient.setText("");
		
		textName.setEditable(false);
		textLastName.setEditable(false);
		textDni.setEditable(false);
		textPhone.setEditable(false);			
		textEmail.setEditable(false);
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void update(Context context) {
		switch(context.getEvent()) {

			case Events.MODIFY_CLIENT_OK:
				JOptionPane.showMessageDialog(null, "Client " + context.getDetails() + " successfully modified.");
				
				this.dispose();
				break;
			case Events.MODIFY_CLIENT_KO:
				if((int)context.getDetails() == -1){
					JOptionPane.showMessageDialog(null, "The client with id: " + idClient +  " does not exist");
				}
				else if((int)context.getDetails() == -2){
					JOptionPane.showMessageDialog(null, "The DNI: "+ textDni.getText() + " already exists" );
				}
				else if((int)context.getDetails() == -3){
					JOptionPane.showMessageDialog(null, "The client with id: " + idClient + " it's not active");
				}
				else{
					JOptionPane.showMessageDialog(null, "Error modifying client");
				}
				
				break;
			case Events.MODIFY_SEARCH_CLIENT_OK:
				tClient = (TClient)context.getDetails();			
				btnModify.setEnabled(true);
				textName.setText(tClient.getName());
				textLastName.setText(tClient.getLastName()+"");
				textDni.setText(tClient.getDNI()+"");
				textPhone.setText(tClient.getPhone()+"");
				textEmail.setText(tClient.getEmail()+"");
				
				textName.setEditable(true);
				textLastName.setEditable(true);
				textDni.setEditable(true);
				textPhone.setEditable(true);			
				textEmail.setEditable(true);
				
				break;
			case Events.MODIFY_SEARCH_CLIENT_KO:
				JOptionPane.showMessageDialog(null,"The client with id: " + idClient +  " does not exist");
				break;	
			}
	}
}