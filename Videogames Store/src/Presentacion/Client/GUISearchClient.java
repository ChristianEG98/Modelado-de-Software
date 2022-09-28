/**
 * 
 */
package _2.Diseño.Presentacion.Client;

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
import _2.Diseño.Negocio.Client.imp.TClient;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUISearchClient extends GUIClient {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPanel;
	
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
	private JTextField activeType;
	private JTextField nonActiveType;
	
	public GUISearchClient(){
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
		setTitle("Search Client");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 350);
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
					if (id <= 0) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Wrong information (Id has to be greater than 0)", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						Controller.getInstance().action(new Context(Events.SEARCH_CLIENT, id));
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
		
		JLabel lblEstado = new JLabel("Active:");
		lblEstado.setBounds(10, 225, 120, 14);
		contentPanel.add(lblEstado);
		
		activeType = new JTextField();
		activeType.setEditable(false);
		activeType.setBounds(140, 223, 150, 20);
		activeType.setBackground(Color.GREEN);
		contentPanel.add(activeType);
		activeType.setColumns(10);
		
		nonActiveType = new JTextField();
		nonActiveType.setEditable(false);
		nonActiveType.setBounds(140, 223, 150, 20);
		nonActiveType.setBackground(Color.RED);
		contentPanel.add(nonActiveType);
		nonActiveType.setColumns(10);
		
		JButton btnOk = new JButton("Close");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOk.setBounds(330, 280, 89, 23);
		contentPanel.add(btnOk);
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
    	activeType.setVisible(false);
    	nonActiveType.setVisible(false);
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void update(Context context) {
		switch(context.getEvent()){
		case Events.SEARCH_CLIENT_OK:
			TClient tClient = (TClient)context.getDetails();
			
			textName.setText(tClient.getName());
			textLastName.setText(tClient.getLastName()+"");
			textDni.setText(tClient.getDNI()+"");
			textPhone.setText(tClient.getPhone()+"");
			textEmail.setText(tClient.getEmail()+"");
			
			if(tClient.getActive()){
		    	activeType.setVisible(true);
		    	nonActiveType.setVisible(false);
			}
			else{
		    	activeType.setVisible(false);
		    	nonActiveType.setVisible(true);
			}
			break;
		case Events.SEARCH_CLIENT_KO:
			JOptionPane.showMessageDialog(null, "Error to find client");
			break;
		}
	}
}