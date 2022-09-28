/**
 * 
 */
package _2.Diseño.Presentacion.Client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GUIClientImp extends GUIClient {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUIListClient gUIListingClient;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUISearchClient gUISearchClient;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUICreateClient gUICreateClient;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUIDeleteClient gUIDeleteClient;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUIModifyClient gUIModifyClient;
	
	private GUICustomersWhoHaveMadeMoreThan_X_Purchases gUIMorePurchases;
	
	private JPanel contentPanel;
	JButton buttonCreateClient;
	JButton buttonDeleteClient;
	JButton buttonModifyClient;
	JButton buttonSearchClient;
	JButton buttonListClient;
	JButton buttonMorePurchases;
	
	public GUIClientImp() {
		super();
		this.contentPanel = new JPanel();
		this.gUICreateClient = new GUICreateClient();
		this.gUIDeleteClient = new GUIDeleteClient();
		this.gUIModifyClient = new GUIModifyClient();
		this.gUIListingClient = new GUIListClient();
		this.gUISearchClient = new GUISearchClient();
		this.gUIMorePurchases = new GUICustomersWhoHaveMadeMoreThan_X_Purchases();
		setResizable(false);
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		this.setTitle("CLIENTS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(192, 217, 252));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		//CREATE CLIENT
		buttonCreateClient = new JButton("CREATE CLIENT");
		buttonCreateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUICreateClient.clearData();
				gUICreateClient.setVisible(true); 
			}
		});
		buttonCreateClient.setBounds(10, 30, 200, 45);
		contentPanel.add(buttonCreateClient );
		
		//DELETE CLIENT
		buttonDeleteClient = new JButton("DELETE CLIENT");
		buttonDeleteClient .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIDeleteClient.clearData(); 
				gUIDeleteClient.setVisible(true); 
			}
		});
		buttonDeleteClient.setBounds(224, 30, 200, 45);
		contentPanel.add(buttonDeleteClient);
		
		//MODIFY CLIENT
		buttonModifyClient = new JButton("MODIFY CLIENT");
		buttonModifyClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIModifyClient.clearData();
				gUIModifyClient.setVisible(true);
			}
		});
		buttonModifyClient.setBounds(10, 90, 200, 45);
		contentPanel.add(buttonModifyClient);
		
		//SEARCH CLIENT
		buttonSearchClient = new JButton("SEARCH CLIENT");
		buttonSearchClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUISearchClient.clearData();
				gUISearchClient.setVisible(true);
			}
		});
		buttonSearchClient.setBounds(224, 90, 200, 45);
		contentPanel.add(buttonSearchClient);
		
		//LIST CLIENT
		buttonListClient = new JButton("LIST CLIENTS");
		buttonListClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIListingClient.clearData();
				gUIListingClient.setVisible(true);
				Controller.getInstance().action(new Context(Events.LIST_CLIENTS, null));
				gUIListingClient.toFront();
			}
		});
		buttonListClient.setBounds(10, 150, 414, 45);
		contentPanel.add(buttonListClient);
		
		//CUSTOMERS WHO HAVE MADE MORE THAN X PURCHASES
		buttonMorePurchases = new JButton("CUSTOMERS WHO HAVE MADE MORE THAN X PURCHASES");
		buttonMorePurchases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIMorePurchases.clearData();
				gUIMorePurchases.setVisible(true);
//				Controller.getInstance().action(new Context(Events.CUSTOMERS_MORE_X_PURCHASES, null));
//				gUIMorePurchases.toFront();
			}
		});
		buttonMorePurchases.setBounds(10, 210, 414, 45);
		contentPanel.add(buttonMorePurchases);
		
		JButton btMainMenu = new JButton("MAIN MENU");
		btMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int option = JOptionPane.showOptionDialog(new JFrame(),
							"Are you sure to return to the main menu?", "Quit",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.YES_NO_OPTION, null, null, null);
					if (option == JOptionPane.YES_OPTION){
				dispose();
					}
			}
		});
		btMainMenu.setBounds(115, 270, 200, 45);
		contentPanel.add(btMainMenu);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	@Override
	public void update(Context context) {
		switch(context.getEvent()){
		case Events.CREATE_CLIENT_OK:
			gUICreateClient.update(context);
			break;
		case Events.CREATE_CLIENT_KO:
			gUICreateClient.update(context);
			break;
		case Events.LIST_CLIENTS_OK:
			gUIListingClient.update(context);
			break;
		case Events.LIST_CLIENTS_KO:
			gUIListingClient.update(context);
			break;
		case Events.DELETE_CLIENT_OK:
			gUIDeleteClient.update(context);
			break;
		case Events.DELETE_CLIENT_KO:
			gUIDeleteClient.update(context);
			break;
		case Events.SEARCH_CLIENT_OK:
			gUISearchClient.update(context);
			break;
		case Events.SEARCH_CLIENT_KO:
			gUISearchClient.update(context);
			break;
		case Events.MODIFY_CLIENT_OK:
			gUIModifyClient.update(context);
			break;
		case Events.MODIFY_CLIENT_KO:
			gUIModifyClient.update(context);
			break;
		case Events.MODIFY_SEARCH_CLIENT_OK:
			gUIModifyClient.update(context);
			break;
		case Events.MODIFY_SEARCH_CLIENT_KO:
			gUIModifyClient.update(context);
			break;
		case Events.CUSTOMERS_MORE_X_PURCHASES_OK:
			gUIMorePurchases.update(context);
			break;
		case Events.CUSTOMERS_MORE_X_PURCHASES_KO:
			gUIMorePurchases.update(context);
			break;
	}
	}
}