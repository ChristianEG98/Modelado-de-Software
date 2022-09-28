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
public class GUICreateClient extends GUIClient {	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPanel;
	
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
	
	public GUICreateClient(){
		super();		
		setResizable(false);
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private void initGUI() {
		setTitle("CREATE CLIENT");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		//Nombre
		lblName = new JLabel("Name:");
		lblName.setBounds(10, 16, 94, 14);
		contentPanel.add(lblName);
		textName = new JTextField();
		textName.setBounds(114, 8, 310, 30);
		contentPanel.add(textName);
		
		//LastName
		lblLastName = new JLabel("Last name:");
		lblLastName.setBounds(10, 53, 94, 14);
		contentPanel.add(lblLastName);
		
		textLastName = new JTextField();
		textLastName.setBounds(114, 45, 310, 30);
		contentPanel.add(textLastName);
		
		//DNI
		lblDni = new JLabel("Dni:");
		lblDni.setBounds(10, 89, 94, 14);
		contentPanel.add(lblDni);
		
		textDni = new JTextField();
		textDni.setBounds(114, 82, 310, 30);
		contentPanel.add(textDni);
		
		//Phone
		lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(10, 126, 118, 14);
		contentPanel.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setBounds(114, 119, 310, 30);
		contentPanel.add(textPhone);
		textPhone.setColumns(10);
		
		//Email
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 163, 118, 14);
		contentPanel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(114, 156, 310, 30);
		contentPanel.add(textEmail);
		
		//ACEPTAR Y Exit
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// VALIDACION
                if(textName.getText().isEmpty()
                		|| textLastName.getText().isEmpty()
                		|| textDni.getText().isEmpty() 
                		|| textPhone.getText().isEmpty() 
                		|| textEmail.getText().isEmpty()
                ) {
                	JOptionPane.showMessageDialog(new JFrame(), "You must fill all the fields");
                } 
                else if(!Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", textEmail.getText())) {
                	JOptionPane.showMessageDialog(new JFrame(), "Incorrect email format.  Ej: aaa@aaa.com");
                }
                else if(textDni.getText().length() != 9 || Character.isLetter(textDni.getText().charAt(8)) == false) {
                	JOptionPane.showMessageDialog(new JFrame(), "Incorrect dni length or format. ej: 12345678K");
                }       
                else if(textPhone.getText().length() != 9) {
                	JOptionPane.showMessageDialog(new JFrame(), "Incorrect length phone");
                } 
                else {                    
                	Controller.getInstance().action(new Context(Events.CREATE_CLIENT,new TClient(textName.getText(),textLastName.getText(),textEmail.getText(),textDni.getText(), Integer.parseInt(textPhone.getText()), true)));
                }
            }
        });
		
		btnCreate.setBounds(335, 220, 89, 23);
		contentPanel.add(btnCreate);
		
		JButton btnExit = new JButton("Close");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(20, 220, 89, 23);
		contentPanel.add(btnExit);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void clearData() {   
    	textName.setText("");
    	textDni.setText("");
    	textLastName.setText("");
    	textEmail.setText("");
    	textPhone.setText("");    	
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void update(Context context) {
		switch(context.getEvent()){
	        case Events.CREATE_CLIENT_OK:
	            JOptionPane.showMessageDialog(null, "Client " + context.getDetails() + " create.");
	            this.dispose();
            break;
	        case Events.CREATE_CLIENT_KO:
	            if((int)context.getDetails() == -1){
	                JOptionPane.showMessageDialog(null, "The client already exists.");
	            }
	            else
	                JOptionPane.showMessageDialog(null, "Error creating client");
            break;
        }
	}	
	
}